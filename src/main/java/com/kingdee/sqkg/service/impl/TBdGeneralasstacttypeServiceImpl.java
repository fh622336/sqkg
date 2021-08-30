package com.kingdee.sqkg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kingdee.sqkg.domain.entity.*;
import com.kingdee.sqkg.mapper.TBdGeneralasstacttypeMapper;
import com.kingdee.sqkg.mapper.TBdMeasureunitMapper;
import com.kingdee.sqkg.mapper.TBdMeasureunitgroupMapper;
import com.kingdee.sqkg.mapper.TOrgAdminMapper;
import com.kingdee.sqkg.service.TBdGeneralasstacttypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kingdee.sqkg.util.easUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 樊浩
 * @since 2021-08-18
 */
@Service
public class TBdGeneralasstacttypeServiceImpl extends ServiceImpl<TBdGeneralasstacttypeMapper, TBdGeneralasstacttype> implements TBdGeneralasstacttypeService {
    @Autowired
    private TBdGeneralasstacttypeMapper tBdGeneralasstacttypeMapper;
    @Autowired
    private TBdMeasureunitMapper tBdMeasureunitMapper;
    @Autowired
    private TBdMeasureunitgroupMapper tBdMeasureunitgroupMapper;
    @Autowired
    private TOrgAdminMapper adminMapper;

