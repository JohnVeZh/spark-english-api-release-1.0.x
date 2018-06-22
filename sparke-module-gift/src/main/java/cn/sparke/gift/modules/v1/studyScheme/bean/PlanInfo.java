package cn.sparke.gift.modules.v1.studyScheme.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 方案信息
 */
public class PlanInfo {
    /** 方案id */
    private String id;
    /** 方案内容 */
    private String content;
    /** 方案推荐的课程 */
    private List<CourseInfo> courses;

    public PlanInfo(List<CourseInfo> courses){
        if(courses!=null&&courses.size()>0){
            this.id=courses.get(0).getId();
            this.content=courses.get(0).getContent();
            if(courses.size()!=1||(courses.get(0).getNetworkCourseId()!=null&&courses.get(0).getNetworkCourseName()!=null)){
                this.courses=courses;
            }
        }else {
            this.courses= new ArrayList<>();
        }
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

    public List<CourseInfo> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseInfo> courses) {
        this.courses = courses;
    }
}
