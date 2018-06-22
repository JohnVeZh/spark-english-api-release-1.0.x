package cn.sparke.order.modules.v1.order.entity;

import cn.sparke.core.common.bean.BaseEntity;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by zhangbowen on 2017/7/14.
 */
public class EvaluateEntity extends BaseEntity {
    private String userId;
    private String nickname;
    private String headerImg;
    private String orderId;
    @NotBlank
    private String orderDetailId;
    private String productId;
    private String content;
    private String imgs;
    @NotNull
    private Integer thinkingScore;
    @NotNull
    private Integer styleScore;
    @NotNull
    private Integer curriculumScore;
    private int averageScore;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeaderImg() {
        return headerImg;
    }

    public void setHeaderImg(String headerImg) {
        this.headerImg = headerImg;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public Integer getThinkingScore() {
        return thinkingScore;
    }

    public void setThinkingScore(Integer thinkingScore) {
        this.thinkingScore = thinkingScore;
    }

    public Integer getStyleScore() {
        return styleScore;
    }

    public void setStyleScore(Integer styleScore) {
        this.styleScore = styleScore;
    }

    public Integer getCurriculumScore() {
        return curriculumScore;
    }

    public void setCurriculumScore(Integer curriculumScore) {
        this.curriculumScore = curriculumScore;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }
}
