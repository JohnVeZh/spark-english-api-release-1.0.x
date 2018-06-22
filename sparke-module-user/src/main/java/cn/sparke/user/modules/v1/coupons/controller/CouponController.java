package cn.sparke.user.modules.v1.coupons.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.user.modules.v1.coupons.bean.CouponDrawBean;
import cn.sparke.user.modules.v1.coupons.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangbowen on 2017/7/12.
 */
@RestController
@RequestMapping("/${version}/coupons")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @PostMapping("/draw")
    @LoginAnnot
    public ResponseEntity draw(@RequestBody @Validated CouponDrawBean couponDrawBean){
        return couponService.draw(couponDrawBean);
    }
}
