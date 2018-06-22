package cn.sparke.support.modules.v1.caption.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.support.modules.v1.caption.service.PaperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 配套专区
 *
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 21:22
 */
@LoginAnnot
@RestController
@RequestMapping("${version}/take")
public class TakeController {

    @Resource
    private PaperService paperService;

    //获取试卷目录列表
    @GetMapping("/{word}")
    public ResponseEntity word(@PathVariable String word) {
        return paperService.getWord(word);
    }

}
