package cn.sparke.support.modules.v1.exam.bean.submit.vo.reponse;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 19:59
 */
public class PaperReport {

    private String id;
    private String paperId;
    private String paperStructureId;
    private double paperRightRate;
    private String createDate;

    private List<StructureItem> structureList;

    public double getPaperRightRate() {
        return paperRightRate;
    }

    public void setPaperRightRate(double paperRightRate) {
        this.paperRightRate = paperRightRate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getPaperStructureId() {
        return paperStructureId;
    }

    public void setPaperStructureId(String paperStructureId) {
        this.paperStructureId = paperStructureId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public List<StructureItem> getStructureList() {
        return structureList;
    }

    public void setStructureList(List<StructureItem> structureList) {
        this.structureList = structureList;
    }
}
