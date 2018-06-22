package cn.sparke.support.modules.v1.video.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.support.modules.v1.video.bean.vo.TeacherVideos;
import cn.sparke.support.modules.v1.word.bean.po.TbWordCatalog;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 16:06
 */
@Mapper
public interface IVideoMapper extends BaseMapper<TbWordCatalog>{

    /**
     * 查找网课中的名师视频
     */
    public Page<TeacherVideos> findFamousTeacherBySectionCode(@Param("sectionCode") Integer sectionCode);
}
