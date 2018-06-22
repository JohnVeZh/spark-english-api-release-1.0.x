package cn.sparke.goods.modules.v1.book.service;

import cn.sparke.core.common.constants.PageConstants;
import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.goods.modules.v1.book.bean.ProductBookBean;
import cn.sparke.goods.modules.v1.book.bean.ProductBookTypeBean;
import cn.sparke.goods.modules.v1.book.mapper.ProductBookMapper;
import cn.sparke.goods.modules.v1.utils.MyPageUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by yangye on 2017/7/11.
 */
@Service
public class ProductBookService {
    @Autowired
    private ProductBookMapper bookMapper;

    public PagerBean<ProductBookTypeBean> getBookTypeList(Integer start) {
        PageHelper.offsetPage(start, PageConstants.PAGE_NUM);
        Page<ProductBookTypeBean > bookTypeList = bookMapper.getBookTypeList();
        return MyPageUtil.getPagerBean(new PageInfo<>(bookTypeList));
    }

    public PagerBean<ProductBookBean> getHotSearchBooksList(Integer start, String searchTitle) {
        PageHelper.offsetPage(start,PageConstants.PAGE_NUM);
        List<ProductBookBean > bookList = bookMapper.getHotSearchBooksList(searchTitle);
        return MyPageUtil.getPagerBean(new PageInfo<>(bookList));
    }

    public PagerBean<ProductBookBean> findList(Integer start, String typeId) {
        PageHelper.offsetPage(start,PageConstants.PAGE_NUM);
        List<ProductBookBean > bookList = bookMapper.findList(typeId, ContextUtils.getCurAuth().getSectionCode());
        return MyPageUtil.getPagerBean(new PageInfo<>(bookList));
    }

    public ProductBookBean getById(String bookId, String userId) {
        return bookMapper.getById(bookId, userId);
    }

}