    /**
     * initLoad
     *
     * @param startDate startDate
     * @param endDate   endDate
     * @param actType   actType
     * @return generalasstacttypeExList
     */
    public Response initLoad(final Date startDate,
                             final Date endDate,
                             final int actType, final String adminNumber) {
        // 1.G+cAAAAAJW4F0s0M 库房   //G+cAAAAAJXQF0s0M 产品类型


        String groupId = "";
        switch (actType) {
            case 1:
                //库房   
                groupId = "G+cAAAAAJW4F0s0M";
                break;
            case 2:
                //产品类型
                groupId = "G+cAAAAAJXQF0s0M";
                break;

            case 3:
                //项目
                groupId = "G+cAAAAAJXAF0s0M";
                break;
            case 4:
                //预算号
                groupId = "G+cAAAAAJXIF0s0M";
                break;
            case  5:
                //挂账部门
                groupId="G+cAAAAA4xsF0s0M";
                break;
            default:
                return Response.fail("EAS不存在的核算项目类型，请检查！");
        }
        QueryWrapper<TOrgAdmin> adminQueryWrapper = new QueryWrapper<>();
        adminQueryWrapper.eq("fnumber", adminNumber);
        TOrgAdmin orgAdmin = adminMapper.selectOne(adminQueryWrapper);

        if (StringUtils.isEmpty(orgAdmin)) {
            return Response.fail("EAS不存在的组织编码，请检查！");
        }


        Timestamp startTime = new Timestamp(startDate.getTime());
        Timestamp endtime = new Timestamp(endDate.getTime());
        QueryWrapper<TBdGeneralasstacttype> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("FNAME_L2", "FNUMBER", "fcreatetime", "FIsEnabled",
                "fmeasureunitgroupid", "fmeasureunitid", "flastupdatetime", "fcreatorcompanyid", "fparentid")
                .between("flastupdatetime",
                        startTime,
                        endtime);

        queryWrapper.eq("FGROUPID", groupId);
        queryWrapper.eq("fcreatorcompanyid", orgAdmin.getFid());

        List<TBdGeneralasstacttype> tBdGeneralasstacttypes = tBdGeneralasstacttypeMapper.selectList(queryWrapper);
        List<TBdGeneralasstacttypeVo> generalasstacttypeExList = new ArrayList<>();
        Optional.of(tBdGeneralasstacttypes).orElse(new ArrayList<>()).forEach(o -> {
            TBdGeneralasstacttypeVo generalasstacttypeEx = new TBdGeneralasstacttypeVo();
            BeanUtils.copyProperties(o, generalasstacttypeEx);
            generalasstacttypeExList.add(generalasstacttypeEx);
        });
        if (actType == 2) {
            if (tBdGeneralasstacttypes != null && !tBdGeneralasstacttypes.isEmpty()) {
                List<String> companyList = tBdGeneralasstacttypes.stream().
                        filter(s -> s.getFcreatorcompanyid() != null)
                        .map(TBdGeneralasstacttype::getFcreatorcompanyid)
                        .collect(Collectors.toList());
                List<String> parentList = tBdGeneralasstacttypes.stream().filter(s -> s.getFparentid() != null)
                        .map(TBdGeneralasstacttype::getFparentid)
                        .collect(Collectors.toList());
                List<String> fmeasureunitGroupIdList = tBdGeneralasstacttypes.stream().
                        filter(s -> s.getFmeasureunitgroupid() != null)
                        .map(TBdGeneralasstacttype::getFmeasureunitgroupid)
                        .collect(Collectors.toList());
                List<String> fmeasureunitidList = tBdGeneralasstacttypes.stream().filter(s -> s.getFmeasureunitid() != null)
                        .map(TBdGeneralasstacttype::
                                getFmeasureunitid).
                                collect(Collectors.
                                        toList());
                Map<String, TOrgAdmin> orgAdminMap=null;
                Map<String, TBdGeneralasstacttype> parentTypeMap=null;
                Map<String, TBdMeasureunitgroup> measureunitgroupMap=null;
                Map<String, TBdMeasureunit> measureunitMap=null;
                if (companyList != null && !companyList.isEmpty()) {
                    List<TOrgAdmin> orgAdminList = adminMapper.
                            selectBatchIds(companyList.
                                    stream().
                                    distinct().
                                    collect(Collectors.
                                            toList()));
                    orgAdminMap = orgAdminList.stream().collect(Collectors.toMap(TOrgAdmin::getFid,
                            Function.identity()));
                }
                if (parentList != null && !parentList.isEmpty()) {
                    List<TBdGeneralasstacttype> parentBatchIds = tBdGeneralasstacttypeMapper.
                            selectBatchIds(parentList.
                                    stream().
                                    distinct().
                                    collect(Collectors.
                                            toList()));
                         parentTypeMap = parentBatchIds.stream().collect(Collectors.toMap(TBdGeneralasstacttype::getFid,
                            Function.identity()));

                }
                if (fmeasureunitGroupIdList != null && !fmeasureunitGroupIdList.isEmpty()) {
                    List<TBdMeasureunitgroup> measureunitGroupList = tBdMeasureunitgroupMapper.
                            selectBatchIds(fmeasureunitGroupIdList.
                                    stream().
                                    distinct().
                                    collect(Collectors.
                                            toList()));
                   measureunitgroupMap = measureunitGroupList.stream().collect(Collectors.toMap
                            (TBdMeasureunitgroup::
                                            getFid
                                    , Function.identity()));
                }
                if (fmeasureunitidList != null && !fmeasureunitidList.isEmpty()) {
                    List<TBdMeasureunit> measureunitList = tBdMeasureunitMapper.selectBatchIds(fmeasureunitidList.stream()
                            .distinct()
                            .collect(Collectors.toList()));

                    measureunitMap  = measureunitList.stream().collect(Collectors.toMap(TBdMeasureunit::getFid,
                            Function.identity()));
                }
                Map<String, TOrgAdmin> finalorgAdminMap= orgAdminMap;
                Map<String, TBdMeasureunitgroup> finalmeasureunitgroupMap=measureunitgroupMap;
                Map<String, TBdMeasureunit> finalmeasureunitMap=measureunitMap;
                Map<String, TBdGeneralasstacttype> finalparentTypeMap=parentTypeMap;

                Optional.of(generalasstacttypeExList).orElse(new ArrayList<>()).forEach(o -> {

                    if (finalmeasureunitMap !=null&&!finalmeasureunitMap.isEmpty()) {
                        if (finalmeasureunitMap.containsKey(o.getFmeasureunitid())) {
                            o.setMeasureunit(finalmeasureunitMap.get(o.getFmeasureunitid()));
                        }
                    }
                    if (finalmeasureunitgroupMap !=null&&!finalmeasureunitgroupMap.isEmpty()) {
                        if (finalmeasureunitgroupMap.containsKey(o.getFmeasureunitgroupid())) {
                            o.setMeasureunitgroup(finalmeasureunitgroupMap.get(o.getFmeasureunitgroupid()));
                        }
                    }

                    if (finalorgAdminMap !=null&&!finalorgAdminMap.isEmpty()){
                        if (finalorgAdminMap.containsKey(o.getFcreatorcompanyid())) {
                            o.setAdmin(finalorgAdminMap.get(o.getFcreatorcompanyid()));
                        }
                    }
                    if (finalparentTypeMap !=null&&!finalparentTypeMap.isEmpty()){
                        if (finalparentTypeMap.containsKey(o.getFparentid())) {
                            o.setParent(finalparentTypeMap.get(o.getFparentid()));
                        }
                    }
                });
                return Response.succ(generalasstacttypeExList);
            }
            return Response.succ(generalasstacttypeExList);
        } else {
            List<String> typeParentList = tBdGeneralasstacttypes.stream().
                    filter(s -> s.getFparentid() != null)
                    .map(TBdGeneralasstacttype::getFparentid)
                    .collect(Collectors.toList());
            List<String> companyList = tBdGeneralasstacttypes.stream().
                    filter(s -> s.getFcreatorcompanyid() != null)
                    .map(TBdGeneralasstacttype::getFcreatorcompanyid)
                    .collect(Collectors.toList());
            Map<String, TBdGeneralasstacttype> typeParentMap = null;
            Map<String, TOrgAdmin> orgAdminMap=null;
            if (typeParentList != null && !typeParentList.isEmpty()) {
                List<TBdGeneralasstacttype> bdGeneralasstacttypesList = tBdGeneralasstacttypeMapper.
                        selectBatchIds(typeParentList.
                                stream().
                                distinct().
                                collect(Collectors.
                                        toList()));
                typeParentMap = bdGeneralasstacttypesList.stream().collect(Collectors.toMap(TBdGeneralasstacttype::getFid, Function.identity()));
            }
            if (companyList != null && !companyList.isEmpty()) {
                List<TOrgAdmin> orgAdminList = adminMapper.
                        selectBatchIds(companyList.
                                stream().
                                distinct().
                                collect(Collectors.
                                        toList()));
                orgAdminMap = orgAdminList.stream().collect(Collectors.toMap(TOrgAdmin::getFid,
                        Function.identity()));
            }
            Map<String, TOrgAdmin>  finalorgAdminMap = orgAdminMap;
            Map<String, TBdGeneralasstacttype> finalTypeParentMap = typeParentMap;
            Optional.of(generalasstacttypeExList).orElse(new ArrayList<>()).forEach(o -> {
                if ( finalTypeParentMap!=null&&!finalTypeParentMap.isEmpty()) {
                    if (finalTypeParentMap.containsKey(o.getFparentid())) {
                        o.setParent(finalTypeParentMap.get(o.getFparentid()));
                    }
                }
                if (finalorgAdminMap !=null&&!finalorgAdminMap.isEmpty()){
                    if (finalorgAdminMap.containsKey(o.getFcreatorcompanyid())) {
                        o.setAdmin(finalorgAdminMap.get(o.getFcreatorcompanyid()));
                    }
                }
            });
            return Response.succ(generalasstacttypeExList);
        }
    }
}
