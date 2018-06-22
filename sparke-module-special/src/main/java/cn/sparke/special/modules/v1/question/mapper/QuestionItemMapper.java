package cn.sparke.special.modules.v1.question.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.special.modules.v1.question.bean.QuestionItemBean;
import cn.sparke.special.modules.v1.question.bean.QuestionOptionBean;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/7/17.
 */
public interface QuestionItemMapper extends BaseMapper {
    QuestionItemBean getItem(QuestionItemBean itemBean);
}
