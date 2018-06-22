package cn.sparke.special.modules.v1.question.controller;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.special.modules.v1.common.ValidationGroup;
import cn.sparke.special.modules.v1.question.bean.QuestionBean;
import cn.sparke.special.modules.v1.question.bean.QuestionItemBean;
import cn.sparke.special.modules.v1.question.bean.QuestionOptionBean;
import cn.sparke.special.modules.v1.question.mapper.QuestionMapper;
import cn.sparke.special.modules.v1.question.service.QuestionService;
import cn.sparke.special.modules.v1.record.bean.QuestionRecordBean;
import cn.sparke.special.modules.v1.report.bean.QuestionReportBean;
import cn.sparke.special.modules.v1.report.mapper.QuestionReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 */
@RestController
@RequestMapping("/${version}/questions")
public class QuestionController {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionService questionService;
    @Autowired
    QuestionReportMapper reportMapper;
    @GetMapping
    public ResponseEntity findQuestionList(@RequestParam("structureId") String structureId){
        String userId = ContextUtils.getCurAuth().getUserId();
        List<QuestionBean> questionBeanList = questionMapper.findQuestionList(userId,structureId);
        return  ResponseEntity.ok(questionBeanList);
    }
    @GetMapping("/{questionId}")
    public ResponseEntity getQuestion(@PathVariable("questionId") String questionId, @RequestParam("type") int type){
        String userId = ContextUtils.getCurAuth().getUserId();
        QuestionBean questionBean = questionMapper.getQuestion(userId,questionId,type);
        if(questionBean != null){
            QuestionRecordBean recordBean = questionBean.getRecordInfo();
            if(recordBean != null){
                questionBean.setIsFinish(recordBean.getIsFinish());
                if(questionBean.getType()>2){
                    questionBean.setDifficultyLevel(recordBean.getDifficultyLevel());
                }else{
                    questionBean.setUseTime(recordBean.getUseTime());
                }
                if(recordBean.getId() != null){
                    questionBean.setHasHistory(1);
                }else{
                    questionBean.setHasHistory(0);
                }
                questionBean.setRecordInfo(null);
            }
            int pzch=0,xipp =0,pzyd=0;
            List<QuestionItemBean> questionItemList = questionBean.getQuestionItemList();
            if(type == 2 && questionItemList != null && questionItemList.size()>0 ){
                for(QuestionItemBean itemBean : questionItemList){
                    if(itemBean.getContent() != null && !itemBean.getContent().equals("")){
                        if(itemBean.getOptionList() != null && itemBean.getOptionList().size()>0){
                            if(itemBean.getOptionList().size()<=4 ){
                                int i = 0;
                                for(QuestionOptionBean optionBean : itemBean.getOptionList()){
                                    i++;
                                    if(optionBean.getContent() != null && !optionBean.getContent().equals("")){
                                        pzyd++;
                                        break;
                                    }
                                    if(itemBean.getOptionList().size() == i){
                                        xipp++;
                                    }
                                }
                            }else{
                                xipp++;
                            }
                        }
                    }else{
                        pzch++;
                    }
                }
                int result=Math.max(pzch, Math.max(xipp, pzyd));
                if(pzch==result){
                    questionBean.setReadingType(1);
                }else if(xipp==result){
                    questionBean.setReadingType(2);
                }else{
                    questionBean.setReadingType(3);
                }
            }
        }
        return  ResponseEntity.ok(questionBean);
    }


    @PostMapping("/quit")
    @LoginAnnot
    public ResponseEntity quit(@Validated( { ValidationGroup.quit.class }) @RequestBody QuestionReportBean reportBean){
        if(reportBean.getQuestion() == null){
            return  new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        AuthEntity entity = ContextUtils.getCurAuth();
        String userId = entity.getUserId();
        int sectionCode  = entity.getSectionCode();
        reportBean.setUserId(userId);
        reportBean.setSectionCode(sectionCode);
//        String id = reportMapper.getExistReport(reportBean.getUserId(),reportBean.getQuestion().getId());
//        if(id == null || id.equals("")) {
            questionService.quit(reportBean);
//        }else{
//            return new ResponseErrorEntity(StatusCode.EXIST_REPORT,HttpStatus.BAD_REQUEST);
//        }
        return  new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/submit")
    @LoginAnnot
    public ResponseEntity submit(@Validated( { ValidationGroup.submit.class }) @RequestBody QuestionReportBean reportBean){
        if(reportBean.getQuestion() == null){
            return  new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        questionService.submit(reportBean);
        return  new ResponseEntity(HttpStatus.CREATED);
    }
}
