    package com.kingdee.sqkg.controller;


    import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
    import com.kingdee.sqkg.domain.entity.Response;
    import com.kingdee.sqkg.domain.entity.TBdGeneralasstacttype;
    import com.kingdee.sqkg.domain.entity.TBdMeasureunit;
    import com.kingdee.sqkg.mapper.TBdGeneralasstacttypeMapper;
    import com.kingdee.sqkg.mapper.TBdMeasureunitMapper;
    import com.kingdee.sqkg.mapper.TBdMeasureunitgroupMapper;
    import com.kingdee.sqkg.service.TBdGeneralasstacttypeService;
    import org.springframework.beans.BeanUtils;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.format.annotation.DateTimeFormat;
    import org.springframework.web.bind.annotation.GetMapping;

    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RestController;

    import java.sql.Timestamp;
    import java.util.*;
    import java.util.function.Function;
    import java.util.stream.Collectors;

    /**
     * <p>
     *  前端控制器
     * </p>
     *
     * @author 樊浩
     * @since 2021-08-18
     */
    @RestController
    public class TBdGeneralasstacttypeController {
        @Autowired
        private TBdGeneralasstacttypeService generalasstacttypeService;
        @GetMapping("customAccountingItems")
        public Response budgetList(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,@RequestParam  int  actType,@RequestParam String adminNumber) {
            return generalasstacttypeService.initLoad(startDate, endDate, actType,  adminNumber);
        }
    }
