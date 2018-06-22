package cn.sparke.support.modules.v1.writing.bean.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 18:42
 */
public class WritingTranslationVo {

    private String type;
    private List<Question> questionList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
