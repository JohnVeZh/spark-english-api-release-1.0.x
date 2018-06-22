package cn.sparke.support.modules.v1.caption.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.support.modules.v1.caption.bean.po.TbPaper;
import cn.sparke.support.modules.v1.caption.bean.vo.PaperCatalog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 21:28
 */
@Mapper
public interface PaperMapper extends BaseMapper<TbPaper> {

    /**
     * 只要试卷目录类型为 2字幕听力、5扫码字幕听力时，才会有试卷组概念，走这个方法
     */
    List<PaperCatalog> findPaperGroupCatalog(@Param("paperCatalogType") int paperCatalogType, @Param("sectionCode") int sectionCode);


    /**
     * 只要试卷目录类型为 1,3,4,时，没有试卷组概念，走这个方法
     */
    List<PaperCatalog> findPaperByCatalog(@Param("paperCatalogType") int paperCatalogType, @Param("sectionCode") int sectionCode);

}
