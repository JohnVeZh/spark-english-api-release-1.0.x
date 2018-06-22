package cn.sparke.support.modules.v1.exam.bean.submit.po;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 20:27
 */
public class TbQuestionReportRecord extends BaseEntity {

    private String reportId;

    /**
     * 做题记录id
     */
    private String recordId;


    /**
     * 排序
     */

    private Integer sort;

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    @Override
    public Integer getSort() {
        return sort;
    }

    @Override
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
