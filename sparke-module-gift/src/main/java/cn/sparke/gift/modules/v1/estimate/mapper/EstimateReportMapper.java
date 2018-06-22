package cn.sparke.gift.modules.v1.estimate.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.gift.modules.v1.estimate.bean.po.TbGiftReportSuggestConfig;
import cn.sparke.gift.modules.v1.estimate.bean.vo.EstimateReport;
import cn.sparke.gift.modules.v1.estimate.bean.vo.Title;
import cn.sparke.gift.modules.v1.estimate.bean.vo.UserEstimate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EstimateReportMapper extends BaseMapper{
    /**
     * 查询称号列表
     * @param sectionCode
     * @return
     */
    List<Title> queryTitles(@Param("sectionCode") int sectionCode);

    /**
     * 查询报告
     * @param sectionCode
     * @param reportId
     * @return
     */
    EstimateReport queryReport(@Param("sectionCode") int sectionCode,@Param("reportId") String reportId);

    /**
     * 获取用户自评分列表
     * @param answerId
     * @return
     */
    List<UserEstimate> queryUserEstimate(@Param("answerId") String answerId);

    List<TbGiftReportSuggestConfig> querySuggest(@Param("sectionCode") int sectionCode);
}
