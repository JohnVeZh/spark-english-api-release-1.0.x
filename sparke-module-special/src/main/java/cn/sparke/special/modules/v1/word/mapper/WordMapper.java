package cn.sparke.special.modules.v1.word.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.special.modules.v1.report.bean.NumBean;
import cn.sparke.special.modules.v1.word.bean.WordBean;
import cn.sparke.special.modules.v1.word.bean.WordUserReportBean;
import cn.sparke.special.modules.v1.word.bean.WordWrongBookBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 */
public interface WordMapper extends BaseMapper<WordBean> {
    List<WordBean> findList(@Param("catalogId") String catalogId);
    int hasReport(@Param("userId") String userId,@Param("catalogId")  String catalogId);
    int delete(@Param("userId") String userId, @Param("catalogId") String catalogId);
    int insertReport(WordUserReportBean wordUserReportBean);
    List<WordBean> findWrongList(@Param("userId") String userId, @Param("sectionCode") int sectionCode);
    int insertWrongBook(WordWrongBookBean wordWrongBookBean);
    int deleteWrongBook(@Param("wordId") String wordId,@Param("userId") String userId);
    int getExistWrongBook(@Param("wordId") String wordId,@Param("userId") String userId);
    int getWrongWordCount(@Param("userId") String userId,@Param("sectionCode") int sectionCode);
//    @Cacheable(value = "wordTotalBySection")
    int getWordTotal(@Param("sectionCode")int sectionCode);
    NumBean getDidAndRightWordTotal (@Param("userId") String userId,@Param("sectionCode") int sectionCode);
}
