package cn.sparke.easy.modules.v1.papers.controller;

import cn.sparke.easy.modules.v1.papers.service.IPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wanghaiguang on 2017/7/10.
 * 写作翻译阅读controller
 */
@RestController
@RequestMapping("/${version}")
public class PaperController {

    @Autowired
    private IPaperService paperService;

    /**
     * 根据试卷目录Id(paperCatalogId),获取简系列试卷列表
     * @param start
     * @param paperCatalogId
     * @return
     */
    @GetMapping ("/papers")
    public ResponseEntity findList(@RequestParam Integer start, @RequestParam String paperCatalogId) {
        return ResponseEntity.ok(paperService.queryPapersByCatalogId(start,paperCatalogId));
    }

     /**
     * 根据试卷Id(paperId),获取简系列试卷结构
     * @param paperId
     * @return
     */

    @GetMapping ("/papers/{paperId}")
    public ResponseEntity getPaperById(@PathVariable String paperId) {
        return ResponseEntity.ok(paperService.getPaperById(paperId));
    }

}
