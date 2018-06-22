package cn.sparke.user.modules.v1.comments.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public class RequestCommentListBean {
    @NotNull
    @Range(min = 1, max = 3)
    private Integer contentType;
    @NotBlank
    @Length(min = 32, max = 32)
    private String contentId;
    @NotNull
    private Integer start;
    private Integer rows;

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }
}
