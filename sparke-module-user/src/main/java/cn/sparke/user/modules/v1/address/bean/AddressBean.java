package cn.sparke.user.modules.v1.address.bean;

import cn.sparke.core.common.bean.BaseEntity;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public class AddressBean extends BaseEntity {
    private String userId;
    @NotBlank
    private String provinceId;
    @NotBlank
    private String cityId;
    @NotBlank
    private String countyId;
    @NotBlank
    private String districtCn;
    @NotBlank
    private String detailAddress;
    @NotBlank
    private String receiver;
    private String zipcode;
    @NotBlank
    private String mobile;
    @NotNull
    private int isDefault;

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

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }
}
