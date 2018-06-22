package cn.sparke.support.modules.v1.writing.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.support.modules.v1.writing.service.WritingTranslationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 18:42
 */
@LoginAnnot
@RestController
@RequestMapping("${version}/writing_translation")
public class WritingTranslationController {

    @Resource
    private WritingTranslationService writingTranslationService;

    @GetMapping
    public ResponseEntity getWritingTranslation(){
        return ResponseEntity.ok(writingTranslationService.findWritingTranslation());
    }
}
