package cn.sparke.gift.modules.v1.estimate.bean.vo;

import javax.validation.constraints.NotNull;

/**
 * 客观的回答
 * @author ToQuery
 * @version V1.0
 * @date 2017/8/21 11:29
 */
public class ObjectiveAnswerVo {
    @NotNull(message = "请提交答案信息")
    private String answer;
    @NotNull(message = "请提交题号信息")
    private Integer no;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }
}
