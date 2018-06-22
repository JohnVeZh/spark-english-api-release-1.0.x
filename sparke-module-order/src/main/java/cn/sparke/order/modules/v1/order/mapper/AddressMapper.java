package cn.sparke.order.modules.v1.order.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.order.modules.v1.order.bean.AddressBean;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public interface AddressMapper extends BaseMapper<AddressBean> {
    AddressBean getUserDefaultAddress(String userId);
}
