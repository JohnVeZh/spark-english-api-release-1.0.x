package cn.sparke.community.modules.v1.news.mapper;

import cn.sparke.community.modules.v1.activity.bean.CommunityActivityBean;
import cn.sparke.community.modules.v1.news.bean.CommunityNewsBean;
import cn.sparke.core.common.mybatis.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yangye on 2017/7/11.
 */
public interface CommunityNewsMapper extends BaseMapper<CommunityActivityBean> {

    List<CommunityNewsBean > findList();

    CommunityNewsBean getById(@Param("newsId") String newsId, @Param("userId") String userId);

    int addReadNum(@Param("newsId") String newsId);

    List<CommunityNewsBean> getRecommendList();
}
