package cn.sparke.base.modules.v1.sms.controller;

import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.modules.sms.SmsFacade;
import cn.sparke.core.modules.sms.bean.SendCodeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhangbowen on 2016/5/17.
 */
@RequestMapping("/${version}/sms")
@RestController
public class SmsController {
    @Autowired
    private SmsFacade smsFacade;

    @PostMapping
    public ResponseEntity sendCode(@RequestBody @Validated SendCodeBean sendCodeBean) {
        return smsFacade.sendSmsCode(sendCodeBean);
    }

    @GetMapping
    public ResponseEntity validCode(@Validated SendCodeBean sendCodeBean) {
        boolean success = smsFacade.validCode(sendCodeBean);
        if (success) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseErrorEntity(StatusCode.VALIDATE_CODE_ERROR, HttpStatus.NOT_FOUND);
        }
    }
}
