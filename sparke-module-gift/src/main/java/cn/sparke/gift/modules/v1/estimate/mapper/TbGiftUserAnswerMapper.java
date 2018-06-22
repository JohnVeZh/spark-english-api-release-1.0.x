package cn.sparke.gift.modules.v1.estimate.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.gift.modules.v1.estimate.bean.po.TbGiftUserAnswer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TbGiftUserAnswerMapper extends BaseMapper<TbGiftUserAnswer> {

    int insertList(@Param("giftUserAnswerList") List<TbGiftUserAnswer> giftUserAnswerList);
}