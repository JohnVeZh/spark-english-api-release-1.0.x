package cn.sparke.special.modules.v1.paper.mapper;

import cn.sparke.core.common.bean.BaseEntity;
import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.special.modules.v1.paper.bean.StructureBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 */
public interface StructureMapper extends BaseMapper<StructureBean>{
    List<StructureBean> findList(@Param("paperId") String paperId,@Param("contentType") int contentType,@Param("userId") String userId);
    StructureBean getStructure(@Param("structureId") String structureId);
}
