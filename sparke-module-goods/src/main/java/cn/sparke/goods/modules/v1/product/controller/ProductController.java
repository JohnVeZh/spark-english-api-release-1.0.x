package cn.sparke.goods.modules.v1.product.controller;

import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.goods.modules.v1.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yangye on 2017/7/13.
 */
@RestController
@RequestMapping("/${version}")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity getById(@PathVariable("productId") String productId, @RequestParam("productType") Integer productType) {
        return ResponseEntity.ok(productService.getById(ContextUtils.getCurAuth().getUserId(), productId, productType));
    }


}
