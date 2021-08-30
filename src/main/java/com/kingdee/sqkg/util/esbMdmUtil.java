package com.kingdee.sqkg.util;

import com.kingdee.sqkg.domain.entity.AccountingDepartment;
import com.kingdee.sqkg.domain.entity.BeAccountBank;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

public class esbMdmUtil {
    private final static Logger logger = LoggerFactory.getLogger(esbMdmUtil.class);
 //
       public  static    List<BeAccountBank>   bankAccountQuery(String url,String param,String password){
           String result="";
           List<BeAccountBank> bankList=new ArrayList<>();
           String params="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:v1=\"http://www.sxqc.com/osb/MasterDataSB/BankAccountQuery/Mdm/Schema/v1.0-GET\">\n" +
                   "   <soapenv:Header/>\n" +
                   "   <soapenv:Body>\n" +
                   "      <v1:Request>\n" +
                   "         <v1:ESB>\n" +
                   "            <v1:DATA>\n" +
                   "               <v1:DATAINFOS>\n" +
                   "                  <!--1 or more repetitions:-->\n" +
                   "                  <v1:DATAINFO>\n" +
                   "                     <v1:CODE></v1:CODE>\n" +
                   "                     <v1:DESC5></v1:DESC5>\n" +
                   "                     <v1:DESC6></v1:DESC6>\n" +
                   "                     <v1:DESC10>岐山县支行</v1:DESC10>\n" +
                   "                     <v1:LASTMODIFYRECORDTIME>" +"2021-01-01 00:00:00~2021-08-25 16:18:45"+"</v1:LASTMODIFYRECORDTIME>\n"+
                   "                     <v1:UUID></v1:UUID>\n" +
                   "                  </v1:DATAINFO>\n" +
                   "                  <v1:PUUID></v1:PUUID>\n" +
                   "               </v1:DATAINFOS>\n" +
                   "               <v1:SPLITPAGE>\n" +
                   "                  <v1:COUNTPERPAGE>100</v1:COUNTPERPAGE>\n" +
                   "                  <v1:CURRENTPAGE>1</v1:CURRENTPAGE>\n" +
                   "               </v1:SPLITPAGE>\n" +
                   "            </v1:DATA>\n" +
                   "         </v1:ESB>\n" +
                   "      </v1:Request>\n" +
                   "   </soapenv:Body>\n" +
                   "</soapenv:Envelope>";
       try {
           result = HttpUtil.sendclientPost(url, params, password);
           if (StringUtils.isEmpty(result)){
               return  bankList;
           }
           Document doc = DocumentHelper.parseText(result);
           Element root = doc.getRootElement();
           Element head = root.element("Body");
           Element element = head.element("Response");
           Element esb = element.element("ESB");
           Element data = esb.element("DATA");
           Element INFOS = data.element("DATAINFOS");
           List<Element> elements = INFOS.elements("DATAINFO");
           for (int i=0;i<elements.size();i++){
               BeAccountBank beAccountBank=   BeAccountBank.builder().number( elements.get(i).element("FAccountBankId").getTextTrim()).
                       fname( elements.get(i).element("FName").getTextTrim()
                       ).fstatus(elements.get(i).element("DESC14").
                       getTextTrim()).accountNumber(elements.get(i).element("DESC7").
                       getTextTrim()).adminNumber(elements.get(i).element("DESC1").
                       getTextTrim()).openingBank(elements.get(i).element("DESC10").
                       getTextTrim()).bankNumber(elements.get(i).element("DESC11").
                       getTextTrim()).date(elements.get(i).element("DESC12").
                       getTextTrim()).currenyName(elements.get(i).element("DESC17").
                       getTextTrim()).build();
               bankList.add(beAccountBank);
           }
           return  bankList;
       }catch (Exception ex) {
           logger.info("获取主数据银行信息有误,报错信息为:" + ex.getMessage());
           return bankList;
       }
    }


    public  static    List<AccountingDepartment>   accountingDepartmentQuery(String url, String param, String password){
        String result="";
        List<AccountingDepartment> departmentList=new ArrayList<>();
        String params="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:v1=\"http://www.sxqc.com/osb/MasterDataSB/AccountingOrgQuery/Mdm/Schema/v1.0-GET\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <v1:Request>\n" +
                "         <v1:ESB>\n" +
                "            <v1:DATA>\n" +
                "               <v1:DATAINFOS>\n" +
                "                  <!--1 or more repetitions:-->\n" +
                "                  <v1:DATAINFO>\n" +
                "                     <v1:CODE></v1:CODE>\n" +
                "                     <v1:DESC1></v1:DESC1>\n" +
                "                     <v1:DESC10></v1:DESC10>\n" +
                "                     <v1:DESC15></v1:DESC15>\n" +
                "                     <v1:DESC19></v1:DESC19>\n" +
                "                     <v1:LASTMODIFYRECORDTIME>2021-08-26 00:00:00~2021-08-27 16:18:45</v1:LASTMODIFYRECORDTIME>\n" +
                "                     <v1:PARENTCODE></v1:PARENTCODE>\n" +
                "                     <v1:UUID></v1:UUID>\n" +
                "                  </v1:DATAINFO>\n" +
                "                  <v1:PUUID></v1:PUUID>\n" +
                "               </v1:DATAINFOS>\n" +
                "               <v1:SPLITPAGE>\n" +
                "                  <v1:COUNTPERPAGE></v1:COUNTPERPAGE>\n" +
                "                  <v1:CURRENTPAGE></v1:CURRENTPAGE>\n" +
                "               </v1:SPLITPAGE>\n" +
                "            </v1:DATA>\n" +
                "         </v1:ESB>\n" +
                "      </v1:Request>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        try {
            result = HttpUtil.sendclientPost(url, params, password);
            Document doc = DocumentHelper.parseText(result);
            Element root = doc.getRootElement();
            Element head = root.element("Body");
            Element element = head.element("Response");
            Element esb = element.element("ESB");
            Element data = esb.element("DATA");
            Element INFOS = data.element("DATAINFOS");
            List<Element> elements = INFOS.elements("DATAINFO");
            for (int i=0;i<elements.size();i++){
                AccountingDepartment departMent = AccountingDepartment.builder().number(elements.get(i).
                        element("CODE").getTextTrim()).
                        fname(elements.get(i).element("FName").getTextTrim()).fstatus(elements.get(i).element("FIsStart").getTextTrim()).
                        level(elements.get(i).element("DESC15").getTextTrim())
                        .parentNumber(elements.get(i).element("PARENTCODE").getTextTrim()).build();
                departmentList.add(departMent);
            }
            return  departmentList;
        }catch (Exception ex) {
            logger.info("获取主数据银行信息有误,报错信息为:" + ex.getMessage());
            return departmentList;
        }
    }
}
