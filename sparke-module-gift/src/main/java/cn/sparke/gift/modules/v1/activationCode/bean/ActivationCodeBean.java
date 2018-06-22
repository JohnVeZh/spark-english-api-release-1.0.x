package cn.sparke.gift.modules.v1.activationCode.bean;

import cn.sparke.core.common.bean.BaseEntity;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import java.util.Date;
import java.util.List;

/**
 * @author yangye    2017-08-18
 */
public class ActivationCodeBean extends BaseEntity{

    @NotBlank
    private String code;
    private int sectionCode;
    private Integer isActivated;
    private Date activateTime;
    private String activateUserId;
    private String address;

    // 关联sys_dict表
    private String description;
    private List<String> courseIdList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(int sectionCode) {
        this.sectionCode = sectionCode;
    }

    public Integer getIsActivated() {
        return isActivated;
    }

    public void setIsActivated(Integer isActivated) {
        this.isActivated = isActivated;
    }

    public Date getActivateTime() {
        return activateTime;
    }

    public void setActivateTime(Date activateTime) {
        this.activateTime = activateTime;
    }

    public String getActivateUserId() {
        return activateUserId;
    }

    public void setActivateUserId(String activateUserId) {
        this.activateUserId = activateUserId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCourseIdList() {
        return courseIdList;
    }

    public void setCourseIdList(List<String> courseIdList) {
        this.courseIdList = courseIdList;
    }
}
