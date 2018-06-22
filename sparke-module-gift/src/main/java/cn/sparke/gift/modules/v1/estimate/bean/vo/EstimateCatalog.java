package cn.sparke.gift.modules.v1.estimate.bean.vo;

public class EstimateCatalog {
    /** 试卷ID */
    private String id;
    /** /试卷名称 */
    private String name;
    /** 学段 */
    private int sectionCode;
    /** 1学前，2学中，3学末 */
    private int period;
    /** 报告ID 当status=2 时有效 */
    private String reportId;
    /** 状态 1.未作，2.报告，3.跳过 */
    private int status;

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

    public int getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(int sectionCode) {
        this.sectionCode = sectionCode;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
