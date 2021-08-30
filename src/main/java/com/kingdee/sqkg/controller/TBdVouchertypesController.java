package com.kingdee.sqkg.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kingdee.sqkg.domain.entity.Response;
import com.kingdee.sqkg.domain.entity.TBdGeneralasstacttypegroup;
import com.kingdee.sqkg.domain.entity.TBdVouchertypes;
import com.kingdee.sqkg.mapper.TBdGeneralasstacttypegroupMapper;
import com.kingdee.sqkg.mapper.TBdVouchertypesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 樊浩
 * @since 2021-08-17
 */
@RestController
public class TBdVouchertypesController {
    @Autowired
    private TBdVouchertypesMapper bdVouchertypesMapper;
    @Autowired
    private TBdGeneralasstacttypegroupMapper tBdGeneralasstacttypegroupMapper;
    @GetMapping("t-bd-vouchertypes")
    public Response tBdVouchertypesList(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date startdate, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date enddate) {
        Timestamp startTime = new Timestamp(startdate.getTime());
        Timestamp endtime = new Timestamp(enddate.getTime());
        System.err.println(startTime);
        System.err.println(endtime);
        QueryWrapper<TBdVouchertypes> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("FNAME_L2","FNUMBER","fcreatetime").between("fcreatetime",startTime,endtime);
        List<TBdVouchertypes> tBdVouchertypes = bdVouchertypesMapper.selectList(queryWrapper);
        List<TBdGeneralasstacttypegroup> tBdGeneralasstacttypegroups = tBdGeneralasstacttypegroupMapper.selectList(null);
        return Response.succ(tBdGeneralasstacttypegroups);
    }
}
