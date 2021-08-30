package com.kingdee.sqkg.domain.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 樊浩
 * @since 2021-08-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("T_ORG_ADMIN")
public class TOrgAdmin extends Model<TOrgAdmin> {

    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @TableId("FID")
    private String fid;
    @JsonIgnore
    @TableField("FNAME_L1")
    private String fnameL1;

    @TableField("FNAME_L2")
    private String fnameL2;
    @JsonIgnore
    @TableField("FNAME_L3")
    private String fnameL3;

    @TableField("FNUMBER")
    private String fnumber;
    @JsonIgnore
    @TableField("FDESCRIPTION_L1")
    private String fdescriptionL1;
    @JsonIgnore
    @TableField("FDESCRIPTION_L2")
    private String fdescriptionL2;
    @JsonIgnore
    @TableField("FDESCRIPTION_L3")
    private String fdescriptionL3;
    @JsonIgnore
    @TableField("FSIMPLENAME")
    private String fsimplename;
    @JsonIgnore
    @TableField("FISGROUPING")
    private Long fisgrouping;
    @JsonIgnore
    @TableField("FEFFECTDATE")
    private LocalDateTime feffectdate;
    @JsonIgnore
    @TableField("FINVALIDDATE")
    private LocalDateTime finvaliddate;
    @JsonIgnore
    @TableField("FISFREEZE")
    private Long fisfreeze;
    @JsonIgnore
    @TableField("FISCOMPANYORGUNIT")
    private Long fiscompanyorgunit;
    @JsonIgnore
    @TableField("FISADMINORGUNIT")
    private Long fisadminorgunit;
    @JsonIgnore
    @TableField("FISSALEORGUNIT")
    private Long fissaleorgunit;
    @JsonIgnore
    @TableField("FISPURCHASEORGUNIT")
    private Long fispurchaseorgunit;
    @JsonIgnore
    @TableField("FISSTORAGEORGUNIT")
    private Long fisstorageorgunit;
    @JsonIgnore
    @TableField("FISPROFITORGUNIT")
    private Long fisprofitorgunit;
    @JsonIgnore
    @TableField("FISCOSTORGUNIT")
    private Long fiscostorgunit;
    @JsonIgnore
    @TableField("FISCU")
    private Long fiscu;
    @JsonIgnore
    @TableField("FISUNION")
    private Long fisunion;
    @JsonIgnore
    @TableField("FISHRORGUNIT")
    private Long fishrorgunit;
    @JsonIgnore
    @TableField("FCREATORID")
    private String fcreatorid;
    @JsonIgnore
    @TableField("FCREATETIME")
    private LocalDateTime fcreatetime;
    @JsonIgnore
    @TableField("FLASTUPDATEUSERID")
    private String flastupdateuserid;
    @JsonIgnore
    @TableField("FLASTUPDATETIME")
    private LocalDateTime flastupdatetime;
    @JsonIgnore
    @TableField("FCONTROLUNITID")
    private String fcontrolunitid;
    @JsonIgnore
    @TableField("FISLEAF")
    private Long fisleaf;
    @JsonIgnore
    @TableField("FLEVEL")
    private Long flevel;
    @JsonIgnore
    @TableField("FLONGNUMBER")
    private String flongnumber;
    @JsonIgnore
    @TableField("FPARENTID")
    private String fparentid;
    @JsonIgnore
    @TableField("FISENTITY")
    private Long fisentity;
    @JsonIgnore
    @TableField("FISVIRTUAL")
    private Long fisvirtual;
    @JsonIgnore
    @TableField("FPHONENUMBER")
    private String fphonenumber;
    @JsonIgnore
    @TableField("FLAYERID")
    private String flayerid;
    @JsonIgnore
    @TableField("FRESPONPOSITIONID")
    private String fresponpositionid;
    @JsonIgnore
    @TableField("FADDRESSID")
    private String faddressid;
    @JsonIgnore
    @TableField("FPRINCIPALID")
    private String fprincipalid;
    @JsonIgnore
    @TableField("FLAYERTYPEID")
    private String flayertypeid;
    @JsonIgnore
    @TableField("FBASEDUTY_L1")
    private String fbasedutyL1;
    @JsonIgnore
    @TableField("FBASEDUTY_L2")
    private String fbasedutyL2;
    @JsonIgnore
    @TableField("FBASEDUTY_L3")
    private String fbasedutyL3;
    @JsonIgnore
    @TableField("FINDEX")
    private Long findex;
    @JsonIgnore
    @TableField("FJOBSYSTEMID")
    private String fjobsystemid;
    @JsonIgnore
    @TableField("FADMINADDRESS_L1")
    private String fadminaddressL1;
    @JsonIgnore
    @TableField("FADMINADDRESS_L2")
    private String fadminaddressL2;
    @JsonIgnore
    @TableField("FADMINADDRESS_L3")
    private String fadminaddressL3;
    @JsonIgnore
    @TableField("FZIPCODE")
    private String fzipcode;
    @JsonIgnore
    @TableField("FFAX")
    private String ffax;
    @JsonIgnore
    @TableField("FISSEALUP")
    private Long fissealup;
    @JsonIgnore
    @TableField("FISSTART")
    private Long fisstart;
    @JsonIgnore
    @TableField("FISOUSEALUP")
    private Long fisousealup;
    @JsonIgnore
    @TableField("FDISPLAYNAME_L1")
    private String fdisplaynameL1;
    @JsonIgnore
    @TableField("FDISPLAYNAME_L2")
    private String fdisplaynameL2;
    @JsonIgnore
    @TableField("FDISPLAYNAME_L3")
    private String fdisplaynameL3;
    @JsonIgnore
    @TableField("FPROPERTYSEALUPDATE")
    private LocalDateTime fpropertysealupdate;
    @JsonIgnore
    @TableField("FVERSIONNUMBER")
    private String fversionnumber;
    @JsonIgnore
    @TableField("FCODE")
    private String fcode;
    @JsonIgnore
    @TableField("FISTRANSPORTORGUNIT")
    private Long fistransportorgunit;
    @JsonIgnore
    @TableField("FISQUALITYORGUNIT")
    private Long fisqualityorgunit;
    @JsonIgnore
    @TableField("FSORTCODE")
    private String fsortcode;
    @JsonIgnore
    @TableField("FINDUSTRYID")
    private String findustryid;
    @JsonIgnore
    @TableField("FECONOMICTYPE")
    private Long feconomictype;
    @JsonIgnore
    @TableField("FREGISTEREDCAPITAL")
    private BigDecimal fregisteredcapital;
    @JsonIgnore
    @TableField("FREGISTEREDCODE")
    private String fregisteredcode;
    @JsonIgnore
    @TableField("FSETUPDATE")
    private LocalDateTime fsetupdate;
    @JsonIgnore
    @TableField("FENDUPDATE")
    private LocalDateTime fendupdate;
    @JsonIgnore
    @TableField("FTAXNUMBER")
    private String ftaxnumber;
    @JsonIgnore
    @TableField("FISCHURCHYARD")
    private Long fischurchyard;
    @JsonIgnore
    @TableField("FJURIDICALPERSONID")
    private String fjuridicalpersonid;
    @JsonIgnore
    @TableField("FISJURIDICALCOMPANY")
    private Long fisjuridicalcompany;
    @JsonIgnore
    @TableField("FISINDEPENDENCE")
    private Long fisindependence;
    @JsonIgnore
    @TableField("FTERRITORY_L1")
    private String fterritoryL1;
    @JsonIgnore
    @TableField("FTERRITORY_L2")
    private String fterritoryL2;
    @JsonIgnore
    @TableField("FTERRITORY_L3")
    private String fterritoryL3;
    @JsonIgnore
    @TableField("FORGCODE")
    private String forgcode;
    @JsonIgnore
    @TableField("FAREAID")
    private String fareaid;
    @JsonIgnore
    @TableField("FORGPROPERTYID")
    private String forgpropertyid;
    @JsonIgnore
    @TableField("FREGISTTYPEID")
    private String fregisttypeid;
    @JsonIgnore
    @TableField("FEFFDT")
    private LocalDateTime feffdt;
    @JsonIgnore
    @TableField("FLEFFDT")
    private LocalDateTime fleffdt;
    @JsonIgnore
    @TableField("FHISTORYRELATEID")
    private String fhistoryrelateid;
    @JsonIgnore
    @TableField("FDELEGATEHRID")
    private String fdelegatehrid;
    @JsonIgnore
    @TableField("FORGFUNCTIONID")
    private String forgfunctionid;
    @JsonIgnore
    @TableField("FCOMPANYID")
    private String fcompanyid;
    @JsonIgnore
    @TableField("FDEPARTMENTID")
    private String fdepartmentid;
    @JsonIgnore
    @TableField("FOFFICEID")
    private String fofficeid;
    @JsonIgnore
    @TableField("FLEVELFOURGROUPID")
    private String flevelfourgroupid;
    @JsonIgnore
    @TableField("FLEVELFIVEGROUPID")
    private String flevelfivegroupid;
    @JsonIgnore
    @TableField("FLEVELFIVEGROUP")
    private String flevelfivegroup;
    @JsonIgnore
    @TableField("FLEVELSIXGROUPID")
    private String flevelsixgroupid;
    @JsonIgnore
    @TableField("FRESERVEFIELDFIRST")
    private String freservefieldfirst;
    @JsonIgnore
    @TableField("FRESERVEFIELDSECOND")
    private String freservefieldsecond;
    @JsonIgnore
    @TableField("FRESERVEITEMFIRST")
    private String freserveitemfirst;
    @JsonIgnore
    @TableField("FRESERVEITEMSECOND")
    private String freserveitemsecond;
    @JsonIgnore
    @TableField("FISSTARTSHR")
    private Long fisstartshr;
    @JsonIgnore
    @TableField("FORGTYPESTR")
    private String forgtypestr;
    @JsonIgnore
    @TableField("FLEVELONEGROUPID")
    private String flevelonegroupid;
    @JsonIgnore
    @TableField("FLEVELTWOGROUPID")
    private String fleveltwogroupid;


    @Override
    protected Serializable pkVal() {
        return this.fid;
    }

}
