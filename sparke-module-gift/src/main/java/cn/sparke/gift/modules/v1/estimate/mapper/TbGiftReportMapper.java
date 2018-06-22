package cn.sparke.gift.modules.v1.estimate.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.gift.modules.v1.estimate.bean.po.TbGiftReport;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TbGiftReportMapper extends BaseMapper<TbGiftReport> {

    TbGiftReport getByUserIdAndSectionCodeAndPeriod(@Param("userId") String userId, @Param("sectionCode") int sectionCode, @Param("period") int period);
}