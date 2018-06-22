package cn.sparke.gift.modules.v1.studyScheme.bean;

import cn.sparke.core.common.bean.BaseEntity;

import java.util.List;

/**
 * @author yangye    2017-08-21
 */
public class GiftPlanConfigBean extends BaseEntity{

    private Integer sectionCode;
    private Integer period;
    private String title;
    private Integer scoreStart;
    private Integer scoreEnd;
    private String comment;
    private String content;

    private List<RecommendCourseBean> courseList;

    public Integer getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(Integer sectionCode) {
        this.sectionCode = sectionCode;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getScoreStart() {
        return scoreStart;
    }

    public void setScoreStart(Integer scoreStart) {
        this.scoreStart = scoreStart;
    }

    public Integer getScoreEnd() {
        return scoreEnd;
    }

    public void setScoreEnd(Integer scoreEnd) {
        this.scoreEnd = scoreEnd;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<RecommendCourseBean> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<RecommendCourseBean> courseList) {
        this.courseList = courseList;
    }
}
