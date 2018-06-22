package cn.sparke.scan.modules.v1.codes.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghaiguang on 2017/8/23.
 */
@FeignClient (name = "sparke-module-gift")
public interface GiftServiceApi {

    /**
     * 真题列表
     *
     * @param
     * @return
     */
    @GetMapping ("/v1/estimate")
    List recordPaperList(@RequestHeader("Authorization") String auth);

    /**
     * 真题详情
     *
     * @param
     * @return
     */
    @GetMapping ("/v1/estimate/{paperId}/is_oneself")
    Map recordPaperInfo(@PathVariable("paperId") String paperId,@RequestHeader("Authorization") String auth);


    /**
     * 报告详情
     *
     * @param
     * @return
     */
    @GetMapping ("/v1/estimate/report/{reportId}")
    Map reportInfo(@PathVariable("reportId") String reportId,@RequestHeader("Authorization") String auth);

}
