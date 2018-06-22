package cn.sparke.gift.modules.v1.estimate.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.gift.modules.v1.estimate.bean.vo.SubjectiveAnswerVoDetailIdVo;
import cn.sparke.gift.modules.v1.estimate.bean.vo.SubmitAnswerVo;
import cn.sparke.gift.modules.v1.estimate.service.SubjectiveRuleService;
import cn.sparke.gift.modules.v1.estimate.service.UserAnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/8/21 11:27
 */
@LoginAnnot
@Controller
@RequestMapping("${version}/estimate")
public class EstimateSubmitController {


    @Resource
    private SubjectiveRuleService subjectiveRuleService;
    @Resource
    private UserAnswerService userAnswerService;

    @RequestMapping(value = "/{paperId}", method = RequestMethod.POST)
    private ResponseEntity submit(@PathVariable String paperId, @Validated @RequestBody SubmitAnswerVo submitAnswerVo) {
        boolean checkNeedSystemCorrect = subjectiveRuleService.checkNeedSystemCorrect(paperId);
        if (checkNeedSystemCorrect) {
            /*
            String answer = submitAnswerVo.getTranslationAnswers().getAnswer();
            if (Strings.isNullOrEmpty(answer)) {
                return new ResponseErrorEntity(StatusCode.GIFT_ESTIMATE_FIELD_TRANSLATION_NOT_NULL, HttpStatus.BAD_REQUEST);
            }
            String writingAnswer = submit5+nswerVo.getWritingAnswers().getAnswer();
            if (Strings.isNullOrEmpty(writingAnswer)) {
                return new ResponseErrorEntity(StatusCode.GIFT_ESTIMATE_FIELD_WRITING_NOT_NULL, HttpStatus.BAD_REQUEST);
            }
            */
        } else {
            List<SubjectiveAnswerVoDetailIdVo> subjectiveAnswerVoDetailIdVoList = submitAnswerVo.getTranslationAnswers().getAnswerRules();
            if (subjectiveAnswerVoDetailIdVoList == null || subjectiveAnswerVoDetailIdVoList.size() != 4) {
                return new ResponseErrorEntity(StatusCode.GIFT_ESTIMATE_FIELD_WRITING_ONESELF_NOT_NULL, HttpStatus.BAD_REQUEST);
            }
            List<SubjectiveAnswerVoDetailIdVo> writingSubjectiveAnswerVoDetailIdVoList = submitAnswerVo.getWritingAnswers().getAnswerRules();
            if (writingSubjectiveAnswerVoDetailIdVoList == null || writingSubjectiveAnswerVoDetailIdVoList.size() != 5) {
                return new ResponseErrorEntity(StatusCode.GIFT_ESTIMATE_FIELD_TRANSLATION_ONESELF_NOT_NULL, HttpStatus.BAD_REQUEST);
            }
        }
        return userAnswerService.submit(paperId, submitAnswerVo, checkNeedSystemCorrect);
    }
}
