package com.kingdee.sqkg.task;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kingdee.sqkg.domain.entity.*;
import com.kingdee.sqkg.mapper.TOrgBaseunitMapper;
import com.kingdee.sqkg.util.easUtil;
import com.kingdee.sqkg.util.esbMdmUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScheduledTask {
    private Logger logger = LoggerFactory.getLogger(ScheduledTask.class);
    @Value(value = "${mdm.banl.path}")
    String bankUrl;
    @Value(value = "${mdm.department.path}")
    String departMentUrl;
    @Value(value = "${eas.unit.path}")
    String unitUrl;
    @Value(value = "${eas.login.path}")
    String loginUrl;
    @Value(value = "${eas.admin.path}")
    String adminpath;
    @Autowired
    private TOrgBaseunitMapper baseunitMapper;

    //    // cron接受cron表达式，根据cron表达式确定定时规则
    @Scheduled(cron = "0 */1 * * * ?")  //每5秒执行一次
    public void testCron() throws Exception {
        String sessionId = easUtil.getSessionId(loginUrl);
        List<BeAccountBank> bankList = esbMdmUtil.bankAccountQuery(bankUrl, "", "eas:welcome1");
        System.err.println("bankList:::"+bankList);
        List<BeAccountBank> collect = bankList.stream()
                .filter(s ->s.getFstatus() .equals("1"))
                .collect(Collectors.toList());
        System.err.println("collect:::"+collect);
//        for (BeAccountBank bank : collect) {
//             String result = JSON.toJSONString(bank);
//             String bankResult = easUtil.addBank(result, sessionId);
//             System.err.println(bankResult);
//        }
    }

  //  @Scheduled(cron = "0/1 * * * * ? ")  //每1秒执行一次
    public void testCron1() throws Exception {
        System.err.println(unitUrl);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = simpleDateFormat.format(new Date());
        String sessionId = easUtil.getSessionId(loginUrl);
        List<AccountingDepartment> departmentList = esbMdmUtil.accountingDepartmentQuery(departMentUrl, "", "eas:welcome1");
        for (AccountingDepartment department : departmentList) {
            String level = department.getLevel();
            String parentNumber = department.getParentNumber();
            String number = department.getNumber();
            if (StringUtils.equals(level, "1") || StringUtils.equals(level, "2")) {
                QueryWrapper<TOrgBaseunit> baseunitParentQueryWrapper = new QueryWrapper<>();
                baseunitParentQueryWrapper.eq("fnumber", parentNumber);
                TOrgBaseunit orgBaseUnit = baseunitMapper.selectOne(baseunitParentQueryWrapper);
                if (org.springframework.util.StringUtils.isEmpty(orgBaseUnit)) {
                    System.err.println("上级组织编码不存在！" + parentNumber);
                } else {
                    QueryWrapper<TOrgBaseunit> baseunitQueryWrapper = new QueryWrapper<>();
                    baseunitQueryWrapper.eq("fnumber", number);
                    TOrgBaseunit tOrgBaseunit = baseunitMapper.selectOne(baseunitQueryWrapper);
                    if (org.springframework.util.StringUtils.isEmpty(tOrgBaseunit)) {
                        System.err.println("组织编码不存在！允许新增:" + number);
                        String paramS = "<![CDATA[<DataInfo bostype=\"CCE7AED4\" op=\"4\">" +
                                "<DataHead><creator>user</creator><CU>" + number.substring(0, 3) + "</CU>" +
                                "<parent>" + parentNumber + "</parent>" +
                                "<name>" + department.getFname() + "</name>" +
                                "<number>" + number + "</number></DataHead>" +
                                "</DataInfo>]]>";
                        String orgResult = easUtil.addBaseUnit(sessionId, paramS, unitUrl);
                        String adminResult = easUtil.addAdminOrg(number, parentNumber, createTime, adminpath, sessionId);
                        String relationResult = easUtil.addUnitRelation(number, number.substring(0, 3), adminpath, sessionId);
                    }
                }
            }
        }
    }

    //@Scheduled(cron = "0/2 * * * * ? ")  //每2秒执行一次
    public void testCron2() {
    }
//            @Scheduled(cron="0/3 * * * * ? ")  //每3秒执行一次
//            public void testCron3() {
//                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                logger.info(sdf.format(new Date())+"*********每3秒执行一次");
//            }
//            @Scheduled(cron="0/4 * * * * ? ")  //每4秒执行一次
//            public void testCron4() {
//                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                logger.info(sdf.format(new Date())+"*********每4秒执行一次");
//            }
}
