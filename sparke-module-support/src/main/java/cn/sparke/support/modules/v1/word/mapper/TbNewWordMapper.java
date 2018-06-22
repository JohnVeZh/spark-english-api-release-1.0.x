package cn.sparke.support.modules.v1.word.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.support.modules.v1.word.bean.po.TbNewWord;
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
public interface TbNewWordMapper extends BaseMapper<TbNewWord> {

    Page<Words> findByUserId(@Param("userId") String userId);

    TbNewWord getByUserAndWordId(@Param("userId") String userId, @Param("wordId") String wordId);

    int deleteByWordIdAndUserId(@Param("wordId") String wordId,@Param("userId") String userId);
}
