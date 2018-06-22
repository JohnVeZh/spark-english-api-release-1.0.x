package cn.sparke.support.modules.v1.exam.mapper.report;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.support.modules.v1.exam.bean.submit.po.TbPaperStructure;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/13 12:02
 */
@Mapper
public interface TbPaperStructureMapper extends BaseMapper<TbPaperStructure> {
    List<TbPaperStructure> findByIdList(Set<String> structureIdlist);

    /**
     * 根据传入的父级ID获取所有的的子节点
     *
     * @param structureId 父级ID
     */
    List<TbPaperStructure> findLeafChilBypId(@Param("structureId") String structureId);

    List<TbPaperStructure> findByPid(@Param("structureId") String structureId);
}
