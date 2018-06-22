package cn.sparke.special.modules.v1.report.controller;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.PageConstants;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.mybatis.utils.PagerUtils;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.core.modules.cache.CacheFacade;
import cn.sparke.special.modules.v1.record.bean.QuestionRecordBean;
import cn.sparke.special.modules.v1.record.mapper.QuestionRecordMapper;
import cn.sparke.special.modules.v1.report.bean.AbilityBean;
import cn.sparke.special.modules.v1.report.bean.QuestionReportBean;
import cn.sparke.special.modules.v1.report.bean.ScoreBean;
import cn.sparke.special.modules.v1.report.bean.SpecialSuggestionBean;
import cn.sparke.special.modules.v1.report.mapper.QuestionReportMapper;
import cn.sparke.special.modules.v1.report.service.QuestionReportService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */
@RestController
@RequestMapping("/${version}/reports")
public class QuestionReportController {
    @Autowired
    QuestionReportService reportService;
    @Autowired
    QuestionReportMapper reportMapper;
    @Autowired
    QuestionRecordMapper recordMapper;

    @GetMapping("/records")
    @LoginAnnot
    public ResponseEntity findRecordList(@RequestParam("start") int start) {
        AuthEntity entity = ContextUtils.getCurAuth();
        QuestionRecordBean recordBean = new QuestionRecordBean();
        recordBean.setStart(start);
        recordBean.setRows(PageConstants.PAGE_NUM);
        recordBean.setUserId(entity.getUserId());
        recordBean.setSectionCode(entity.getSectionCode());
        Page<QuestionRecordBean> recordBeans = recordMapper.findRecordList(recordBean);
        return ResponseEntity.ok(PagerUtils.getPager(recordBeans));
    }

    @GetMapping("/ability")
    public ResponseEntity getAbility() {
        AuthEntity entity = ContextUtils.getCurAuth();
        String userId = entity.getUserId();
        if (StringUtils.isEmpty(userId)) {
            return ResponseEntity.ok(reportService.getAbility(entity.getUserId(), entity.getSectionCode()));
        }
        AbilityBean cacheReport = CacheFacade.getObject("user_ability_" + entity.getUserId() + "_" + entity.getSectionCode());
        if (cacheReport != null) {
            return ResponseEntity.ok(cacheReport);
        }
        AbilityBean reportBean = reportService.getAbility(entity.getUserId(), entity.getSectionCode());
        if (reportBean != null) {
            CacheFacade.set("user_ability_" + entity.getUserId() + "_" + entity.getSectionCode(), reportBean, 60 * 30);
        }
        return ResponseEntity.ok(reportBean);
    }

    @GetMapping("/wrong_collection_record_num")
    public ResponseEntity getWrongCollectionRecordNum() {
        AuthEntity entity = ContextUtils.getCurAuth();
        AbilityBean reportBean = reportService.getWrongCollectionRecordNum(entity.getUserId(), entity.getSectionCode());
        return ResponseEntity.ok(reportBean);
    }

    @PostMapping("/ability/detail")
    @LoginAnnot
    public ResponseEntity getAbilityDetail(@RequestBody List<ScoreBean> scoreBeanList) {
        AbilityBean reportBean = new AbilityBean();
        int sectionCode = ContextUtils.getCurAuth().getSectionCode();
        List<SpecialSuggestionBean> suggestionBeans = reportService.getAbilityDetail(scoreBeanList, sectionCode);
        return ResponseEntity.ok(suggestionBeans);
    }

    /**
     * 诊断报告
     *
     * @param contentId
     * @return
     */
    @GetMapping("/{contentId}")
    public ResponseEntity getReport(@PathVariable("contentId") String contentId, @RequestParam("type") int type) {
        if (type != 1 && type != 2) {
            return new ResponseErrorEntity(StatusCode.VALIDATION_FAILED, HttpStatus.BAD_REQUEST);
        }
        AuthEntity entity = ContextUtils.getCurAuth();
        if (type == 2 && (entity.getUserId() == null || entity.getUserId().equals(""))) {
            return new ResponseErrorEntity(HttpStatus.UNAUTHORIZED);
        }
        QuestionReportBean reportBean = reportMapper.getReport(contentId, type, entity.getUserId(), entity.getSectionCode());
        return ResponseEntity.ok(reportBean);
    }
}
