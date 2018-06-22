package cn.sparke.support.modules.v1.exam.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.support.modules.v1.exam.bean.submit.dto.RightOption;
import cn.sparke.support.modules.v1.exam.bean.wrongbook.po.TbQuestionItemNum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/9/6 9:56
 */
public interface QuestionItemNumMapper extends BaseMapper<RightOption> {
    List<TbQuestionItemNum> findByIdList(@Param("idList") List<String> idList);
}
