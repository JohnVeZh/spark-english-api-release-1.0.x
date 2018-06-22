package cn.sparke.gift.modules.v1.exercise.controller;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.PageConstants;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.mybatis.utils.PagerUtils;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.gift.modules.v1.exercise.bean.*;
import cn.sparke.gift.modules.v1.exercise.common.ValidationGroup;
import cn.sparke.gift.modules.v1.exercise.mapper.GiftExerciseMapper;
import cn.sparke.gift.modules.v1.exercise.service.GiftExerciseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/8/18.
 */
@RestController
@RequestMapping("/${version}/exercises")
public class GiftExerciseController {
    @Autowired
    public GiftExerciseMapper exerciseMapper;
    @Autowired
    public GiftExerciseService exerciseService;
    @GetMapping
    public ResponseEntity findQuestionList(@RequestParam("start") int start){
        AuthEntity auth = ContextUtils.getCurAuth();
        String userId = auth.getUserId();
        int sectionCode = auth.getSectionCode();
        //填充分页参数
        PageHelper.offsetPage(start, PageConstants.PAGE_NUM);
        Page<GiftExerciseBean> gifts = exerciseMapper.findList(userId,sectionCode);
        return  ResponseEntity.ok(PagerUtils.getPager(gifts));
    }
    @GetMapping("/{questionId}")
    public ResponseEntity getQuestion(@PathVariable("questionId") String questionId, @RequestParam("type") int type){
        String userId = ContextUtils.getCurAuth().getUserId();
        QuestionBean questionBean = exerciseMapper.getQuestion(userId,questionId,type);
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
        String id = exerciseMapper.getExistReport(reportBean.getUserId(),reportBean.getQuestion().getId());
        if(id == null || id.equals("")) {
            exerciseService.quit(reportBean);
        }else{
            return new ResponseErrorEntity(StatusCode.EXIST_REPORT,HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/submit")
    @LoginAnnot
    public ResponseEntity submit(@Validated( { ValidationGroup.submit.class }) @RequestBody QuestionReportBean reportBean){
        if(reportBean.getQuestion() == null){
            return  new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        exerciseService.submit(reportBean);
        return  new ResponseEntity(HttpStatus.CREATED);
    }
    @PostMapping("/submit_paper")
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
        String id = exerciseMapper.getExistReport(reportBean.getUserId(),reportBean.getQuestion().getId());
        QuestionReportBean report = null;
        if(id == null || id.equals("")) {
            report = exerciseService.submitPaper(reportBean);
        }else{
            return new ResponseErrorEntity(StatusCode.EXIST_REPORT,HttpStatus.BAD_REQUEST);
        }
        return  ResponseEntity.ok(report);
    }
    /**
     * 诊断报告
     * @param contentId
     * @return
     */
    @GetMapping("/reports/{contentId}")
    @LoginAnnot
    public ResponseEntity getReport(@PathVariable("contentId") String contentId ,@RequestParam("type") int type){
        if(type != 1 && type !=2){
            return new ResponseErrorEntity(StatusCode.VALIDATION_FAILED,HttpStatus.BAD_REQUEST);
        }
        AuthEntity entity = ContextUtils.getCurAuth();
        QuestionReportBean reportBean = exerciseMapper.getReport(contentId,type,entity.getUserId(),entity.getSectionCode());
        return ResponseEntity.ok(reportBean);
    }
}
