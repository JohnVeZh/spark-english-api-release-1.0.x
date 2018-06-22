package cn.sparke.gift.modules.v1.estimate.bean.vo;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 主观的回答
 * @author ToQuery
 * @version V1.0
 * @date 2017/8/21 11:29
 */
public class SubjectiveAnswerVo {
    private String answer;
    @NotNull(message = "请提交题号信息")
    private Integer no;
    private List<SubjectiveAnswerVoDetailIdVo> answerRules;

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

    public List<SubjectiveAnswerVoDetailIdVo> getAnswerRules() {
        return answerRules;
    }

    public void setAnswerRules(List<SubjectiveAnswerVoDetailIdVo> answerRules) {
        this.answerRules = answerRules;
    }
}
