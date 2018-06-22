package cn.sparke.support.modules.v1.writing.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.support.modules.v1.writing.bean.vo.WritingTranslationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 18:53
 */
public interface WritingTranslationMapper extends BaseMapper<WritingTranslationVo>{

    List<WritingTranslationVo> findWritingTranslation(@Param("sectionCode") int sectionCode);
}
