package cn.sparke.goods.modules.v1.book.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.goods.modules.v1.book.bean.ProductBookBean;
import cn.sparke.goods.modules.v1.book.bean.ProductBookTypeBean;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by yangye on 2017/7/11.
 */
public interface ProductBookMapper extends BaseMapper<ProductBookBean> {

    Page<ProductBookTypeBean> getBookTypeList();

    List<ProductBookBean> findList(@Param("typeId") String typeId, @Param("sectionCode") int sectionCode);

    List<ProductBookBean> getHotSearchBooksList(@Param("searchTitle") String searchTitle);

    ProductBookBean getById(@Param("bookId") String bookId, @Param("userId") String userId);

}
