package cn.sparke.special.modules.v1.paper.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.special.modules.v1.paper.bean.SpecialExplainBean;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/7/14.
 */
public interface SpecialExplainMapper extends BaseMapper<SpecialExplainBean> {
    Page<SpecialExplainBean> findList(@Param("type") int type,@Param("sectionCode") int sectionCode);
    SpecialExplainBean getExplain(@Param("explainId")String explainId);
    int addVisitNum(@Param("explainId") String explainId);
}
