package cn.sparke.gift.modules.v1.estimate.bean.vo;

/**
 * 称号
 */
public class Title {
    /** 起始分值 */
    private int scoreStart;
    /** 结束分值 */
    private int scoreEnd;
    /** 标题 */
    private String title;

    public int getScoreStart() {
        return scoreStart;
    }

    public void setScoreStart(int scoreStart) {
        this.scoreStart = scoreStart;
    }

    public int getScoreEnd() {
        return scoreEnd;
    }

    public void setScoreEnd(int scoreEnd) {
        this.scoreEnd = scoreEnd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
