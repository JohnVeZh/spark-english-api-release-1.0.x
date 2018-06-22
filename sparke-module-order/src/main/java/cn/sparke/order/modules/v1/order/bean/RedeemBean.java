package cn.sparke.order.modules.v1.order.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class RedeemBean {
    @NotBlank
    private String redeemCode;
    @Length(min = 32, max = 32)
    private String addressId;
    @Length(max = 250, message = "备注过长")
    private String remarks;

    public String getRedeemCode() {
        return redeemCode;
    }

    public void setRedeemCode(String redeemCode) {
        this.redeemCode = redeemCode;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
