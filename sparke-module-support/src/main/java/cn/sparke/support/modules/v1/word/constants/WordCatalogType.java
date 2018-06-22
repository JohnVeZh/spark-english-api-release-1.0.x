package cn.sparke.support.modules.v1.word.constants;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 11:27
 */
public enum WordCatalogType {
    WORD("1","常用词汇"),
    SPECIAL("2","专项练习");

    private String values;
    private String label;

    WordCatalogType(String values, String label) {
        this.values = values;
        this.label = label;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
