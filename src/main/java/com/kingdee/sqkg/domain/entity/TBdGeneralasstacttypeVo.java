package com.kingdee.sqkg.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TBdGeneralasstacttypeVo {

    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @TableId("FID")
    private String fid;

    @JsonIgnore
    @TableField("FCREATETIME")
    private LocalDateTime fcreatetime;

    @TableField("FLASTUPDATETIME")
    private LocalDateTime flastupdatetime;


    @TableField("FNAME_L2")
    private String fnameL2;

    @TableField("FNUMBER")
    private String fnumber;

//    @JsonIgnore
//    @TableField("FGROUPID")
//    private String fgroupid;

    @TableField("FISENABLED")
    private Long fisenabled;
    @JsonIgnore
    @TableField("measureunit_id")
    private String fmeasureunitid;
    @JsonIgnore
    @TableField("measureunitgroup_id")
    private String fmeasureunitgroupid;
    @JsonIgnore
    @TableField("FCREATORCOMPANYID")
    private String fcreatorcompanyid;
    @JsonIgnore
    @TableField("FPARENTID")
    private String fparentid;
 //  @TableField(exist = false)
    private TBdMeasureunit measureunit;
   //@TableField(exist = false)
    private TBdMeasureunitgroup measureunitgroup;

    private TBdGeneralasstacttype  parent;

    private TOrgAdmin admin;
}
