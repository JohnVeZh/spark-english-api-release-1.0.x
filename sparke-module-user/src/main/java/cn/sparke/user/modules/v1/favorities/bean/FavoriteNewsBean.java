package cn.sparke.user.modules.v1.favorities.bean;

import cn.sparke.core.common.bean.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by zhangbowen on 2017/7/10.
 */
public class FavoriteNewsBean extends BaseEntity {
    private String title;
    private int commentNum;
    private String listImg;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public String getListImg() {
        return listImg;
    }

    public void setListImg(String listImg) {
        this.listImg = listImg;
    }
}
