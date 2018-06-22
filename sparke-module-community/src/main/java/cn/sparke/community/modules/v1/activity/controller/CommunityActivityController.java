package cn.sparke.community.modules.v1.activity.controller;

import cn.sparke.community.modules.v1.activity.service.CommunityActivityService;
import cn.sparke.core.common.utils.ContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangye on 2017/7/10.
 */
@RestController
@RequestMapping("/${version}/activitys")
public class CommunityActivityController {

    @Autowired
    private CommunityActivityService activityService;

    @GetMapping
    public ResponseEntity findList(Integer start) {
        return ResponseEntity.ok(activityService.findList(start, ContextUtils.getCurAuth().getUserId()));
    }

    @GetMapping("/{activityId}")
    public ResponseEntity getById(@PathVariable("activityId") String activityId) {
        return ResponseEntity.ok(activityService.getById(activityId, ContextUtils.getCurAuth().getUserId()));
    }
}
