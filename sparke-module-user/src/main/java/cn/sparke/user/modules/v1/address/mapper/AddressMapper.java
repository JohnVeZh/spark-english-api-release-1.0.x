package cn.sparke.user.modules.v1.address.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.user.modules.v1.address.bean.AddressBean;
import cn.sparke.user.modules.v1.address.bean.UpdateAddressBean;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public interface AddressMapper extends BaseMapper<AddressBean> {
    void deleteAddress(AddressBean addressBean);

    void clearDefault(String userId);

    void updateAddress(UpdateAddressBean addressBean);
}
