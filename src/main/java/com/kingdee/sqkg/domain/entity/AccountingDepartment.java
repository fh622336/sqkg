package com.kingdee.sqkg.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class AccountingDepartment {
    private  String number;
    private  String fname;
    private  String fstatus;
    private  String level;
    private  String parentNumber;
}
