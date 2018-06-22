package cn.sparke.special.modules.v1.question.bean;

import cn.sparke.core.common.bean.BaseEntity;
import cn.sparke.special.modules.v1.common.ValidationGroup;
import cn.sparke.special.modules.v1.record.bean.QuestionRecordDetailBean;

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
    private int status;
    //是否收藏
    private int isCollect;
    //选项列表
    private List<QuestionOptionBean> optionList;
    private QuestionRecordDetailBean recordDetail;
    public void setQuestionId(String questionId){
        this.questionId=questionId;
    }
    public String getQuestionId(){
        return this.questionId;
    }
    public void setContent(String content){
        this.content=content;
    }
    public String getContent(){
        return this.content;
    }
    public void setAnalysis(String analysis){
        this.analysis=analysis;
    }
    public String getAnalysis(){
        return this.analysis;
    }

    public List<QuestionOptionBean> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<QuestionOptionBean> optionList) {
        this.optionList = optionList;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(int isCollect) {
        this.isCollect = isCollect;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public QuestionRecordDetailBean getRecordDetail() {
        return recordDetail;
    }

    public void setRecordDetail(QuestionRecordDetailBean recordDetail) {
        this.recordDetail = recordDetail;
    }
}
