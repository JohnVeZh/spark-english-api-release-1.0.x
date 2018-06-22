package cn.sparke.easy.modules.v1.captionlistenings.controller;

import cn.sparke.easy.modules.v1.captionlistenings.service.ICaptionListeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanghaiguang on 2017/7/11.
 * 字幕听力controller
 */
@RestController
@RequestMapping ("/${version}")
public class CaptionListeningController {

    @Autowired
    private ICaptionListeningService captionListeningService;

    /**
     * 获取字幕听力分页列表
     * @param start
     * @return
     */
    @GetMapping ("/caption_listenings")
    public ResponseEntity findList(@RequestParam Integer start) {
        return ResponseEntity.ok(captionListeningService.queryList(start));
    }

}
