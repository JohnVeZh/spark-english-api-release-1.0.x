package cn.sparke.gift.modules.v1.estimate.constant;

/**
 * 教师评价状态
 */
public interface TeacherEvaluateStatus {
    //不需要老师评价
    int NO_EVALUATE=0;
    //老师评价
    int TASCHER_EVALUATE=1;
    //老师提交评价
    int TASCHER_EVALUATE_SUBMIT=2;

}
