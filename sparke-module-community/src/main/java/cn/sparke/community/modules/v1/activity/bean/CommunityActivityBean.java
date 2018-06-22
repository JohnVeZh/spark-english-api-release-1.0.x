package cn.sparke.community.modules.v1.activity.bean;

import cn.sparke.core.common.bean.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by yangye on 2017/7/10.
 */
public class CommunityActivityBean extends BaseEntity{
    // private String id;  // 资讯id
    private String title;
    private String brief;
    private String imgList;
    private String content;
    private Integer isTop;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date topTime;
    private Integer isRecommend;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recommendTime;
    private Integer commentNum;
    private Integer likeNum;
    private Integer readNum;
    private Integer serviceStatus;
    private Integer attentionNum;

    //  非数据库字段
    private Integer isLike;

    private Integer isAttention;
    private Integer hasCoupon;
    private List<CouponRuleBean> couponRuleList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getImgList() {
        return imgList;
    }

    public void setImgList(String imgList) {
        this.imgList = imgList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Date getTopTime() {
        return topTime;
    }

    public void setTopTime(Date topTime) {
        this.topTime = topTime;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Date getRecommendTime() {
        return recommendTime;
    }

    public void setRecommendTime(Date recommendTime) {
        this.recommendTime = recommendTime;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public Integer getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(Integer serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public Integer getAttentionNum() {
        return attentionNum;
    }

    public void setAttentionNum(Integer attentionNum) {
        this.attentionNum = attentionNum;
    }

    public List<CouponRuleBean> getCouponRuleList() {
        return couponRuleList;
    }

    public void setCouponRuleList(List<CouponRuleBean> couponRuleList) {
        this.couponRuleList = couponRuleList;
    }

    public Integer getIsLike() {
        return isLike;
    }

    public void setIsLike(Integer isLike) {
        this.isLike = isLike;
    }

    public Integer getIsAttention() {
        return isAttention;
    }

    public void setIsAttention(Integer isAttention) {
        this.isAttention = isAttention;
    }

    public Integer getHasCoupon() {
        return hasCoupon;
    }

    public void setHasCoupon(Integer hasCoupon) {
        this.hasCoupon = hasCoupon;
    }
}
