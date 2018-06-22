package cn.sparke.user.modules.v1.coupons.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.user.modules.v1.coupons.bean.CouponBean;

import java.util.List;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public interface CouponMapper extends BaseMapper<CouponBean> {
    /**
     * 批量插入优惠券
     * @param couponList
     */
    void batchInsertCoupon(List<CouponBean> couponList);
}
