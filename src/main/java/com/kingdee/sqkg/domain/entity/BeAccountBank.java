package com.kingdee.sqkg.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class BeAccountBank {
    private  String number;
    private  String fname;
    private  String fstatus;
    //银行帐号
    private  String accountNumber;
    //组织编码
    private String  adminNumber;
    //开户行
    private String  openingBank;
    //开户行行号
    private String  bankNumber;
    //开户日期
    private String  date;
    //币种
    private String  currenyName;
}
