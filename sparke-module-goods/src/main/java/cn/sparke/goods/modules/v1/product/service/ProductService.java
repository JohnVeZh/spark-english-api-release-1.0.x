package cn.sparke.goods.modules.v1.product.service;

import cn.sparke.goods.modules.v1.product.bean.ProductBean;
import cn.sparke.goods.modules.v1.product.constants.ProductTypeConstants;
import cn.sparke.goods.modules.v1.product.mapper.ProductMapper;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yangye on 2017/7/13.
 */
@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public ProductBean getById(String userId, String productId, Integer productType) {
        // 商品类型(1.网课 2.图书)
        if(productType != null && productType.equals(ProductTypeConstants.NETWORK_COURSE)){
            return productMapper.getProductNetworkCourseById(productId);
        } else if (productType != null && productType.equals(ProductTypeConstants.BOOK)) {
            return productMapper.getProductBookById(productId, userId);
        }
        return null;
    }

}
