package cn.sparke.gift.modules.v1.estimate.bean.vo;

/**
 * 用户自主估分
 */
public class UserEstimate {
    /** 名称 */
    private String name;
    /** 得分  */
    private int score;
    /** 内容 */
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
