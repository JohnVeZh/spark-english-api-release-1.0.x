package cn.sparke.gift.modules.v1.exercise.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.gift.modules.v1.exercise.bean.*;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/8/18.
 */
public interface GiftExerciseMapper extends BaseMapper<GiftExerciseBean> {
    Page<GiftExerciseBean> findList(@Param("userId") String userId, @Param("sectionCode") int sectionCode);
    QuestionBean getQuestion(@Param("userId") String userId,@Param("questionId") String questionId,@Param("type") int type);
    QuestionReportBean getReport(@Param("contentId") String contentId,@Param("type") int type,@Param("userId") String userId,@Param("sectionCode") int sectionCode);
    int deleteRecordAndDetail(QuestionRecordBean recordBean);
    int insertRecord(QuestionRecordBean bean);
    int insertRecordDetailList(@Param("detailList") List<QuestionRecordDetailBean> detailBeanList);
    StructureBean getStructure(@Param("structureId") String structureId);
    List<QuestionOptionBean> getAnswerOption(@Param("questionId") String questionId);
    int insertReportRecord(QuestionReportRecordBean reportRecordBean);
    int deleteReportAndReportRecord(QuestionReportBean reportBean);
    int insertReport(QuestionReportBean reportBean);
    String getExistReport (@Param("userId") String userId,@Param("questionId") String questionId);
    int deleteReport(QuestionReportBean reportBean);
}
