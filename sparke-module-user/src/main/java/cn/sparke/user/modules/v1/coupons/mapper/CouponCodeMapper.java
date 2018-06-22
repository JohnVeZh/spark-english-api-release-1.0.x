package cn.sparke.user.modules.v1.coupons.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.user.modules.v1.coupons.bean.CouponCodeBean;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public interface CouponCodeMapper extends BaseMapper<CouponCodeBean> {
    void updateCodeUsedNum(String id);

    CouponCodeBean getByCode(String code);
}
