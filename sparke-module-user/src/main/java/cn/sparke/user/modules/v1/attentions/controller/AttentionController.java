package cn.sparke.user.modules.v1.attentions.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.user.modules.v1.attentions.bean.AttentionBean;
import cn.sparke.user.modules.v1.attentions.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhangbowen on 2017/7/11.
 */
@RestController
@RequestMapping("/${version}/attentions")
public class AttentionController {
    @Autowired
    private AttentionService attentionService;

    @PostMapping
    @LoginAnnot
    public ResponseEntity save(@RequestBody @Validated AttentionBean attentionBean) {
        attentionService.save(attentionBean);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{contentId}")
    @LoginAnnot
    public ResponseEntity delete(@PathVariable String contentId) {
        attentionService.cancelAttention(contentId);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 我的关注列表
     * @param start
     * @return
     */
    @GetMapping
    @LoginAnnot
    public ResponseEntity list(@RequestParam Integer start) {
        AttentionBean attentionBean = new AttentionBean();
        attentionBean.setStart(start);
        attentionBean.setUserId(ContextUtils.getCurAuth().getUserId());
        return ResponseEntity.ok(attentionService.findList(attentionBean));
    }
}
