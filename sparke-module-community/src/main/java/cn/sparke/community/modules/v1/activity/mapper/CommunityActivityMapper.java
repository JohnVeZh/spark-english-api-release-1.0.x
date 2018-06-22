package cn.sparke.community.modules.v1.activity.mapper;

import cn.sparke.community.modules.v1.activity.bean.CommunityActivityBean;
import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.core.common.mybatis.bean.PagerBean;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yangye on 2017/7/10.
 */
public interface CommunityActivityMapper extends BaseMapper<CommunityActivityBean> {

    List<CommunityActivityBean> findList(@Param("userId") String userId);

    CommunityActivityBean getById(@Param("activityId") String activityId, @Param("userId") String userId);

    int addReadNum(@Param("activityId") String activityId);
}
