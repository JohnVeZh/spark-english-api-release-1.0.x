package cn.sparke.user.modules.v1.center.bean;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by zhangbowen on 2017/7/12.
 */
public class MyCommentBean extends BaseEntity{
    private String content;
    private String imgs;
    private String userId;

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
