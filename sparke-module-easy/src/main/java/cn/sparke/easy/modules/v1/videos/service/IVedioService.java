package cn.sparke.easy.modules.v1.videos.service;

import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.easy.modules.v1.videos.bean.VideoBean;

/**
 * Created by wanghaiguang on 2017/7/11.
 */
public interface IVedioService {

    //查询简视频列表
    PagerBean<VideoBean> queryList(Integer start,String catalogId);
}
