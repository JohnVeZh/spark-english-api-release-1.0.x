package cn.sparke.support.modules.v1.exam.bean.submit.dto;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/12 21:00
 */
public class RightOption {
    private String rightOptionId;
    private String subQuestionId;

    public String getRightOptionId() {
        return rightOptionId;
    }

    public void setRightOptionId(String rightOptionId) {
        this.rightOptionId = rightOptionId;
    }

    public String getSubQuestionId() {
        return subQuestionId;
    }

    public void setSubQuestionId(String subQuestionId) {
        this.subQuestionId = subQuestionId;
    }
}
