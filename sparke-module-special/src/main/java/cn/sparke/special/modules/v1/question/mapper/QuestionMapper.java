package cn.sparke.special.modules.v1.question.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.special.modules.v1.question.bean.QuestionBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 */
public interface QuestionMapper extends BaseMapper<QuestionBean>{
    List<QuestionBean> findQuestionList (@Param("userId") String userId,@Param("structureId") String structureId);
    QuestionBean getQuestion(@Param("userId") String userId,@Param("questionId") String questionId,@Param("type") int type);
    QuestionBean getNextQuestion(@Param("userId") String userId,@Param("sectionCode") int sectionCode,@Param("structureId") String structureId);
}
