package cn.sparke.gift.modules.v1.estimate.bean.vo;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/8/21 11:38
 */
public class AnswerInfoVo {
    private String reportId;

    public AnswerInfoVo(String reportId) {
        this.reportId = reportId;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }
}
