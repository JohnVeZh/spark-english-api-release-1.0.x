package cn.sparke.gift.modules.v1.estimate.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.gift.modules.v1.estimate.bean.po.TbGiftSubjectiveRuleDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/8/21 14:10
 */
@Mapper
public interface TbGiftSubjectiveRuleDetailMapper extends BaseMapper<TbGiftSubjectiveRuleDetail>{
    List<TbGiftSubjectiveRuleDetail> findByIdList(@Param("ruleDetailIdList") List<String> ruleDetailIdList);
}
