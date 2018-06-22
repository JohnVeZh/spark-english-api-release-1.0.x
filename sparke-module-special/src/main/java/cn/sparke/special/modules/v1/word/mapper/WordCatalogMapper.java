package cn.sparke.special.modules.v1.word.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.special.modules.v1.word.bean.WordCatalogBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 */
public interface WordCatalogMapper extends BaseMapper<WordCatalogBean> {

    List<WordCatalogBean> findTwoCatalogList(@Param("userId") String userId,@Param("sectionCode") int sectionCode,@Param("parentCatalogId") String parentCatalogId);
    List<WordCatalogBean> findThreeCatalogList(@Param("userId") String userId,@Param("sectionCode") int sectionCode,@Param("parentCatalogId") String parentCatalogId);
}
