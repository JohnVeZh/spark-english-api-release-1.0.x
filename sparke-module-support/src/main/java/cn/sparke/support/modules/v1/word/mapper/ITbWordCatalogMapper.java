package cn.sparke.support.modules.v1.word.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.support.modules.v1.word.bean.po.TbWordCatalog;
import cn.sparke.support.modules.v1.word.bean.vo.WordsCatalogs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 11:03
 */
@Mapper
public interface ITbWordCatalogMapper extends BaseMapper<TbWordCatalog> {

    List<WordsCatalogs> findByTypeAndLevel(@Param("type") String type, @Param("sectionCode") int sectionCode, @Param("level") String level);
}
