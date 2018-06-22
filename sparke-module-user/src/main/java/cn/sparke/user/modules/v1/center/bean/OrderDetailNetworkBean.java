package cn.sparke.user.modules.v1.center.bean;

import cn.sparke.user.modules.v1.center.constants.CenterConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public class OrderDetailNetworkBean extends OrderDetailBean {
    private int isLive;
    private int status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    private int catalogNumber;
    private String teacherNames;
    private int userStatus;
    private int courseType;
    private String previewCcId;
    private String liveRoomId;
    private String userId;
    private int unOpenNum;
    private String networkId;
    private int playBackNum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date saleStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date saleEndTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date shelfOnTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date shelfOffTime;
    private int limitNumber;
    @JsonIgnore
    private List<VideoInfo> videoList;

    public Date getSaleStartTime() {
        return saleStartTime;
    }

    public void setSaleStartTime(Date saleStartTime) {
        this.saleStartTime = saleStartTime;
    }

    public Date getSaleEndTime() {
        return saleEndTime;
    }

    public void setSaleEndTime(Date saleEndTime) {
        this.saleEndTime = saleEndTime;
    }

    public Date getShelfOnTime() {
        return shelfOnTime;
    }

    public void setShelfOnTime(Date shelfOnTime) {
        this.shelfOnTime = shelfOnTime;
    }

    public Date getShelfOffTime() {
        return shelfOffTime;
    }

    public void setShelfOffTime(Date shelfOffTime) {
        this.shelfOffTime = shelfOffTime;
    }

    public int getLimitNumber() {
        return limitNumber;
    }

    public void setLimitNumber(int limitNumber) {
        this.limitNumber = limitNumber;
    }

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public int getUnOpenNum() {
        return unOpenNum;
    }

    public void setUnOpenNum(int unOpenNum) {
        this.unOpenNum = unOpenNum;
    }

    public int getPlayBackNum() {
        return playBackNum;
    }

    public void setPlayBackNum(int playBackNum) {
        this.playBackNum = playBackNum;
    }

    public List<VideoInfo> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<VideoInfo> videoList) {
        this.videoList = videoList;
        if (videoList != null && catalogNumber > 0) {
            //获取已录播的数量
            this.playBackNum = videoList.stream().filter(v -> v.getType() == CenterConstants.Video.RECORD_TYPE).collect(Collectors.toList()).size();
            //全部课时减去已录播数量，为未开课的数量
            this.unOpenNum = catalogNumber < playBackNum ? 0 : catalogNumber - playBackNum;
        }
    }

    public String getPreviewCcId() {
        return previewCcId;
    }

    public void setPreviewCcId(String previewCcId) {
        this.previewCcId = previewCcId;
    }

    public String getLiveRoomId() {
        return liveRoomId;
    }

    public void setLiveRoomId(String liveRoomId) {
        this.liveRoomId = liveRoomId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getCourseType() {
        return courseType;
    }

    public void setCourseType(int courseType) {
        this.courseType = courseType;
    }

    public String getTeacherNames() {
        return teacherNames;
    }

    public void setTeacherNames(String teacherNames) {
        this.teacherNames = teacherNames;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public int getIsLive() {
        return isLive;
    }

    public void setIsLive(int isLive) {
        this.isLive = isLive;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(int catalogNumber) {
        this.catalogNumber = catalogNumber;
    }
}
