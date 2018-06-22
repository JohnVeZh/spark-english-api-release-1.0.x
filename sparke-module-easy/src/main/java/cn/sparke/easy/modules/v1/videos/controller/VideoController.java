package cn.sparke.easy.modules.v1.videos.controller;

import cn.sparke.easy.modules.v1.videos.service.IVedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wanghaiguang on 2017/7/11.
 * 字幕听力controller
 */
@RestController
@RequestMapping ("/${version}")
public class VideoController {

    @Autowired
    private IVedioService vedioService;

    /**
     * 获取简视频分页列表
     * @param start
     * @return
     */
    @GetMapping ("/videos/{catalogId}")
    public ResponseEntity findList(@RequestParam Integer start, @PathVariable  String catalogId) {
        return ResponseEntity.ok(vedioService.queryList(start,catalogId));
    }

}
