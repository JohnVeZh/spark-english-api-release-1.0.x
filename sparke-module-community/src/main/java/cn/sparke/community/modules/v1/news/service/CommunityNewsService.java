package cn.sparke.community.modules.v1.news.service;

import cn.sparke.community.modules.v1.news.bean.CommunityNewsBean;
import cn.sparke.community.modules.v1.news.mapper.CommunityNewsMapper;
import cn.sparke.community.modules.v1.utils.MyPageUtil;
import cn.sparke.core.common.constants.PageConstants;
import cn.sparke.core.common.mybatis.bean.PagerBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by yangye on 2017/7/11.
 */
@Service
public class CommunityNewsService {
    @Autowired
    private CommunityNewsMapper newsMapper;


    public PagerBean<CommunityNewsBean > findList(Integer start) {
        //填充分页参数
        PageHelper.offsetPage(start, PageConstants.PAGE_NUM);
        List<CommunityNewsBean > newsList = newsMapper.findList();
        //进行分页
        return MyPageUtil.getPagerBean(new PageInfo<>(newsList));
    }

    public CommunityNewsBean getById(String newsId, String userId) {
        newsMapper.addReadNum(newsId); // 资讯阅读数+1
        return newsMapper.getById(newsId, userId);
    }

    public PagerBean<CommunityNewsBean > getRecommendList(Integer start, Integer rows) {
        //填充分页参数
        PageHelper.offsetPage(start,rows);
        List<CommunityNewsBean > newsList = newsMapper.getRecommendList();
        //进行分页
        return MyPageUtil.getPagerBean(new PageInfo<>(newsList));
    }


}
