package cn.sparke.support.modules.v1.exam.bean.submit.vo.reponse;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 20:02
 */
public class StructureItem {
    private String id;
    private String name;
    private int didNum;
    private int  rightNum;
    private double rightRate;
    //直接小题
    private List<QuestionSubItem> questionList;

    private Integer sort;

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public int getRightNum() {
        return rightNum;
    }

    public void setRightNum(int rightNum) {
        this.rightNum = rightNum;
    }

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

    public int getDidNum() {
        return didNum;
    }

    public void setDidNum(int didNum) {
        this.didNum = didNum;
    }

    public double getRightRate() {
        return rightRate;
    }

    public void setRightRate(double rightRate) {
        this.rightRate = rightRate;
    }

    public List<QuestionSubItem> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionSubItem> questionList) {
        this.questionList = questionList;
    }
}
