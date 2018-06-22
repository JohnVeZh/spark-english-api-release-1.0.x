package cn.sparke.special.modules.v1.paper.bean;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by Administrator on 2017/7/14.
 */
public class SpecialExplainBean extends BaseEntity {
    //标题
    private String title;
    //类型：1、自有内容、2外部链接、3、资讯、4、图书、5、网课
    private Integer contentType;
    //内容Id
    private String contentId;
    //内容：type=1_时有效
    private String content;
    //访问次数
    private Integer visitNum;
    //试卷id
    private String paperId;
    //	外部链接地址：type = 2时有效
    private String url;

    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setContentType(Integer contentType){
        this.contentType=contentType;
    }
    public Integer getContentType(){
        return this.contentType;
    }
    public void setContentId(String contentId){
        this.contentId=contentId;
    }
    public String getContentId(){
        return this.contentId;
    }
    public void setContent(String content){
        this.content=content;
    }
    public String getContent(){
        return this.content;
    }
    public void setVisitNum(Integer visitNum){
        this.visitNum=visitNum;
    }
    public Integer getVisitNum(){
        return this.visitNum;
    }
    public void setPaperId(String paperId){
        this.paperId=paperId;
    }
    public String getPaperId(){
        return this.paperId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
