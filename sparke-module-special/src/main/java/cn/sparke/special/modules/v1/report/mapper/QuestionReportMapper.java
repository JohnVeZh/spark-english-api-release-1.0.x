package cn.sparke.special.modules.v1.report.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.special.modules.v1.paper.bean.PaperBean;
import cn.sparke.special.modules.v1.record.bean.QuestionRecordBean;
import cn.sparke.special.modules.v1.report.bean.NumBean;
import cn.sparke.special.modules.v1.report.bean.QuestionReportBean;
import cn.sparke.special.modules.v1.report.bean.QuestionReportRecordBean;
import cn.sparke.special.modules.v1.report.bean.SpecialSuggestionBean;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */
public interface QuestionReportMapper extends BaseMapper {
//    @Cacheable(value = "listeningTotal")
    int getListeningTotal(@Param("sectionCode") int sectionCode);
    NumBean getDidAndRightListeningTotal(@Param("userId")String userId, @Param("sectionCode") int sectionCode);
//    @Cacheable(value = "readingTotal")
    int getReadingTotal (@Param("sectionCode") int sectionCode);
    NumBean getDidAndReadingTotal(@Param("userId")String userId, @Param("sectionCode") int sectionCode);
//    @Cacheable(value = "translationTotal")
    int getTranslationTotal (@Param("sectionCode") int sectionCode);
    int getEasyTranslationTotal(@Param("userId") String userId,@Param("sectionCode") int sectionCode);
    int getSecondaryTranslationTotal(@Param("userId") String userId,@Param("sectionCode") int sectionCode);
    int getDifficultTranslationTotal(@Param("userId") String userId,@Param("sectionCode") int sectionCode);
//    @Cacheable(value = "writingTotal")
    int getWritingTotal (@Param("sectionCode") int sectionCode);
    int getEasyWritingTotal(@Param("userId") String userId,@Param("sectionCode")int sectionCode);
    int getSecondaryWritingTotal(@Param("userId") String userId,@Param("sectionCode") int sectionCode);
    int getDifficultWritingTotal(@Param("userId") String userId,@Param("sectionCode") int sectionCode);
    SpecialSuggestionBean getSuggestion(@Param("type") int type, @Param("score") float score, @Param("sectionCode") int sectionCode);
    QuestionReportBean getReport(@Param("contentId")String contentId,@Param("type") int type,@Param("userId") String userId,@Param("sectionCode") int sectionCode );
    int insertReportRecordList(@Param("reportRecordList") List<QuestionReportRecordBean> reportRecordList);
    int insertReportRecord(QuestionReportRecordBean reportRecordBean);
    int deleteReport(QuestionReportBean reportBean);
    //删除用户报告与用户报告记录关系表
    int deleteReportAndReportRecord(QuestionReportBean reportBean);
    String getExistReport (@Param("userId") String userId,@Param("questionId") String questionId);

    //优化
    List<PaperBean> getPaperList(@Param("sectionCode") int sectionCode);
    List<QuestionReportBean> getDidAndRightTotal(@Param("userId")String userId, @Param("sectionCode") int sectionCode);
    List<QuestionRecordBean> getDifficultyLevelTotal(@Param("userId") String userId,@Param("sectionCode") int sectionCode);
}
