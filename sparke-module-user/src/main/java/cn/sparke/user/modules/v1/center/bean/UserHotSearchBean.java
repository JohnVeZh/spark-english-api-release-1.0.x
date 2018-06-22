package cn.sparke.user.modules.v1.center.bean;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * 用户热搜
 * Created by asknico on 2017-08-01.
 */
public class UserHotSearchBean extends BaseEntity {
    private String title;
    private Integer searchType;
    private Integer searchNum;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    public Integer getSearchNum() {
        return searchNum;
    }

    public void setSearchNum(Integer searchNum) {
        this.searchNum = searchNum;
    }
}
