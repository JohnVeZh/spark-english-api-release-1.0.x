package cn.sparke.easy.modules.v1.videos.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.easy.modules.v1.videos.bean.VideoBean;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghaiguang on 2017/7/11.
 */
public interface VedioMapper extends BaseMapper<VideoBean> {
    //查询简视频列表
    List<VideoBean>  queryList(Map<String,Object> map);
}
