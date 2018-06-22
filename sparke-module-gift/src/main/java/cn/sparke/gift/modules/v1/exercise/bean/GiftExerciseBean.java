package cn.sparke.gift.modules.v1.exercise.bean;

import cn.sparke.core.common.bean.BaseEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/8/18.
 */
public class GiftExerciseBean extends BaseEntity {
    private Integer sectionCode;//学段
    private Integer contentType;//类型 1听力，2阅读，3翻译，4写作
    private String recommendId;//课程 推荐id
    private String networkCourseVideoId;//视频id(不是网课id)
    private String paperId;//试卷id
    private String structureId;//结构id
    private String structureName;//结构名称
    private List<QuestionBean> questionList;//题目列表

    public Integer getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(Integer sectionCode) {
        this.sectionCode = sectionCode;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public String getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(String recommendId) {
        this.recommendId = recommendId;
    }

    public String getNetworkCourseVideoId() {
        return networkCourseVideoId;
    }

    public void setNetworkCourseVideoId(String networkCourseVideoId) {
        this.networkCourseVideoId = networkCourseVideoId;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getStructureId() {
        return structureId;
    }

    public void setStructureId(String structureId) {
        this.structureId = structureId;
    }

    public String getStructureName() {
        return structureName;
    }

    public void setStructureName(String structureName) {
        this.structureName = structureName;
    }

    public List<QuestionBean> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionBean> questionList) {
        this.questionList = questionList;
    }
}
