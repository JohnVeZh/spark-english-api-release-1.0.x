package cn.sparke.community.modules.v1.news.controller;

import cn.sparke.community.modules.v1.news.service.CommunityNewsService;
import cn.sparke.core.common.utils.ContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yangye on 2017/7/11.
 */
@RestController
@RequestMapping("/${version}/news")
public class CommunityNewsController {

    @Autowired
    private CommunityNewsService newsService;

    /**
     * 获取资讯列表
     * @param start
     * @return
     */
    @GetMapping
    public ResponseEntity findList(@RequestParam("start") Integer start) {
        return ResponseEntity.ok(newsService.findList(start));
    }

    /**
     * 根据资讯id、用户id，查询资讯详情
     * @param newsId
     * @return
     */
    @GetMapping("/{newsId}")
    public ResponseEntity getById(@PathVariable("newsId") String newsId) {
        return ResponseEntity.ok(newsService.getById(newsId, ContextUtils.getCurAuth().getUserId()));
    }

    /**
     * 资讯推荐列表
     * @param start
     * @param rows
     * @return
     */
    @GetMapping("/recommend_list")
    public ResponseEntity getRecommendList(@RequestParam("start") Integer start , @RequestParam("rows") Integer rows) {
        return ResponseEntity.ok(newsService.getRecommendList(start, rows));
    }
}
