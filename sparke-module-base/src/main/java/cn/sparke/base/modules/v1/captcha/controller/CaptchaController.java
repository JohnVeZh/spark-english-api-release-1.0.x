package cn.sparke.base.modules.v1.captcha.controller;

import cn.sparke.core.modules.captcha.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangbowen on 2017/6/5.
 */
@RestController
@RequestMapping("/${version}/captcha")
public class CaptchaController {
    @Autowired
    private CaptchaService captchaService;

    @GetMapping("/{type}")
    public ResponseEntity captcha(@PathVariable String type) {
        return new ResponseEntity<>(captchaService.generateCaptcha(type), HttpStatus.CREATED);
    }

//    @GetMapping("/{type}/valid")
//    public ResponseEntity captchaValid(@PathVariable String type, @RequestParam String code, @RequestParam String token) {
//        boolean success = captchaService.validCode(type, code, token);
//        if (success) {
//            return new ResponseEntity(HttpStatus.OK);
//        } else {
//            return new ResponseErrorEntity(StatusCode.CAPTCHA_ERROR, HttpStatus.NOT_FOUND);
//        }
//    }
}
