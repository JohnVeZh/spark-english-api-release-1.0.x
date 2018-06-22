package cn.sparke.support.modules.v1.exam.mapper.report;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.support.modules.v1.exam.bean.submit.po.TbQuestionWrongBookDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/20 15:25
 */
public interface TbQuestionWrongBookDetailMapper extends BaseMapper<TbQuestionWrongBookDetail>{
    List<String> findItemIdByPaperIdAndUserId(@Param("paperId") String paperId, @Param("userId") String userId);

    int insertList(@Param("questionWrongBookDetailList")  List<TbQuestionWrongBookDetail> questionWrongBookDetailList);

}
