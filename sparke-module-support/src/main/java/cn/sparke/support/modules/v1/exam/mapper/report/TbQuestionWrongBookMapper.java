package cn.sparke.support.modules.v1.exam.mapper.report;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.support.modules.v1.exam.bean.submit.po.TbQuestionWrongBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/13 16:15
 */
@Mapper
public interface TbQuestionWrongBookMapper extends BaseMapper<TbQuestionWrongBook> {
    int insertList(@Param("questionWrongBooks") List<TbQuestionWrongBook> questionWrongBooks);

    @Deprecated
    List<String> findItemIdByPaperIdAndUserId(@Param("paperId") String paperId, @Param("userId") String userId);

    List<TbQuestionWrongBook> findByPaperIdAndUserId(@Param("paperId") String paperId, @Param("userId") String userId);

    int batchUpdate(@Param("updateWrongBookIds") List<String> updateWrongBookIds, @Param("date") Date date);
}
