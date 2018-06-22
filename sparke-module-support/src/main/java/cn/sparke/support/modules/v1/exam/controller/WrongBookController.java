package cn.sparke.support.modules.v1.exam.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.support.modules.v1.exam.service.WrongBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 21:24
 */
@LoginAnnot
@RestController
@RequestMapping("${version}/exam/wrong_books")
public class WrongBookController {
    @Resource
    private WrongBookService wrongBookService;

    //    获取用户错题本数据
    @GetMapping
    public ResponseEntity getWrongBook() {
        return ResponseEntity.ok(wrongBookService.findWrongBook());
    }

    //根据结构ID获取某个详细错题
    @GetMapping("/{structureId}")
    public ResponseEntity getWrongBook(@PathVariable String structureId) {
        return ResponseEntity.ok(wrongBookService.findWrongQuestionByStructureId(structureId));
    }

    /*
    //获取推荐的错题列表
    @GetMapping("/recommend")
    public ResponseEntity recommend() {
        return ResponseEntity.ok(wrongBookService.getRecommendList());
    }

    //    获取错题的详细信息
    @GetMapping("/recommend/{questionId}")
    public ResponseEntity getWrongBookRecommend(@PathVariable String questionId) {
        return ResponseEntity.ok(wrongBookService.findWrongQuestionByQuestionId(questionId));
    }
    */

}
