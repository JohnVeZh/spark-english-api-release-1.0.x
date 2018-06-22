package cn.sparke.goods.modules.v1.networkCourse.bean;

import cn.sparke.core.common.bean.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @author yangye    2017/7/12
 */
public class ProductNetworkCourseVideoBean extends BaseEntity{

    private String networkCourseId;
    private String catalogId;
    private String name;
    private Integer type;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    private String duration;
    private Integer size;
    private String teacherId;
    private String previewCcId;
    private String videoCcId;
    private String liveCcId;
    private String videoUrl;
    private String liveRoomId;
    private String coverImg;

    private String teacherName;

    public String getNetworkCourseId() {
        return networkCourseId;
    }

    public void setNetworkCourseId(String networkCourseId) {
        this.networkCourseId = networkCourseId;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getPreviewCcId() {
        return previewCcId;
    }

    public void setPreviewCcId(String previewCcId) {
        this.previewCcId = previewCcId;
    }

    public String getVideoCcId() {
        return videoCcId;
    }

    public void setVideoCcId(String videoCcId) {
        this.videoCcId = videoCcId;
    }

    public String getLiveCcId() {
        return liveCcId;
    }

    public void setLiveCcId(String liveCcId) {
        this.liveCcId = liveCcId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getLiveRoomId() {
        return liveRoomId;
    }

    public void setLiveRoomId(String liveRoomId) {
        this.liveRoomId = liveRoomId;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
