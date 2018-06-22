package cn.sparke.support.modules.v1.exam.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.core.common.mybatis.utils.PagerUtils;
import cn.sparke.support.modules.v1.exam.bean.report.vo.DetailReport;
import cn.sparke.support.modules.v1.exam.bean.report.vo.Report;
import cn.sparke.support.modules.v1.exam.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 21:23
 */

@RestController
@RequestMapping("${version}/exam")
public class ReportController {

    @Resource
    private ReportService reportService;

    //    获取用户平均数据
    @GetMapping("/composite_report")
    @LoginAnnot
    public ResponseEntity getAvgReport() {
        return ResponseEntity.ok(reportService.getAvgReport2());
    }

    //    获取用户的所有报告
    @GetMapping("/reports")
    @LoginAnnot
    public ResponseEntity getReports(@RequestParam(value = "start", defaultValue = "0") Integer start,
                                     @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        return ResponseEntity.ok(PagerUtils.getPager(reportService.getReportList(start, rows)));
    }

    //这个地方返回数据结构不合理，木已成舟。
    //    获取报告详细信息
    @GetMapping("/reports/{reportId}")
    public ResponseEntity getReport(@PathVariable String reportId) {
        return ResponseEntity.ok(reportService.getReportDetail(reportId));
    }
}
