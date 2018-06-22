package cn.sparke.special.modules.v1.word.bean;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by Administrator on 2017/7/11.
 */
public class WordQuestionOptionBean extends BaseEntity {
    private String questionId	;//单词题目
    private String prefix;//选项：如ABCD
    private String content;//选项内容
    private String isAnswer;//	是否答案：0否，1是

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsAnswer() {
        return isAnswer;
    }

    public void setIsAnswer(String isAnswer) {
        this.isAnswer = isAnswer;
    }
}
