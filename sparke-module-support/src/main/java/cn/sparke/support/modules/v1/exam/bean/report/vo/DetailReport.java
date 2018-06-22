package cn.sparke.support.modules.v1.exam.bean.report.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/12 10:47
 */
public class DetailReport {

    private String id;
    private String paperId;
    private String paperStructureId;
    private String paperStructureName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    private List<DetailStructure> structureList;

    public String getPaperStructureName() {
        return paperStructureName;
    }

    public void setPaperStructureName(String paperStructureName) {
        this.paperStructureName = paperStructureName;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<DetailStructure> getStructureList() {
        return structureList;
    }

    public void setStructureList(List<DetailStructure> structureList) {
        this.structureList = structureList;
    }
}
