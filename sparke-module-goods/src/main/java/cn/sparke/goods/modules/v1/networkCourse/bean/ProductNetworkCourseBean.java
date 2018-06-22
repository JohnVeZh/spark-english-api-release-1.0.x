package cn.sparke.goods.modules.v1.networkCourse.bean;

import cn.sparke.core.common.bean.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yangye    2017/7/12
 */
public class ProductNetworkCourseBean extends BaseEntity{

    private String productId;
    private String name;
    private String brief;
    private String content;
    private Integer type;
    private String listImg;
    private String coverImg;
    private String contentImgs;
    private String sectionCode;
    private BigDecimal presentPrice;
    private BigDecimal originalPrice;
    private Integer saleNum;
    private Integer evaluateStar;
    private Integer evaluateNum;
    private Integer isShow;
    private Integer isSend;
    private Integer isPostage;
    private Integer isPromotion;
    private BigDecimal postage;

    private Integer catalogNumber;
    private String teacherNames;
    private Integer courseType;
    private Integer isLive;
    private Integer isFree;
    private Integer isLimitFree;
    private Integer isFamousTeacher;
    private Integer hasCatalog;
    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reserveStartTime;
    private Integer reserveNumber;
    private Integer receiveNumber;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date saleStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date saleEndTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date shelfOnTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date shelfOffTime;
    private Integer limitNumber;
    private String qqGroupNo;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date limitStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date limitEndTime;
    private String previewCcId;
    private String liveRoomId;
    private Integer commentNum;

    // 非数据库字段
    private Integer obtainType;
    private Integer obtainStatus;

    private Date recentOpenTime;
    private Integer notOpenNumber;
    private Integer openedNumber;

    private Integer learnedVideos;
    private Integer sumVideos;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getListImg() {
        return listImg;
    }

    public void setListImg(String listImg) {
        this.listImg = listImg;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getContentImgs() {
        return contentImgs;
    }

    public void setContentImgs(String contentImgs) {
        this.contentImgs = contentImgs;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
    }

    public BigDecimal getPresentPrice() {
        return presentPrice;
    }

    public void setPresentPrice(BigDecimal presentPrice) {
        this.presentPrice = presentPrice;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Integer getEvaluateStar() {
        return evaluateStar;
    }

    public void setEvaluateStar(Integer evaluateStar) {
        this.evaluateStar = evaluateStar;
    }

    public Integer getEvaluateNum() {
        return evaluateNum;
    }

    public void setEvaluateNum(Integer evaluateNum) {
        this.evaluateNum = evaluateNum;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getIsSend() {
        return isSend;
    }

    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }

    public Integer getIsPostage() {
        return isPostage;
    }

    public void setIsPostage(Integer isPostage) {
        this.isPostage = isPostage;
    }

    public Integer getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(Integer isPromotion) {
        this.isPromotion = isPromotion;
    }

    public BigDecimal getPostage() {
        return postage;
    }

    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }

    public Integer getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(Integer catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public String getTeacherNames() {
        return teacherNames;
    }

    public void setTeacherNames(String teacherNames) {
        this.teacherNames = teacherNames;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public Integer getIsLive() {
        return isLive;
    }

    public void setIsLive(Integer isLive) {
        this.isLive = isLive;
    }

    public Integer getIsFree() {
        return isFree;
    }

    public void setIsFree(Integer isFree) {
        this.isFree = isFree;
    }

    public Integer getIsLimitFree() {
        return isLimitFree;
    }

    public void setIsLimitFree(Integer isLimitFree) {
        this.isLimitFree = isLimitFree;
    }

    public Integer getIsFamousTeacher() {
        return isFamousTeacher;
    }

    public void setIsFamousTeacher(Integer isFamousTeacher) {
        this.isFamousTeacher = isFamousTeacher;
    }

    public Integer getHasCatalog() {
        return hasCatalog;
    }

    public void setHasCatalog(Integer hasCatalog) {
        this.hasCatalog = hasCatalog;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    public Date getReserveStartTime() {
        return reserveStartTime;
    }

    public void setReserveStartTime(Date reserveStartTime) {
        this.reserveStartTime = reserveStartTime;
    }

    public Integer getReserveNumber() {
        return reserveNumber;
    }

    public void setReserveNumber(Integer reserveNumber) {
        this.reserveNumber = reserveNumber;
    }

    public Integer getReceiveNumber() {
        return receiveNumber;
    }

    public void setReceiveNumber(Integer receiveNumber) {
        this.receiveNumber = receiveNumber;
    }

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

    public Integer getLimitNumber() {
        return limitNumber;
    }

    public void setLimitNumber(Integer limitNumber) {
        this.limitNumber = limitNumber;
    }

    public String getQqGroupNo() {
        return qqGroupNo;
    }

    public void setQqGroupNo(String qqGroupNo) {
        this.qqGroupNo = qqGroupNo;
    }

    public Date getLimitStartTime() {
        return limitStartTime;
    }

    public void setLimitStartTime(Date limitStartTime) {
        this.limitStartTime = limitStartTime;
    }

    public Date getLimitEndTime() {
        return limitEndTime;
    }

    public void setLimitEndTime(Date limitEndTime) {
        this.limitEndTime = limitEndTime;
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

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getObtainType() {
        return obtainType;
    }

    public void setObtainType(Integer obtainType) {
        this.obtainType = obtainType;
    }

    public Integer getObtainStatus() {
        return obtainStatus;
    }

    public void setObtainStatus(Integer obtainStatus) {
        this.obtainStatus = obtainStatus;
    }

    public Date getRecentOpenTime() {
        return recentOpenTime;
    }

    public void setRecentOpenTime(Date recentOpenTime) {
        this.recentOpenTime = recentOpenTime;
    }

    public Integer getNotOpenNumber() {
        return notOpenNumber;
    }

    public void setNotOpenNumber(Integer notOpenNumber) {
        this.notOpenNumber = notOpenNumber;
    }

    public Integer getOpenedNumber() {
        return openedNumber;
    }

    public void setOpenedNumber(Integer openedNumber) {
        this.openedNumber = openedNumber;
    }

    public Integer getLearnedVideos() {
        return learnedVideos;
    }

    public void setLearnedVideos(Integer learnedVideos) {
        this.learnedVideos = learnedVideos;
    }

    public Integer getSumVideos() {
        return sumVideos;
    }

    public void setSumVideos(Integer sumVideos) {
        this.sumVideos = sumVideos;
    }
}
