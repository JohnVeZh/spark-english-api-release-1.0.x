package cn.sparke.base.modules.v1.banners.controller;

import cn.sparke.base.modules.v1.banners.bean.BannerBean;
import cn.sparke.base.modules.v1.banners.constants.BannerConstants;
import cn.sparke.base.modules.v1.banners.service.BannerService;
import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.core.modules.token.constants.TokenConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhangbowen on 2017/7/10.
 */
@RestController
@RequestMapping("/${version}/banners")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    /**
     * banner列表
     *
     * @param moduleType
     * @return
     */
    @GetMapping
    public ResponseEntity banners(@RequestParam Integer moduleType) {
        AuthEntity authEntity = ContextUtils.getCurAuth();
        BannerBean bannerBean = new BannerBean();
        bannerBean.setModuleType(moduleType);
        bannerBean.setSectionCode(authEntity.getSectionCode());
        if (authEntity.getTerminal() == TokenConstants.TERMINAL.PC) {
            bannerBean.setTerminalType(BannerConstants.TERMINAL.TYPE_PC);
        } else {
            bannerBean.setTerminalType(BannerConstants.TERMINAL.TYPE_APP);
        }
        return ResponseEntity.ok(bannerService.findList(bannerBean));
    }

    /**
     * banner 详情
     *
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity info(@PathVariable String id) {
        return ResponseEntity.ok(bannerService.info(id));
    }
}
