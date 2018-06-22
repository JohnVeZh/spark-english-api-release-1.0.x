package cn.sparke.special.modules.v1.paper.mapper;

import cn.sparke.special.modules.v1.paper.bean.PaperBean;
import cn.sparke.core.common.mybatis.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */
public interface PaperMapper extends BaseMapper<PaperBean> {
    /**
     * 查询列表
     * @return
     */
    List<PaperBean> findList(@Param("userId") String userId, @Param("sectionCode") int sectionCode);
    /**
     * 查询列表
     * @return
     */
    List<PaperBean> findWordList(@Param("userId") String userId,@Param("sectionCode") int sectionCode);
}
