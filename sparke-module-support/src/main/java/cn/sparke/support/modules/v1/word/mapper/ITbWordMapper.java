package cn.sparke.support.modules.v1.word.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.support.modules.v1.word.bean.po.TbWord;
import cn.sparke.support.modules.v1.word.bean.vo.Words;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 11:22
 */
@Mapper
public interface ITbWordMapper extends BaseMapper<TbWord> {

    Page<Words> findByCatalogId(@Param("userId") String userId, @Param("catalogId") String catalogId);

    List<Words> findByWord(@Param("word") String word);

    List<Words> findTakeWordByWord(@Param("word") String word, @Param("userId") String userId);
}
