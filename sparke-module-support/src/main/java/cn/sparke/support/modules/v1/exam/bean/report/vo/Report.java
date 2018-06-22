package cn.sparke.support.modules.v1.exam.bean.report.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/12 10:19
 */
public class Report {
    @JsonIgnore
    private String reportId;
    private double rightRate;
    private List<ReportStructure> structureList;

    public Report() {
    }

    public Report(double rightRate, List<ReportStructure> structureList) {
        this.rightRate = rightRate;
        this.structureList = structureList;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public double getRightRate() {
        return rightRate;
    }

    public void setRightRate(double rightRate) {
        this.rightRate = rightRate;
    }

    public List<ReportStructure> getStructureList() {
        return structureList;
    }

    public void setStructureList(List<ReportStructure> structureList) {
        this.structureList = structureList;
    }
}
