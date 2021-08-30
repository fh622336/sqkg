package com.kingdee.sqkg.domain.entity;

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
@TableName("T_BD_GENERALASSTACTTYPEGROUP")
public class TBdGeneralasstacttypegroup extends Model<TBdGeneralasstacttypegroup> {

    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @TableId("FID")
    private String fid;
    @JsonIgnore
    @TableField("FCREATORID")
    private String fcreatorid;

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
    @TableField("FCUSTOMFIELD1")
    private String fcustomfield1;
    @JsonIgnore
    @TableField("FSHARETACTIC")
    private Long fsharetactic;
    @JsonIgnore
    @TableField("FISLEVELCONTROL")
    private Long fislevelcontrol;


    @Override
    protected Serializable pkVal() {
        return this.fid;
    }

}
