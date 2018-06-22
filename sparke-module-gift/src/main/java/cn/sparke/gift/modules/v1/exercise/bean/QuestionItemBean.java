package cn.sparke.gift.modules.v1.exercise.bean;

import cn.sparke.core.common.bean.BaseEntity;
import cn.sparke.gift.modules.v1.exercise.common.ValidationGroup;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Administrator on 2017/7/13.
 */
public class QuestionItemBean extends BaseEntity {
    @NotNull(groups = { ValidationGroup.paperSubmit.class ,ValidationGroup.quit.class})
    private String id;
    //题目id
    private String questionId;
    //小题内容
    private String content;
    //解析
    private String analysis;

    //拓展字段
    //用户选择选项
    @NotNull(groups = { ValidationGroup.paperSubmit.class,ValidationGroup.quit.class })
    private String userOptionId;
    //正确选项
    private String rightOptionId;
    //状态
    private Integer status;
    //选项列表
    private List<QuestionOptionBean> optionList;
    private QuestionRecordDetailBean recordDetail;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
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

    public String getUserOptionId() {
        return userOptionId;
    }

    public void setUserOptionId(String userOptionId) {
        this.userOptionId = userOptionId;
    }

    public String getRightOptionId() {
        return rightOptionId;
    }

    public void setRightOptionId(String rightOptionId) {
        this.rightOptionId = rightOptionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<QuestionOptionBean> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<QuestionOptionBean> optionList) {
        this.optionList = optionList;
    }

    public QuestionRecordDetailBean getRecordDetail() {
        return recordDetail;
    }

    public void setRecordDetail(QuestionRecordDetailBean recordDetail) {
        this.recordDetail = recordDetail;
    }
}
