package cn.sparke.gift.modules.v1.activationCode.controller;

import cn.sparke.common.annot.NoNeedActive;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.gift.modules.v1.activationCode.bean.ActivationCodeBean;
import cn.sparke.gift.modules.v1.activationCode.service.ActivationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yangye on 2017-08-19.
 */
@RestController
@RequestMapping("/${version}/activation_codes")
@NoNeedActive
public class ActivationCodeController {

    @Autowired
    private ActivationCodeService activationCodeService;

    /**
     * 是否已经激活大礼包
     */
    @GetMapping("/is_activated")
    public ResponseEntity isActivated() {
        return activationCodeService.isActivated(ContextUtils.getCurAuth().getUserId(), ContextUtils.getCurAuth().getSectionCode());
    }

    /**
     * 激活码描述信息
     */
    @GetMapping("/{code}/description")
    public ResponseEntity description(@PathVariable("code") String code) {
        ActivationCodeBean codeBean = new ActivationCodeBean();
        codeBean.setCode(code);
        return activationCodeService.description(codeBean);
    }

    /**
     * 激活激活码
     */
    @PostMapping("/activate")
    public ResponseEntity activate(@RequestBody @Validated ActivationCodeBean codeBean) {
        codeBean.setActivateUserId(ContextUtils.getCurAuth().getUserId());
        return activationCodeService.activate(codeBean);
    }



}