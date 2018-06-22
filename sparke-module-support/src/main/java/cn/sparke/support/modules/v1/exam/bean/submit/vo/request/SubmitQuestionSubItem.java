package cn.sparke.support.modules.v1.exam.bean.submit.vo.request;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 19:56
 */
public class SubmitQuestionSubItem {
    @NotBlank(message = "请提交小题ID")
    private String id;

    private String userOptionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserOptionId() {
        return userOptionId;
    }

    public void setUserOptionId(String userOptionId) {
        this.userOptionId = userOptionId;
    }
}
