package cn.sparke.gift.modules.v1.estimate.service;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.gift.modules.v1.estimate.bean.po.TbGiftPeriodPaper;
import cn.sparke.gift.modules.v1.estimate.bean.po.TbGiftSubjectiveSubmitRecord;
import cn.sparke.gift.modules.v1.estimate.bean.vo.IsOneselfVo;
import cn.sparke.gift.modules.v1.estimate.bean.vo.RuleVo;
import cn.sparke.gift.modules.v1.estimate.constant.PeriodType;
import cn.sparke.gift.modules.v1.estimate.mapper.TbGiftPeriodPaperMapper;
import cn.sparke.gift.modules.v1.estimate.mapper.TbGiftSubjectiveRuleMapper;
import cn.sparke.gift.modules.v1.estimate.mapper.TbGiftSubjectiveSubmitRecordMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/8/21 10:38
 */
@Service
public class SubjectiveRuleService {

    @Resource
    private TbGiftSubjectiveSubmitRecordMapper tbGiftSubjectiveSubmitRecordMapper;
    @Resource
    private TbGiftSubjectiveRuleMapper tbGiftSubjectiveRuleMapper;

    @Resource
    private TbGiftPeriodPaperMapper giftPeriodPaperMapper;

    public ResponseEntity isOneself(String paperId) {
        TbGiftPeriodPaper giftPeriodPaper = giftPeriodPaperMapper.getById(paperId);
        if (giftPeriodPaper == null){
            return new ResponseErrorEntity(StatusCode.GIFT_ESTIMATE_PAPERID_ERROR, HttpStatus.BAD_REQUEST);
        }

        AuthEntity authEntity = ContextUtils.getCurAuth();
        IsOneselfVo isOneselfVo = new IsOneselfVo();
        isOneselfVo.setPaperId(paperId);
        isOneselfVo.setName(giftPeriodPaper.getName());
        isOneselfVo.setPeriod(giftPeriodPaper.getPeriod());
        //是否需要后台批改
        if (checkNeedSystemCorrect(paperId)) {
            isOneselfVo.setIsOneself(0);
        } else {
            List<RuleVo> ruleVoList = tbGiftSubjectiveRuleMapper.findRuleDetailsVo(authEntity.getSectionCode(), paperId);
            isOneselfVo.setIsOneself(1);
            isOneselfVo.setRuleList(ruleVoList);
        }
        return ResponseEntity.ok(isOneselfVo);
    }

    /**
     * 检测是否需要后台批改
     *
     * @return true 需要后台评价
     * false 自己批改
     */
    public boolean checkNeedSystemCorrect(String paperId) {
        AuthEntity authEntity = ContextUtils.getCurAuth();
        TbGiftPeriodPaper giftPeriodPaper = giftPeriodPaperMapper.getById(paperId);
        TbGiftSubjectiveSubmitRecord giftSubjectiveSubmitRecord = tbGiftSubjectiveSubmitRecordMapper.getByUserIdAndSectionCode(authEntity.getUserId(), authEntity.getSectionCode());
        switch (giftPeriodPaper.getPeriod()) {
            case PeriodType.PRE: {
                //是否需要后台批改
                if (giftSubjectiveSubmitRecord.getPreTranslateUse() < giftSubjectiveSubmitRecord.getPreTranslateTotal() && giftSubjectiveSubmitRecord.getPreWriteUse() < giftSubjectiveSubmitRecord.getPreWriteTotal()) {
                    return true;
                }
                break;
            }
            case PeriodType.MID: {
                //是否需要后台批改
                if (giftSubjectiveSubmitRecord.getMidTranslateUse() < giftSubjectiveSubmitRecord.getMidTranslateTotal() && giftSubjectiveSubmitRecord.getMidWriteUse() < giftSubjectiveSubmitRecord.getMidWriteTotal()) {
                    return true;
                }
                break;
            }
            case PeriodType.POST: {
                //是否需要自己批改
                if (giftSubjectiveSubmitRecord.getPostTranslateUse() < giftSubjectiveSubmitRecord.getPostTranslateTotal() && giftSubjectiveSubmitRecord.getPostWriteUse() < giftSubjectiveSubmitRecord.getPostWriteTotal()) {
                    return true;
                }
                break;
            }
        }
        return false;
    }
}
