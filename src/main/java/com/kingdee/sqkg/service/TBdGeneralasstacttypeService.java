package com.kingdee.sqkg.service;

import com.kingdee.sqkg.domain.entity.Response;
import com.kingdee.sqkg.domain.entity.TBdGeneralasstacttype;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kingdee.sqkg.domain.entity.TBdGeneralasstacttypeVo;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 樊浩
 * @since 2021-08-18
 */
public interface TBdGeneralasstacttypeService extends IService<TBdGeneralasstacttype> {
     Response initLoad(final Date startDate,
                             final Date endDate,
                             final int  actType,
                             final  String  adminNumber);
}
