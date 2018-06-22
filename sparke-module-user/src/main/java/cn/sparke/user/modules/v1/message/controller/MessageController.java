package cn.sparke.user.modules.v1.message.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.user.modules.v1.message.bean.MessageBean;
import cn.sparke.user.modules.v1.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhangbowen on 2017/7/11.
 */
@RestController
@RequestMapping("/${version}/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    /**
     * 消息列表
     *
     * @param start
     * @return
     */
    @GetMapping
    @LoginAnnot
    public ResponseEntity findList(@RequestParam Integer start) {
        MessageBean messageBean = new MessageBean();
        messageBean.setStart(start);
        return ResponseEntity.ok(messageService.findList(messageBean));
    }

    /**
     * 消息详情
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @LoginAnnot
    public ResponseEntity info(@PathVariable String id) {
        return ResponseEntity.ok(messageService.info(id));
    }

    /**
     * 是否存在新消息
     *
     * @return
     */
    @GetMapping("/new_message_exist")
    @LoginAnnot
    public ResponseEntity new_message_exist() {
        return messageService.new_message_exist();
    }

    /**
     * 删除消息
     *
     * @return
     */
    @DeleteMapping("/{id}")
    @LoginAnnot
    public ResponseEntity delete(@PathVariable String id) {
        String userId = ContextUtils.getCurAuth().getUserId();
        messageService.deleteMsg(userId, id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
