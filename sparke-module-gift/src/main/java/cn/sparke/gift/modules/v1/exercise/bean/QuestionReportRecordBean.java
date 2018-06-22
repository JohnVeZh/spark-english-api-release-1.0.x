package cn.sparke.gift.modules.v1.exercise.bean;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by Administrator on 2017/7/17.
 */
public class QuestionReportRecordBean extends BaseEntity {
    //诊断报告id
    private String reportId;
    //做题记录id
    private String recordId;

    public void setReportId(String reportId){
        this.reportId=reportId;
    }
    public String getReportId(){
        return this.reportId;
    }
    public void setRecordId(String recordId){
        this.recordId=recordId;
    }
    public String getRecordId(){
        return this.recordId;
    }
}
