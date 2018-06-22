package cn.sparke.easy.modules.v1.videos.service.impl;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.constants.PageConstants;
import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.easy.modules.v1.common.MapUtil;
import cn.sparke.easy.modules.v1.common.MyPageUtil;
import cn.sparke.easy.modules.v1.videos.bean.VideoBean;
import cn.sparke.easy.modules.v1.videos.mapper.VedioMapper;
import cn.sparke.easy.modules.v1.videos.service.IVedioService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanghaiguang on 2017/7/11.
 */
@Service
public class VedioServiceImpl implements IVedioService {

    @Autowired
    private VedioMapper vedioMapper;

    @Override
    public PagerBean<VideoBean> queryList(Integer start,String catalogId) {
        //填充分页参数
        PageHelper.offsetPage(start, PageConstants.PAGE_NUM);
        //获取登录权限实体
        AuthEntity entity = ContextUtils.getCurAuth();
        //将学段和分类参数放入Map中
        Map<String, Object> map = MapUtil.setMapValues("catalogId", catalogId, "sectionCode", entity.getSectionCode());
        List<VideoBean> beans = vedioMapper.queryList(map);
        //分页
        return MyPageUtil.getPagerBean(new PageInfo<VideoBean>(beans));
    }
}
