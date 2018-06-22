package cn.sparke.base.modules.v1.qiniu.controller;

import cn.sparke.base.modules.v1.qiniu.service.QiNiuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangbowen on 2017/7/8.
 */
@RestController
@RequestMapping("/${version}/qiniu")
public class QiNiuController {
    @Autowired
    private QiNiuService qiNiuService;

    @GetMapping("/sign")
    public ResponseEntity sign() {
        return ResponseEntity.ok(qiNiuService.uploadSign());
    }
}
