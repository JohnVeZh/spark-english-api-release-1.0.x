package cn.sparke.support.modules.v1.exam.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.support.modules.v1.exam.bean.submit.dto.RightOption;
import cn.sparke.support.modules.v1.exam.bean.submit.po.TbQuestionRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/12 18:59
 */
@Mapper
public interface QuestionMapper extends BaseMapper<RightOption> {

    List<RightOption> findRightOptionByIdList(@Param("questionIdList") List<String> questionIdList);

}
