package com.kingdee.sqkg.comfig;

import com.kingdee.sqkg.domain.entity.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
public class GlobalExceptionHandlerEx {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandlerEx.class);

    @ExceptionHandler(value= Exception.class)
    @ResponseBody
    public Response ExceptionErrorHandler(Exception   ex) throws Exception {
        StringBuilder sb = new StringBuilder();
        String message = ex.getMessage();
        sb.append(message);
        logger.error("Exception info:{}",ex.getMessage());
        return Response.fail(201,sb.toString(),null);
    }

    @ExceptionHandler(value= BindException.class)
    @ResponseBody
    public Response bindExceptionErrorHandler(BindException ex) throws Exception {
        StringBuilder sb = new StringBuilder();
        FieldError fieldError = ex.getFieldError();
        sb.append(fieldError.getDefaultMessage());
        logger.error("myExceptionErrorHandler info:{}",ex.getMessage());
       return Response.fail(201,sb.toString(),null);
    }
}
