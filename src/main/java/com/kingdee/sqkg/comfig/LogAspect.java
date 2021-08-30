package com.kingdee.sqkg.comfig;

import com.alibaba.fastjson.JSON;
import com.kingdee.sqkg.domain.entity.RequestErrorInfo;
import com.kingdee.sqkg.domain.entity.RequestInfo;
import eu.bitwalker.useragentutils.UserAgent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class LogAspect {
    private final static Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.kingdee.sqkg.controller..*(..))")
    public void requestServer() {
    }

//    @Autowired
//    private WeblogMapper weblogMapper;

    @Around("requestServer()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        LOGGER.info("===============================开始拦截请求========================");
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        Object result = proceedingJoinPoint.proceed();
        RequestInfo requestInfo = RequestInfo.builder()
                .ip(request.getRemoteAddr()).
                        url(request.getRequestURL().toString()).
                        httpMethod(request.getMethod()).
                        classMethod(String.format("%s.%s", proceedingJoinPoint.getSignature().getDeclaringTypeName(),
                                proceedingJoinPoint.getSignature().getName())).
                        requestParams(getRequestParamsByProceedingJoinPoint(proceedingJoinPoint)).
                        result(result).
                        timeCost(System.currentTimeMillis() - start).build();
        LOGGER.info("Request Info      : {}", JSON.toJSONString(requestInfo));
        LOGGER.info("===============================结束拦截请求========================");
        return result;
    }


    @AfterThrowing(pointcut = "requestServer()", throwing = "e")
    public void doAfterThrow(JoinPoint joinPoint, RuntimeException e) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        RequestErrorInfo requestErrorInfo = RequestErrorInfo.builder()
                .ip(request.getRemoteAddr()).url(request.getRequestURL().toString()).
                        httpMethod(request.getMethod()).
                        classMethod(String.format("%s.%s", joinPoint.getSignature().getDeclaringTypeName(),
                                joinPoint.getSignature().getName())).
                        requestParams(getRequestParamsByJoinPoint(joinPoint))
                .exception(e).build();
        LOGGER.info("Error Request Info      : {}", JSON.toJSONString(requestErrorInfo));
    }

    /**
     * 获取入参
     * @param proceedingJoinPoint
     *
     * @return
     * */
    private Map<String, Object> getRequestParamsByProceedingJoinPoint(ProceedingJoinPoint proceedingJoinPoint) {
        //参数名
        String[] paramNames = ((MethodSignature)proceedingJoinPoint.getSignature()).getParameterNames();
        //参数值
        Object[] paramValues = proceedingJoinPoint.getArgs();
        return buildRequestParam(paramNames, paramValues);
    }

    private Map<String, Object> getRequestParamsByJoinPoint(JoinPoint joinPoint) {
        //参数名
        String[] paramNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
        //参数值
        Object[] paramValues = joinPoint.getArgs();

        return buildRequestParam(paramNames, paramValues);
    }

    private Map<String, Object> buildRequestParam(String[] paramNames, Object[] paramValues) {
        Map<String, Object> requestParams = new HashMap<>();
        for (int i = 0; i < paramNames.length; i++) {
            Object value = paramValues[i];

            //如果是文件对象
            if (value instanceof MultipartFile) {
                MultipartFile file = (MultipartFile) value;
                value = file.getOriginalFilename();  //获取文件名
            }

            requestParams.put(paramNames[i], value);
        }

        return requestParams;
    }

}
