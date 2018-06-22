package cn.sparke.support.modules.v1.exam.bean.wrongbook.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/14 13:21
 */
public class RecommendPaper implements Serializable {
    private static final long serialVersionUID  = 1L;
    private String id;
    private String name;
    private List<RecommendQuestion> questionList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RecommendQuestion> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<RecommendQuestion> questionList) {
        this.questionList = questionList;
    }
}
