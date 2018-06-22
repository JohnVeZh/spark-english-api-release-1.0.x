package cn.sparke.gift.modules.v1.estimate.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.gift.modules.v1.estimate.bean.vo.EstimateCatalog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 评估mapper
 * @author houxusen
 */
@Mapper
public interface EstimateMapper extends BaseMapper {

    /**
     * 查询评估目录
     * @param userId 用户ID
     * @param sectionCode 学段
     * @return
     */
    List<EstimateCatalog> queryEstimateCatalog(@Param("userId") String userId,@Param("sectionCode") int sectionCode);
}
