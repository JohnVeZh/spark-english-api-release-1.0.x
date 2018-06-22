package cn.sparke.gift.modules.v1.estimate.constant;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/8/21 14:14
 */
public enum QuestionType {
    LISTEN("听力", 1), READ("阅读", 2), TRANSLATION("翻译", 3), WRITING("写作", 4),;

    private String lable;
    private int value;

    QuestionType(String lable, int value) {
        this.lable = lable;
        this.value = value;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
