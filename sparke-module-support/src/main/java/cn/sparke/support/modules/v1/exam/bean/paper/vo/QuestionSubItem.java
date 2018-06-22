package cn.sparke.support.modules.v1.exam.bean.paper.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 15:09
 */
public class QuestionSubItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private Integer questionNo;
    private String content;
    private String analysis;
    private List<OptionItem> optionList;

    public Integer getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(Integer questionNo) {
        this.questionNo = questionNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public List<OptionItem> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<OptionItem> optionList) {
        this.optionList = optionList;
    }
}
