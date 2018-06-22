package cn.sparke.base.modules.v1.fragment.controller;

import cn.sparke.base.modules.v1.fragment.bean.*;
import cn.sparke.base.modules.v1.fragment.constants.FragmentConstants;
import cn.sparke.base.modules.v1.fragment.mapper.SectionMapper;
import cn.sparke.base.modules.v1.fragment.mapper.StartPageMapper;
import cn.sparke.base.modules.v1.fragment.mapper.VersionMapper;
import cn.sparke.base.modules.v1.fragment.service.FeedbackService;
import cn.sparke.base.modules.v1.fragment.service.QuestionErrorService;
import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.core.modules.dict.utils.DictUtils;
import cn.sparke.core.modules.token.constants.TokenConstants;
import cn.sparke.core.modules.token.service.TokenService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by zhangbowen on 2016/1/12.
 * 版本
 */
@RestController
@RequestMapping("/${version}/fragment")
public class FragmentController {
    @Autowired
    private VersionMapper versionMapper;
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private SectionMapper sectionMapper;
    @Autowired
    private QuestionErrorService questionErrorService;
    @Autowired
    private StartPageMapper startPageMapper;

    /**
     * 获取最新版本
     *
     * @return
     */
    @GetMapping("/version")
    public ResponseEntity get() {
        int terminal = ContextUtils.getCurAuth().getTerminal();
        VersionBean versionBean = new VersionBean();
        versionBean.setType(terminal);
        VersionBean version = versionMapper.get(versionBean);
        return ResponseEntity.ok(version);
    }


    /**
     * 启动
     *
     * @return
     */
    @GetMapping("/start")
    public ResponseEntity start() {
        StartBean startBean = new StartBean();
        StartImg startImg = startPageMapper.get(null);
        if (startImg == null) {
            startImg = new StartImg();
        }
        startBean.setStartImg(startImg);
        if (TokenConstants.TERMINAL.IOS == ContextUtils.getCurAuth().getTerminal()) {
            startBean.setPassVerify(versionMapper.getPassVerify(FragmentConstants.VERSION.TYPE_IOS, ContextUtils.getCurAuth().getVersionCode()));
        }
        startBean.setServiceMobile(DictUtils.getDictValue(FragmentConstants.Dict.SERVICE_MOBILE, FragmentConstants.Dict.SERVICE_MOBILE, ""));
        return ResponseEntity.ok(startBean);
    }

    /**
     * 意见反馈
     *
     * @param feedbackBean
     * @return
     */
    @PostMapping("/suggest")
    @LoginAnnot
    public ResponseEntity suggest(@RequestBody @Validated FeedbackBean feedbackBean) {
        feedbackService.feedback(feedbackBean);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 学段列表
     *
     * @return
     */
    @GetMapping("/sections")
    public ResponseEntity sections() {
        AuthEntity authEntity = ContextUtils.getCurAuth();
        List<SectionBean> sectionList = sectionMapper.findList(null);
        if (authEntity == null || authEntity.getTerminal() == 0) {
            return ResponseEntity.ok(sectionList);
        }
        switch (authEntity.getTerminal()) {
            case TokenConstants.TERMINAL.ANDROID:
            case TokenConstants.TERMINAL.IOS:
                return ResponseEntity.ok(sectionList.stream().filter(sectionBean -> sectionBean.getCode() <= FragmentConstants.SECTION.CODE_YAN).collect(Collectors.toList()));
            case TokenConstants.TERMINAL.PC:
            case TokenConstants.TERMINAL.M:
            case TokenConstants.TERMINAL.ZHI_MI:
                return ResponseEntity.ok(sectionList);
        }
        return ResponseEntity.ok(sectionList);
    }

    /**
     * 题目报错
     *
     * @return
     */
    @PostMapping("/error/{questionId}")
    @LoginAnnot
    public ResponseEntity questionError(@RequestBody @Validated QuestionErrorBean questionErrorBean, @PathVariable String questionId) {
        questionErrorBean.setQuestionId(questionId);
        questionErrorBean.setSectionCode(ContextUtils.getCurAuth().getSectionCode());
        questionErrorService.questionError(questionErrorBean);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
