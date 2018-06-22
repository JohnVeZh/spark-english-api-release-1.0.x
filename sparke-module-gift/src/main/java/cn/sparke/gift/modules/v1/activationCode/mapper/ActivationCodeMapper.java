package cn.sparke.gift.modules.v1.activationCode.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.gift.modules.v1.activationCode.bean.ActivationCodeBean;
import cn.sparke.gift.modules.v1.activationCode.bean.SubjectiveSubmitRecordBean;
import cn.sparke.gift.modules.v1.activationCode.bean.UserNetworkCourseBean;
import cn.sparke.gift.modules.v1.recommendCourse.bean.RecommendCourseBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yangye on 2017/7/12.
 */
public interface ActivationCodeMapper extends BaseMapper<ActivationCodeBean> {

    int isActivated(@Param("userId") String userId, @Param("sectionCode") int sectionCode);

    ActivationCodeBean details(ActivationCodeBean codeBean);

    ActivationCodeBean description(ActivationCodeBean codeBean);

    /*
     * 是否已过期，1: 已过期, 0: 未过期
     */
    int isExpired(ActivationCodeBean codeBean);

    /*
     * 查询用户已激活的激活码列表
     */
    List<Integer> findActivatedSectionCodeByUserId(ActivationCodeBean codeBean);

    /*
     * 激活码激活
     */
    int activate(ActivationCodeBean codeBean);

    /*
     * 获取四级、六级，前1000名已激活用户数（根据code获取关联sectionCode）
     */
    int queryActivatedUserCount(@Param("sectionCode") int sectionCode);

    /*
     * 创建或更新，用户网课关系表
     */
    int insertOrUpdateUserNetworkCourse(UserNetworkCourseBean userNetworkCourseBean);

    /*
     * 插入用户学习方案推荐网课关系记录
     */
    int insertUserGiftPlanNetworkCourse(@Param("sectionCode") int sectionCode, @Param("userId") String userId, @Param("type") int type);

    /*
     * 创建或更新，主观题后台阅卷提交次数
     */
    int insertSubjectiveSubmitRecord(SubjectiveSubmitRecordBean subjectiveSubmitRecordBean);


}