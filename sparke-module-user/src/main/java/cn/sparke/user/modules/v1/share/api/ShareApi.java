package cn.sparke.user.modules.v1.share.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "sparke-gateway", path = "/v1")
public interface ShareApi {
    /**
     * 专项练习诊断报告
     *
     * @return
     */
    @GetMapping(value = "/specials/reports/{contentId}")
    Object specialsReports(@PathVariable("contentId") String reportId, @RequestParam("type") int type);

    /**
     * 资讯详情
     *
     * @return
     */
    @GetMapping(value = "/communitys/news/{newsId}")
    Object newsInfo(@PathVariable("newsId") String newsId);

    /**
     * 活动详情
     *
     * @return
     */
    @GetMapping(value = "/communitys/activitys/{activityId}")
    Object activityInfo(@PathVariable("activityId") String activityId);

    /**
     * 图书详情
     *
     * @return
     */
    @GetMapping(value = "/goods/books/{bookId}")
    Object bookInfo(@PathVariable("bookId") String bookId);

    /**
     * 配套专区诊断报告
     *
     * @return
     */
    @GetMapping(value = "/supports/exam/reports/{reportId}")
    Object examReport(@PathVariable("reportId") String reportId);

}
