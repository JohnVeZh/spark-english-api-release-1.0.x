package cn.sparke.user.modules.v1.address.service;

import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.core.common.mybatis.utils.PagerUtils;
import cn.sparke.user.modules.v1.address.bean.AddressBean;
import cn.sparke.user.modules.v1.address.bean.UpdateAddressBean;
import cn.sparke.user.modules.v1.address.constants.AddressConstants;
import cn.sparke.user.modules.v1.address.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhangbowen on 2017/7/11.
 */
@Service
public class AddressService {
    @Autowired
    private AddressMapper addressMapper;

    /**
     * 列表
     *
     * @return
     */
    public PagerBean<AddressBean> findList(AddressBean addressBean) {
        return PagerUtils.getPager(addressMapper.findList(addressBean));
    }

    /**
     * 添加
     *
     * @return
     */
    @Transactional
    public void add(AddressBean addressBean) {
        addressBean.preInsert();
        if (addressBean.getIsDefault() == AddressConstants.IS_DEFAULT) {
            addressMapper.clearDefault(addressBean.getUserId());
        }
        addressMapper.insert(addressBean);
    }

    /**
     * 删除
     *
     * @return
     */
    public void delete(AddressBean addressBean) {
        addressMapper.deleteAddress(addressBean);
    }

    /**
     * 编辑
     *
     * @return
     */
    @Transactional
    public void updateAddress(UpdateAddressBean addressBean) {
        addressBean.preUpdate();
        if (addressBean.getIsDefault() != null && addressBean.getIsDefault() == AddressConstants.IS_DEFAULT) {
            addressMapper.clearDefault(addressBean.getUserId());
        }
        addressMapper.updateAddress(addressBean);
    }

    /**
     * 地址详情
     *
     * @param addressId
     * @return
     */
    public AddressBean info(String addressId) {
        return addressMapper.getById(addressId);
    }
}
