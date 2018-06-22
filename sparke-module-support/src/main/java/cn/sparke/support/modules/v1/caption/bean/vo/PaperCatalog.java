package cn.sparke.support.modules.v1.caption.bean.vo;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 21:25
 */
public class PaperCatalog {
    private String id;
    private String name;
    private List<PaperItem> paperList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PaperItem> getPaperList() {
        return paperList;
    }

    public void setPaperList(List<PaperItem> paperList) {
        this.paperList = paperList;
    }
}
