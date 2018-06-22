package cn.sparke.support.modules.v1.exam.bean.paper.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 15:13
 */
public class PaperInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String code;
    private String img;
    private List<PaperStructureItem> structureList = new ArrayList<>();

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<PaperStructureItem> getStructureList() {
        return structureList;
    }

    public void setStructureList(List<PaperStructureItem> structureList) {
        this.structureList = structureList;
    }
}
