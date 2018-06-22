package cn.sparke.order.modules.v1.order.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.order.modules.v1.order.bean.CouponBean;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public interface CouponMapper extends BaseMapper<CouponBean> {
    /**
     * @param queryCoupon
     * @return
     */
    List<CouponBean> findListByProduct(CouponBean queryCoupon);
}
