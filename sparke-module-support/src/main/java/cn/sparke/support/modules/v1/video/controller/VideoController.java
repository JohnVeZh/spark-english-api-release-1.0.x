package cn.sparke.support.modules.v1.video.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.core.common.mybatis.utils.PagerUtils;
import cn.sparke.support.modules.v1.video.service.VideoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 16:00IVideoMapper
 */
@LoginAnnot
@RestController
@RequestMapping("${version}/videos")
public class VideoController {

    @Resource
    private VideoService videoService;

    //查找网课中的名师视频
    @GetMapping
    public ResponseEntity getVideo(@RequestParam(value = "start", defaultValue = "0") Integer start,
                                   @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        return ResponseEntity.ok(PagerUtils.getPager(videoService.getTearcherVideoList(start, rows)));
    }
}
