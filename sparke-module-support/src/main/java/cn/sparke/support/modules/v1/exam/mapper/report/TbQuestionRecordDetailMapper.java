package cn.sparke.support.modules.v1.exam.mapper.report;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.support.modules.v1.exam.bean.submit.po.TbQuestionRecordDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/12 20:00
 */
@Mapper
public interface TbQuestionRecordDetailMapper extends BaseMapper<TbQuestionRecordDetailMapper> {
    int insertList(@Param("questionRecordDetailList") List<TbQuestionRecordDetail> questionRecordDetailList);
}
