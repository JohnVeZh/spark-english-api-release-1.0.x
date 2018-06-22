package cn.sparke.special.modules.v1.paper.controller;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.special.modules.v1.common.ValidationGroup;
import cn.sparke.special.modules.v1.paper.bean.SpecialExplainBean;
import cn.sparke.special.modules.v1.paper.bean.PaperBean;
import cn.sparke.special.modules.v1.paper.bean.StructureBean;
import cn.sparke.special.modules.v1.paper.mapper.PaperMapper;
import cn.sparke.core.common.constants.ProjectProperties;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.special.modules.v1.paper.mapper.SpecialExplainMapper;
import cn.sparke.special.modules.v1.paper.mapper.StructureMapper;
import cn.sparke.special.modules.v1.paper.service.PaperService;
import cn.sparke.special.modules.v1.report.bean.QuestionReportBean;
import cn.sparke.special.modules.v1.report.mapper.QuestionReportMapper;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */
@RestController
@RequestMapping("/${version}/papers")
public class PaperController {
    @Autowired
    private PaperMapper paperMapper;
    @Autowired
    private StructureMapper structureMapper;
    @Autowired
    private SpecialExplainMapper explainMapper;
    @Autowired
    private PaperService paperService;
    @Autowired
    QuestionReportMapper reportMapper;
    @GetMapping
    public ResponseEntity findList() {
        String userId = ContextUtils.getCurAuth().getUserId();
        int sectionCode = ContextUtils.getCurAuth().getSectionCode();
        List<PaperBean> wordList = paperMapper.findWordList(userId,sectionCode);
        List<PaperBean> paperList = paperMapper.findList(userId,sectionCode);
        wordList.stream().forEach(paperBean1 -> {
            paperList.add(0,paperBean1);
        });
        return ResponseEntity.ok(paperList);
    }
    @GetMapping("/{paperId}/structure")
    public ResponseEntity findStructureList(@PathVariable("paperId") String paperId,@RequestParam("contentType") int contentType){
        String userId = ContextUtils.getCurAuth().getUserId();
        List<StructureBean> structureBeanList = structureMapper.findList(paperId,contentType,userId);
        return  ResponseEntity.ok(structureBeanList);
    }
    @GetMapping("/{type}/explains")
    public ResponseEntity findExplainsList(@PathVariable("type") int type){
        int sectionCode = ContextUtils.getCurAuth().getSectionCode();
        List<SpecialExplainBean> explainBeans = explainMapper.findList(type,sectionCode);
        return  ResponseEntity.ok(explainBeans);
    }

    @PutMapping("/explains/{explainId}")
    public ResponseEntity addVisitNum(@PathVariable("explainId") String explainId){
        explainMapper.addVisitNum(explainId);
        return  new ResponseEntity(HttpStatus.CREATED);
    }
    @PostMapping("/submit")
    @LoginAnnot
    public ResponseEntity paperSubmit(@Validated( { ValidationGroup.paperSubmit.class }) @RequestBody QuestionReportBean reportBean){
        if(reportBean.getQuestion() == null){
            return  new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        AuthEntity entity = ContextUtils.getCurAuth();
        String userId = entity.getUserId();
        int sectionCode  = entity.getSectionCode();
        reportBean.setUserId(userId);
        reportBean.setSectionCode(sectionCode);
//        String id = reportMapper.getExistReport(reportBean.getUserId(),reportBean.getQuestion().getId());
        QuestionReportBean report = null;
//        if(id == null || id.equals("")) {
            report = paperService.submitPaper(reportBean);
//        }else{
//            return new ResponseErrorEntity(StatusCode.EXIST_REPORT,HttpStatus.BAD_REQUEST);
//        }
        return  ResponseEntity.ok(report);
    }

}
