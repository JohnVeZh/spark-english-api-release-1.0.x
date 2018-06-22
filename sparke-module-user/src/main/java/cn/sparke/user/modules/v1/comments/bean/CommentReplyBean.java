package cn.sparke.user.modules.v1.comments.bean;

import cn.sparke.core.common.bean.BaseEntity;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public class CommentReplyBean extends BaseEntity {
    @NotBlank
    private String targetUserId;
    @NotBlank
    private String content;
    private String commentId;
    private String nickname;
    private String headerImg;
    private String userId;

    public String getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(String targetUserId) {
        this.targetUserId = targetUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeaderImg() {
        return headerImg;
    }

    public void setHeaderImg(String headerImg) {
        this.headerImg = headerImg;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
