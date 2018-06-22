package cn.sparke.special.modules.v1.question.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.special.modules.v1.question.bean.QuestionOptionBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */
public interface QuestionOptionMapper extends BaseMapper {
    List<QuestionOptionBean> getAnswerOption(@Param("questionId") String questionId);
}
