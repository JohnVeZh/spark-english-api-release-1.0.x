package cn.sparke.gift.modules.v1.activationCode.bean;

import cn.sparke.core.common.bean.BaseEntity;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @author yangye    2017/7/13
 */
public class UserNetworkCourseBean extends BaseEntity{

    private String userId;
    @NotBlank
    private String networkCourseId;
    @NotNull
    @Range(min = 1, max = 6)
    private Integer type;
    private Integer status;

    private int recordCount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNetworkCourseId() {
        return networkCourseId;
    }

    public void setNetworkCourseId(String networkCourseId) {
        this.networkCourseId = networkCourseId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }
}
