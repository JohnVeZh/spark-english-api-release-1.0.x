package cn.sparke.support.modules.v1.exam.bean.wrongbook.po;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/9/6 11:39
 */
public class TbQuestionItemNum extends BaseEntity {
    private String paperId;

    private String questionItemId;

    private Integer num;

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getQuestionItemId() {
        return questionItemId;
    }

    public void setQuestionItemId(String questionItemId) {
        this.questionItemId = questionItemId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
