package cn.sparke.gift.modules.v1.estimate.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.gift.modules.v1.estimate.bean.po.TbGiftPaperAnswer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/8/21 13:35
 */
@Mapper
public interface TbGiftPaperAnswerMapper extends BaseMapper<TbGiftPaperAnswer> {
    List<TbGiftPaperAnswer> findListByPaperIdAndInQuestionType(@Param("paperId") String paperId, @Param("questionTypes") Integer... questionTypes);

    List<TbGiftPaperAnswer> findListByPaperId(@Param("paperId") String paperId);
}
