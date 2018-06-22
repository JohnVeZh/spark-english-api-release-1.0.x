package cn.sparke.gift.modules.v1.estimate.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.gift.modules.v1.estimate.service.EstimateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Estimate Controller
 * @author houxusen
 */
@RestController
@RequestMapping("${version}/estimate")
public class EstimateController {

    @Resource
    private EstimateService estimateService;

    /**
     * 获取用户估分试卷列表
     * @return
     */
    @GetMapping("")
    @LoginAnnot
    public ResponseEntity queryEstimateCatalog(){

        return ResponseEntity.ok(estimateService.queryEstimateCatalog());
    }
}
