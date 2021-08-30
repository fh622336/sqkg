package com.kingdee.sqkg.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
@TableName("T_BD_BANK")
public class TBdBank extends Model<TBdBank> {

    private static final long serialVersionUID = 1L;

    @TableId("FID")
    private String fid;

    @TableField("FCREATORID")
    private String fcreatorid;

    @TableField("FCREATETIME")
    private LocalDateTime fcreatetime;

    @TableField("FLASTUPDATEUSERID")
    private String flastupdateuserid;

    @TableField("FLASTUPDATETIME")
    private LocalDateTime flastupdatetime;

    @TableField("FCONTROLUNITID")
    private String fcontrolunitid;

    @TableField("FNAME_L1")
    private String fnameL1;

    @TableField("FNAME_L2")
    private String fnameL2;

    @TableField("FNAME_L3")
    private String fnameL3;

    @TableField("FNUMBER")
    private String fnumber;

    @TableField("FDESCRIPTION_L1")
    private String fdescriptionL1;

    @TableField("FDESCRIPTION_L2")
    private String fdescriptionL2;

    @TableField("FDESCRIPTION_L3")
    private String fdescriptionL3;

    @TableField("FSIMPLENAME")
    private String fsimplename;

    @TableField("FISLEAF")
    private Long fisleaf;

    @TableField("FLEVEL")
    private Long flevel;

    @TableField("FLONGNUMBER")
    private String flongnumber;

    @TableField("FDISPLAYNAME_L1")
    private String fdisplaynameL1;

    @TableField("FDISPLAYNAME_L2")
    private String fdisplaynameL2;

    @TableField("FDISPLAYNAME_L3")
    private String fdisplaynameL3;

    @TableField("FADDRESS")
    private String faddress;

    @TableField("FPHONE")
    private String fphone;

    @TableField("FLINKMAN")
    private String flinkman;

    @TableField("FFAX")
    private String ffax;

    @TableField("FBANKAREATYPE")
    private Long fbankareatype;

    @TableField("FISBANK")
    private Long fisbank;

    @TableField("FPARENTID")
    private String fparentid;

    @TableField("FISINGROUP")
    private Long fisingroup;

    @TableField("FRELATEDCOMPANYID")
    private String frelatedcompanyid;

    @TableField("FISUSED")
    private Long fisused;

    @TableField("FOPENDATE")
    private LocalDateTime fopendate;

    @TableField("FSETTLEDATE")
    private LocalDateTime fsettledate;

    @TableField("FDELETEDSTATUS")
    private Long fdeletedstatus;

    @TableField("FPARENTINGROUPID")
    private String fparentingroupid;

    @TableField("FLONGNUMBERINGROUP")
    private String flongnumberingroup;

    @TableField("FISFINANCECOMPANY")
    private Long fisfinancecompany;

    @TableField("FACCOUNTBANKID")
    private String faccountbankid;


    @Override
    protected Serializable pkVal() {
        return this.fid;
    }

}
