package cn.sparke.support.modules.v1.exam.bean.wrongbook.vo;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 21:35
 */
public class WrongBooks {
    private String id;
    private String name;
    private Integer num;

    private List<StructureItem> structureList;

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public List<StructureItem> getStructureList() {
        return structureList;
    }

    public void setStructureList(List<StructureItem> structureList) {
        this.structureList = structureList;
    }
}
