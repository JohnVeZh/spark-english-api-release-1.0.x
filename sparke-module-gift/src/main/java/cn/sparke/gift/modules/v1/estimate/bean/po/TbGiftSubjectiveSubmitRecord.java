package cn.sparke.gift.modules.v1.estimate.bean.po;

import cn.sparke.core.common.bean.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class TbGiftSubjectiveSubmitRecord extends BaseEntity {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 学段
     */
    private int sectionCode;

    /**
     * 试卷id
     */
    private String paperId;

    /**
     * 使用的激活码id
     */
    private String codeId;

    /**
     * 激活码
     */
    private Integer code;

    /**
     * 学前翻译可用次数
     */
    private Integer preTranslateTotal;

    /**
     * 学前翻译已用次数
     */
    private Integer preTranslateUse;

    /**
     * 学前写作可用次数
     */
    private Integer preWriteTotal;

    /**
     * 学前写作已用次数
     */
    private Integer preWriteUse;

    /**
     * 学中翻译可用次数
     */
    private Integer midTranslateTotal;

    /**
     * 学中翻译已用次数
     */
    private Integer midTranslateUse;

    /**
     * 学中写作可用次数
     */
    private Integer midWriteTotal;

    /**
     * 学中写作已用次数
     */
    private Integer midWriteUse;

    /**
     * 学后翻译可用次数
     */
    private Integer postTranslateTotal;

    /**
     * 学后翻译已用次数
     */
    private Integer postTranslateUse;

    /**
     * 学后写作可用次数
     */
    private Integer postWriteTotal;

    /**
     * 学后写作已用次数
     */
    private Integer postWriteUse;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public int getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(int sectionCode) {
        this.sectionCode = sectionCode;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getPreTranslateTotal() {
        return preTranslateTotal;
    }

    public void setPreTranslateTotal(Integer preTranslateTotal) {
        this.preTranslateTotal = preTranslateTotal;
    }

    public Integer getPreTranslateUse() {
        return preTranslateUse;
    }

    public void setPreTranslateUse(Integer preTranslateUse) {
        this.preTranslateUse = preTranslateUse;
    }

    public Integer getPreWriteTotal() {
        return preWriteTotal;
    }

    public void setPreWriteTotal(Integer preWriteTotal) {
        this.preWriteTotal = preWriteTotal;
    }

    public Integer getPreWriteUse() {
        return preWriteUse;
    }

    public void setPreWriteUse(Integer preWriteUse) {
        this.preWriteUse = preWriteUse;
    }

    public Integer getMidTranslateTotal() {
        return midTranslateTotal;
    }

    public void setMidTranslateTotal(Integer midTranslateTotal) {
        this.midTranslateTotal = midTranslateTotal;
    }

    public Integer getMidTranslateUse() {
        return midTranslateUse;
    }

    public void setMidTranslateUse(Integer midTranslateUse) {
        this.midTranslateUse = midTranslateUse;
    }

    public Integer getMidWriteTotal() {
        return midWriteTotal;
    }

    public void setMidWriteTotal(Integer midWriteTotal) {
        this.midWriteTotal = midWriteTotal;
    }

    public Integer getMidWriteUse() {
        return midWriteUse;
    }

    public void setMidWriteUse(Integer midWriteUse) {
        this.midWriteUse = midWriteUse;
    }

    public Integer getPostTranslateTotal() {
        return postTranslateTotal;
    }

    public void setPostTranslateTotal(Integer postTranslateTotal) {
        this.postTranslateTotal = postTranslateTotal;
    }

    public Integer getPostTranslateUse() {
        return postTranslateUse;
    }

    public void setPostTranslateUse(Integer postTranslateUse) {
        this.postTranslateUse = postTranslateUse;
    }

    public Integer getPostWriteTotal() {
        return postWriteTotal;
    }

    public void setPostWriteTotal(Integer postWriteTotal) {
        this.postWriteTotal = postWriteTotal;
    }

    public Integer getPostWriteUse() {
        return postWriteUse;
    }

    public void setPostWriteUse(Integer postWriteUse) {
        this.postWriteUse = postWriteUse;
    }

}