package cn.sparke.goods.modules.v1.shoppingCart.service;

import cn.sparke.core.common.constants.PageConstants;
import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.goods.modules.v1.shoppingCart.bean.ProductShoppingCartBean;
import cn.sparke.goods.modules.v1.shoppingCart.mapper.ProductShoppingCartMapper;
import cn.sparke.goods.modules.v1.utils.CommUtil;
import cn.sparke.goods.modules.v1.utils.MyPageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yangye on 2017/7/11.
 */
@Service
public class ProductShoppingCartService {
    @Autowired
    private ProductShoppingCartMapper cartMapper;

    public int insert(ProductShoppingCartBean cartBean) {
        cartBean.setId(CommUtil.getUuid());
        return cartMapper.insert(cartBean);
    }

    public int update(ProductShoppingCartBean cartBean) {
        return cartMapper.update(cartBean);
    }

    public int delete(String cartId) {
        return cartMapper.delete(cartId);
    }

    public PagerBean<ProductShoppingCartBean> findList(Integer start, String userId) {
        PageHelper.offsetPage(start, PageConstants.PAGE_NUM);
        List<ProductShoppingCartBean > cartList = cartMapper.findList(userId);
        return MyPageUtil.getPagerBean(new PageInfo<>(cartList));
    }

    public int getShoppingCartNum(String userId) {
        return cartMapper.getShoppingCartNum(userId);
    }


}
