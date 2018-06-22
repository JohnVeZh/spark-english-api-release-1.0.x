package cn.sparke.support.modules.v1.exam.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.support.modules.v1.exam.bean.submit.vo.request.SubmitPaper;
import cn.sparke.support.modules.v1.exam.service.ExamService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 14:53
 */
@LoginAnnot
@RestController
@RequestMapping("${version}/exam")
public class ExamController {

    @Resource
    private ExamService examService;

    //获取试卷目录接口
    @GetMapping("/catalog/papers")
    public ResponseEntity getPaperList() {
        return ResponseEntity.ok(examService.getPaperList());
    }

    //    下载某套试卷
    @GetMapping("/papers/{paperId}/download")
    public ResponseEntity download(@PathVariable String paperId) {
        return ResponseEntity.ok(examService.download(paperId));
    }

    //交卷
    @PostMapping("/papers/submit")
    public ResponseEntity submit(@RequestBody @Validated SubmitPaper submitPaper) {
        return examService.submitPaper(submitPaper);
    }
}
