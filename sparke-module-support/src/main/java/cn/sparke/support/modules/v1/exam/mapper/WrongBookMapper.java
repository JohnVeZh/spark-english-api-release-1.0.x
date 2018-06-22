package cn.sparke.support.modules.v1.exam.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.support.modules.v1.exam.bean.paper.vo.QuestionItem;
import cn.sparke.support.modules.v1.exam.bean.submit.po.TbPaperStructure;
import cn.sparke.support.modules.v1.exam.bean.wrongbook.vo.RecommendPaper;
import cn.sparke.support.modules.v1.exam.bean.wrongbook.vo.WrongBooks;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 21:26
 */
@Mapper
public interface WrongBookMapper extends BaseMapper<WrongBooks> {
    List<WrongBooks> findWrongBook(@Param("userId") String userId,@Param("sectionCode") int sectionCode);

    List<QuestionItem> findWrongQuestionByStructureId(@Param("structureIdList") List<TbPaperStructure> structureIdList, @Param("userId") String userId);

    List<QuestionItem> findWrongQuestionByQuestionItemId(@Param("questionItemId") String questionItemId);

    List<RecommendPaper> findRecommendWrongBook(@Param("paperIdList") List<String> paperIdList);

    List<RecommendPaper> findRecommendPaper(@Param("random") double random);
}
