package cn.sparke.support.modules.v1.caption.bean.po;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 9:55
 */
public class TbUserPaper extends BaseEntity {

    private String groupId;
    private int sectionCode;
    private String userId;

    public TbUserPaper() {
    }

    public TbUserPaper(String groupId, int sectionCode, String userId) {
        this.groupId = groupId;
        this.sectionCode = sectionCode;
        this.userId = userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public int getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(int sectionCode) {
        this.sectionCode = sectionCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
