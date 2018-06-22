package cn.sparke.community.modules.v1.activity.service;

import cn.sparke.community.modules.v1.activity.bean.CommunityActivityBean;
import cn.sparke.community.modules.v1.activity.mapper.CommunityActivityMapper;
import cn.sparke.community.modules.v1.utils.MyPageUtil;
import cn.sparke.core.common.constants.PageConstants;
import cn.sparke.core.common.mybatis.bean.PagerBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by yangye on 2017/7/10.
 */
@Service
public class CommunityActivityService {
    @Autowired
    private CommunityActivityMapper activityMapper;


    /**
     * 活动列表
     * @param userId
     * @return
     */
    public PagerBean<CommunityActivityBean> findList(Integer start, String userId) {
        //填充分页参数
        PageHelper.offsetPage(start, PageConstants.PAGE_NUM);
        List<CommunityActivityBean> activityList = activityMapper.findList(userId);
        //进行分页
        return MyPageUtil.getPagerBean(new PageInfo<>(activityList));
    }

    public CommunityActivityBean getById(String activityId, String userId) {
        activityMapper.addReadNum(activityId); // 阅读数+1
        return activityMapper.getById(activityId, userId);
    }


}
