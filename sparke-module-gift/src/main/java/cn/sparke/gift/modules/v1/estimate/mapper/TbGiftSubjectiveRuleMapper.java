package cn.sparke.gift.modules.v1.estimate.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.gift.modules.v1.estimate.bean.vo.RuleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface TbGiftSubjectiveRuleMapper extends BaseMapper {

    List<RuleVo> findRuleDetailsVo(@Param("sectionCode") int sectionCode, @Param("paperId") String paperId);
}