package cn.sparke.support.modules.v1.exam.bean.submit.vo.reponse;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 20:00
 */
public class QuestionSubItem {
    private String id;
    private int status;
    private String userOptionId;
    private String rightOptionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUserOptionId() {
        return userOptionId;
    }

    public void setUserOptionId(String userOptionId) {
        this.userOptionId = userOptionId;
    }

    public String getRightOptionId() {
        return rightOptionId;
    }

    public void setRightOptionId(String rightOptionId) {
        this.rightOptionId = rightOptionId;
    }
}
