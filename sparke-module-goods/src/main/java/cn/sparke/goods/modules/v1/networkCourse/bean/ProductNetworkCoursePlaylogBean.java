package cn.sparke.goods.modules.v1.networkCourse.bean;

import cn.sparke.core.common.bean.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author yangye    2017-08-07
 */
public class ProductNetworkCoursePlaylogBean extends BaseEntity{

    @NotBlank
    private String networkCourseId;
    @NotBlank
    private String networkVideoId;
    @NotBlank
    private String userId;
    @NotNull
    @Range(min = 10)
    private Integer playDuration;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date playTime;

    private int recordCount;

    public String getNetworkCourseId() {
        return networkCourseId;
    }

    public void setNetworkCourseId(String networkCourseId) {
        this.networkCourseId = networkCourseId;
    }

    public String getNetworkVideoId() {
        return networkVideoId;
    }

    public void setNetworkVideoId(String networkVideoId) {
        this.networkVideoId = networkVideoId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getPlayDuration() {
        return playDuration;
    }

    public void setPlayDuration(Integer playDuration) {
        this.playDuration = playDuration;
    }

    public Date getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Date playTime) {
        this.playTime = playTime;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }
}
