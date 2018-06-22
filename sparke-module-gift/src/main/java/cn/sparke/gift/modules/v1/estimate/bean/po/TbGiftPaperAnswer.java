package cn.sparke.gift.modules.v1.estimate.bean.po;

import cn.sparke.core.common.bean.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class TbGiftPaperAnswer extends BaseEntity {

    /**
     * 大礼包试卷id
     */
    private String paperId;

    private Byte sectionCode;

    /**
     * 1学前，2学中，3学末
     */
    private Byte period;

    /**
     * 题目类型，1听力，2阅读，3翻译，4写作
     */
    private Byte questionType;

    /**
     * 题号，1,2,3（整套试卷的题目编号，翻译写作为0）
     */
    private Integer questionNo;

    /**
     * 题目分数
     */
    private float score;


    /**
     * 正确答案,听力和阅读的正确答案，翻译的译文，写作的范文
     */
    private String answer;

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public Byte getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(Byte sectionCode) {
        this.sectionCode = sectionCode;
    }

    public Byte getPeriod() {
        return period;
    }

    public void setPeriod(Byte period) {
        this.period = period;
    }

    public Byte getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Byte questionType) {
        this.questionType = questionType;
    }

    public Integer getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(Integer questionNo) {
        this.questionNo = questionNo;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}