package cn.sparke.support.modules.v1.exam.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.support.modules.v1.caption.bean.vo.PaperCatalog;
import cn.sparke.support.modules.v1.exam.bean.paper.vo.PaperInfo;
import cn.sparke.support.modules.v1.exam.bean.paper.vo.PaperStructureItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 14:56
 */
@Mapper
public interface ExamMapper extends BaseMapper<PaperCatalog> {

    PaperInfo getPaper(@Param("paperId") String paperId);

    List<PaperStructureItem> findPaperStructure(@Param("paperId") String paperId);
}
