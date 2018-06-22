package cn.sparke.order.modules.v1.order.bean;

import cn.sparke.core.common.bean.BaseEntity;
import cn.sparke.order.modules.v1.order.entity.OrderLogisticsEntity;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public class AddressBean extends BaseEntity {
    private String userId;
    private String provinceId;
    private String cityId;
    private String countyId;
    private String districtCn;
    private String detailAddress;
    private String receiver;
    private String zipcode;
    private String mobile;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public String getDistrictCn() {
        return districtCn;
    }

    public void setDistrictCn(String districtCn) {
        this.districtCn = districtCn;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public OrderLogisticsEntity convertLogistic(String orderId) {
        OrderLogisticsEntity orderLogisticsEntity = new OrderLogisticsEntity();
        orderLogisticsEntity.setOrderId(orderId);
        orderLogisticsEntity.setProvinceId(provinceId);
        orderLogisticsEntity.setCityId(cityId);
        orderLogisticsEntity.setCountyId(countyId);
        orderLogisticsEntity.setProvinceCityCn(districtCn);
        orderLogisticsEntity.setZipcode(zipcode);
        orderLogisticsEntity.setReceiver(receiver);
        orderLogisticsEntity.setReceiveMobile(mobile);
        orderLogisticsEntity.setReceiveAddress(detailAddress);
        orderLogisticsEntity.preInsert();
        return orderLogisticsEntity;
    }
}
