package cn.sparke.user.modules.v1.praise.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.user.modules.v1.praise.bean.PraiseBean;
import cn.sparke.user.modules.v1.praise.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhangbowen on 2017/7/11.
 */
@RestController
@RequestMapping("/${version}/praise")
public class PraiseController {
    @Autowired
    private PraiseService praiseService;

    @PostMapping
    @LoginAnnot
    public ResponseEntity save(@RequestBody @Validated PraiseBean praiseBean) {
        praiseBean.setUserId(ContextUtils.getCurAuth().getUserId());
        praiseService.save(praiseBean);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{contentId}")
    @LoginAnnot
    public ResponseEntity delete(@PathVariable String contentId) {
        praiseService.cancel(contentId);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
