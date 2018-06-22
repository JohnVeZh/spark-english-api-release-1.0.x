package cn.sparke.gift.modules.v1.estimate.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.gift.modules.v1.estimate.service.EstimateReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 报告Controller
 */
@RestController
@RequestMapping("${version}/estimate")
public class EstimateReportController {

    @Resource
    private EstimateReportService estimateReportService;

    /**
     * 获取报告详情
     * @param reportId 报告id
     * @return
     */
    @GetMapping("/report/{reportId}")
    @LoginAnnot
    public ResponseEntity report(@PathVariable String reportId){
        return ResponseEntity.ok(estimateReportService.report(reportId));
    }
}
