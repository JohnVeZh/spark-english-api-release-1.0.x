package cn.sparke.gift.modules.v1.activationCode.service;

import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.utils.Utils;
import cn.sparke.gift.modules.v1.activationCode.bean.ActivationCodeBean;
import cn.sparke.gift.modules.v1.activationCode.bean.SubjectiveSubmitRecordBean;
import cn.sparke.gift.modules.v1.activationCode.bean.UserNetworkCourseBean;
import cn.sparke.gift.modules.v1.activationCode.constants.GainTypeConstants;
import cn.sparke.gift.modules.v1.activationCode.mapper.ActivationCodeMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yangye on 2017/7/12.
 */
@Service
public class ActivationCodeService {
    @Autowired
    private ActivationCodeMapper activationCodeMapper;

    public ResponseEntity isActivated(String userId, int sectionCode) {
        return ResponseEntity.ok(new HashMap<String, Object>() {{ put("giftStatus", activationCodeMapper.isActivated(userId, sectionCode)); }});
    }

    public ResponseEntity description(ActivationCodeBean codeBean) {
        /*ActivationCodeBean codeBeanDetails = activationCodeMapper.details(codeBean);
        codeBeanDetails.setDescription(DictUtils.getDictDescription(String.valueOf(codeBeanDetails.getSectionCode()), DictTypeConstants.GIFT_ACTIVATION_CODE_DESC, ""));
        return ResponseEntity.ok(codeBeanDetails);*/
        return ResponseEntity.ok(activationCodeMapper.description(codeBean));
    }

    public ResponseEntity activate(ActivationCodeBean codeBean) {
        ActivationCodeBean codeBeanDetails = activationCodeMapper.details(codeBean);
        if (codeBeanDetails == null) { // 激活码不存在
            return new ResponseErrorEntity(StatusCode.ACTIVATION_CODE_NOT_EXIST, HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isNotBlank(codeBeanDetails.getActivateUserId())) { // 激活码已被激活
            return new ResponseErrorEntity(StatusCode.ACTIVATION_CODE_BE_ACTIVATED, HttpStatus.BAD_REQUEST);
        }
        // todo 激活码过期需求确定
        /*if (activationCodeMapper.isExpired(codeBean) > 0) { // 激活码已过期
            return new ResponseErrorEntity(StatusCode.ACTIVATION_CODE_EXPIRED, HttpStatus.BAD_REQUEST);
        }*/
        // 用户已激学段列表
        List<Integer> activatedSectionCodeList = activationCodeMapper.findActivatedSectionCodeByUserId(codeBean);
        if (!activatedSectionCodeList.contains(codeBeanDetails.getSectionCode())) { // 当前激活码学段，不在已激活学段列表
            // 对应学段，已激活用户数
            int activatedUserCount = activationCodeMapper.queryActivatedUserCount(codeBeanDetails.getSectionCode());
            codeBean.setSort(activatedUserCount + 1); // 设置激活次序
            SubjectiveSubmitRecordBean subjectiveSubmitRecordBean = this.fillSubjectiveSubmitRecordBean(codeBeanDetails, codeBean.getActivateUserId(), codeBean.getSort());
            activationCodeMapper.activate(codeBean); // 激活大礼包
            activationCodeMapper.insertOrUpdateUserNetworkCourse(this.fillUserNetworkCourseBean(codeBeanDetails, codeBean.getActivateUserId())); // 插入用户网课关系记录
            activationCodeMapper.insertUserGiftPlanNetworkCourse(codeBeanDetails.getSectionCode(), codeBean.getActivateUserId(), GainTypeConstants.GAIN_BY_GIFT); // 插入学习方案用户网课关系记录
            activationCodeMapper.insertSubjectiveSubmitRecord(subjectiveSubmitRecordBean); // 插入阅卷记录
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseErrorEntity(StatusCode.ACTIVATION_CODE_DUPLICATED, HttpStatus.BAD_REQUEST);
    }

    public UserNetworkCourseBean fillUserNetworkCourseBean(ActivationCodeBean codeBeanDetails, String userId) {
        UserNetworkCourseBean userNetworkCourseBean = new UserNetworkCourseBean();
        userNetworkCourseBean.setId(Utils.uuid());
        userNetworkCourseBean.setUserId(userId);
        userNetworkCourseBean.setNetworkCourseId((codeBeanDetails.getCourseIdList() != null && codeBeanDetails.getCourseIdList().size() > 0) ? codeBeanDetails.getCourseIdList().get(0) : null);
        userNetworkCourseBean.setType(GainTypeConstants.GAIN_BY_GIFT);
        return userNetworkCourseBean;
    }

    public SubjectiveSubmitRecordBean fillSubjectiveSubmitRecordBean(ActivationCodeBean codeBeanDetails, String userId, int activatedUserCount) {
        SubjectiveSubmitRecordBean subjectiveSubmitRecordBean = new SubjectiveSubmitRecordBean();
        subjectiveSubmitRecordBean.setId(Utils.uuid());
        subjectiveSubmitRecordBean.setUserId(userId);
        subjectiveSubmitRecordBean.setSectionCode(codeBeanDetails.getSectionCode());
        subjectiveSubmitRecordBean.setCodeId(codeBeanDetails.getId());
        subjectiveSubmitRecordBean.setPreTranslateTotal(activatedUserCount > 1000 ? 0 : 1);
        subjectiveSubmitRecordBean.setPreWriteTotal(activatedUserCount > 1000 ? 0 : 1);
        subjectiveSubmitRecordBean.setMidTranslateTotal(activatedUserCount > 1000 ? 0 : 1);
        subjectiveSubmitRecordBean.setMidWriteTotal(activatedUserCount > 1000 ? 0 : 1);
        subjectiveSubmitRecordBean.setPostTranslateTotal(activatedUserCount > 1000 ? 0 : 1);
        subjectiveSubmitRecordBean.setPostWriteTotal(activatedUserCount > 1000 ? 0 : 1);
        return subjectiveSubmitRecordBean;
    }


}
