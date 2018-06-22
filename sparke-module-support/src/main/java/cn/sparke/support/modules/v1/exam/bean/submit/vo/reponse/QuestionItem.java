package cn.sparke.support.modules.v1.exam.bean.submit.vo.reponse;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 20:01
 */
public class QuestionItem {
    private String id;
    private List<QuestionSubItem> questionItemList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<QuestionSubItem> getQuestionItemList() {
        return questionItemList;
    }

    public void setQuestionItemList(List<QuestionSubItem> questionItemList) {
        this.questionItemList = questionItemList;
    }
}
