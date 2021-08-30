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
 * @since 2021-08-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("T_BD_MEASUREUNIT")
public class TBdMeasureunit extends Model<TBdMeasureunit> {

    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @TableId("FID")
    private String fid;

    @TableField("FNUMBER")
    private String fnumber;
    @JsonIgnore
    @TableField("FNAME_L1")
    private String fnameL1;

    @TableField("FNAME_L2")
    private String fnameL2;
    @JsonIgnore
    @TableField("FNAME_L3")
    private String fnameL3;
    @JsonIgnore
    @TableField("FCOEFFICIENT")
    private BigDecimal fcoefficient;
    @JsonIgnore
    @TableField("FISBASEUNIT")
    private Long fisbaseunit;
    @JsonIgnore
    @TableField("FDISABLEDDATE")
    private LocalDateTime fdisableddate;
    @JsonIgnore
    @TableField("FGROUPID")
    private String fgroupid;
    @JsonIgnore
    @TableField("FISDISABLED")
    private Long fisdisabled;
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
    @TableField("FQTYPRECISION")
    private Long fqtyprecision;


    @Override
    protected Serializable pkVal() {
        return this.fid;
    }

}
