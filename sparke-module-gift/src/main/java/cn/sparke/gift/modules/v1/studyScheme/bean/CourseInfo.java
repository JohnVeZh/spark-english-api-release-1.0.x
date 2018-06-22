package cn.sparke.gift.modules.v1.studyScheme.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 课程信息
 */
public class CourseInfo {
    /** 方案id */
    @JsonIgnore
    private String id;
    /** 方案内容 */
    @JsonIgnore
    private String content;
    /** 网课id */
    private String networkCourseId;
    /** 网课名称 */
    private String networkCourseName;

    public String getNetworkCourseId() {
        return networkCourseId;
    }

    public void setNetworkCourseId(String networkCourseId) {
        this.networkCourseId = networkCourseId;
    }

    public String getNetworkCourseName() {
        return networkCourseName;
    }

    public void setNetworkCourseName(String networkCourseName) {
        this.networkCourseName = networkCourseName;
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
}
