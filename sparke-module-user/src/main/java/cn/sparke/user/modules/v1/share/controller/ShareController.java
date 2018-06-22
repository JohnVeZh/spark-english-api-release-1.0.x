package cn.sparke.user.modules.v1.share.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.user.modules.v1.share.api.ShareApi;
import cn.sparke.user.modules.v1.share.bean.ResultPage;
import cn.sparke.user.modules.v1.share.bean.ShareBean;
import cn.sparke.user.modules.v1.share.bean.ShareContent;
import cn.sparke.user.modules.v1.share.constants.ShareConstants;
import cn.sparke.user.modules.v1.share.constants.ShareProperties;
import cn.sparke.user.modules.v1.share.service.ShareService;
import cn.sparke.user.modules.v1.users.entity.UserEntity;
import cn.sparke.user.modules.v1.users.mapper.UserMapper;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * Created by zhangbowen on 2017/7/11.
 */
@RestController
@RequestMapping("/${version}/share")
public class ShareController {
    private static String PREFIX;
    @Autowired
    private ShareProperties shareProperties;
    @Autowired
    private ShareService shareService;
    @Autowired
    private UserMapper userMapper;

    @PostConstruct
    private void init() {
        PREFIX = shareProperties.shareBaseUrl + "/v1/";
    }

    /**
     * 分享获取用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public UserEntity shareUserInfo(@PathVariable String id) {
        return userMapper.getSmallUser(id);
    }

    /**
     * 分享内容获取
     *
     * @return
     */
    @GetMapping("/{id}")
    public ShareBean shareInfo(@PathVariable String id) {
        return shareService.getById(id);
    }

    /**
     * 分享页面地址获取
     *
     * @return
     */
    @PostMapping
    @LoginAnnot
    public ResultPage share(@RequestBody @Validated ShareContent shareContent) {
        String userId = ContextUtils.getCurAuth().getUserId();
        String contentId = shareContent.getContentId();
        ShareBean shareBean;
        switch (shareContent.getType()) {
            case ShareConstants.Type.EXERCISE_REPORT://1.专项练习报告
                return new ResultPage(PREFIX + "exerciseReport.html?contentId=" + contentId + "&userId=" + userId);
            case ShareConstants.Type.SCORE_TOOL://2.估分神器
                shareBean = shareService.share(shareContent);
                return new ResultPage(PREFIX + "scoreTool.html?contentId=" + shareBean.getId() + "&userId=" + userId);
            case ShareConstants.Type.NETWORK://3.网课
                return new ResultPage(shareProperties.mUrl + "/#/videoInfo/" + contentId);
            case ShareConstants.Type.NEWS://4.资讯
                return new ResultPage(PREFIX + "news.html?contentId=" + contentId + "&userId=" + userId);
            case ShareConstants.Type.ACTIVITY:// 5.活动
                return new ResultPage(PREFIX + "activity.html?contentId=" + contentId + "&userId=" + userId);
            case ShareConstants.Type.BOOK://  6.图书
                return new ResultPage(PREFIX + "book.html?contentId=" + contentId + "&userId=" + userId);
            case ShareConstants.Type.ABILITY_REPORT://7.专项能力报告
                shareBean = shareService.share(shareContent);
                return new ResultPage(PREFIX + "abilityReport.html?contentId=" + shareBean.getId() + "&userId=" + userId);
            case ShareConstants.Type.EXAM_REPORT://8.全真考场诊断报告
                return new ResultPage(PREFIX + "examReport.html?contentId=" + contentId + "&userId=" + userId);
            case ShareConstants.Type.EXERCISE_ERROR_WORD://9.专项消灭错词
                return new ResultPage(PREFIX + "errorWords.html?contentId=" + contentId + "&userId=" + userId + "&wordNum=" + shareContent.getWordNum());
            case ShareConstants.Type.EXERCISE_REVIEW_WORD://10.专项复习单词
                return new ResultPage(PREFIX + "reviewWords.html?contentId=" + contentId + "&userId=" + userId + "&graspRate=" + shareContent.getGraspRate() + "&reviewNum=" + shareContent.getReviewNum() + "&graspNum=" + shareContent.getGraspNum());
            case ShareConstants.Type.EXERCISE_STUDY_WORD://11.专项学习单词
                return new ResultPage(PREFIX + "studyWords.html?contentId=" + contentId + "&userId=" + userId + "&studyNum=" + shareContent.getStudyNum() + "&historyNum=" + shareContent.getHistoryNum());
            case ShareConstants.Type.SUPPORT_REPORT://12.配套专区用户成绩报告
                shareBean = shareService.share(shareContent);
                return new ResultPage(PREFIX + "supportReport.html?contentId=" + shareBean.getId() + "&userId=" + userId);
            case ShareConstants.Type.APP_DOWNLOAD://12.配套专区用户成绩报告
                return new ResultPage(shareProperties.mUrl + "/download.html");
        }
        return null;
    }
}
