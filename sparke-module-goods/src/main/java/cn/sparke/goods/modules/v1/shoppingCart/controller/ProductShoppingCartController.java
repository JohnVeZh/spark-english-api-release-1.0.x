package cn.sparke.goods.modules.v1.shoppingCart.controller;

import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.goods.modules.v1.shoppingCart.bean.ProductShoppingCartBean;
import cn.sparke.goods.modules.v1.shoppingCart.service.ProductShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangye on 2017/7/12.
 */
@RestController
@RequestMapping("/${version}/shopping_carts")
public class ProductShoppingCartController {

    @Autowired
    private ProductShoppingCartService cartService;

    @PostMapping
//    @LoginAnnot
    public ResponseEntity insert(@RequestBody @Validated ProductShoppingCartBean cartBean) {
        // TODO 用户id从Header获取
        cartBean.setUserId(ContextUtils.getCurAuth().getUserId());
        if (cartBean.getUserId() == null) {
            return new ResponseErrorEntity(StatusCode.USER_NOT_EXIST, HttpStatus.BAD_REQUEST);
        }
        cartService.insert(cartBean);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    //    @LoginAnnot
    public ResponseEntity update(@RequestBody ProductShoppingCartBean cartBean) {
//        cartBean.setId(cartId);
        cartService.update(cartBean);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping
    //    @LoginAnnot
    public ResponseEntity delete(@RequestBody ProductShoppingCartBean cartBean) {
        cartService.delete(cartBean.getId());
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity findList(@RequestParam("start") Integer start) {
        return ResponseEntity.ok(cartService.findList(start, ContextUtils.getCurAuth().getUserId()));
    }

    /**
     * 根据用户id，获取用户购物车数量
     * @return
     */
    @GetMapping("/nums")
    public ResponseEntity getShoppingCartNum() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("cartsNum", cartService.getShoppingCartNum(ContextUtils.getCurAuth().getUserId()));
        return ResponseEntity.ok(resultMap);
    }


}
