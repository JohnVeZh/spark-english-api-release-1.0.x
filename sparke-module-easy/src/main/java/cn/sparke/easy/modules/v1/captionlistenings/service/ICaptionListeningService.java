package cn.sparke.easy.modules.v1.captionlistenings.service;

import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.easy.modules.v1.captionlistenings.bean.CaptionListeningBean;

/**
 * Created by wanghaiguang on 2017/7/11.
 */
public interface ICaptionListeningService {

    //查询字幕听力列表
    PagerBean<CaptionListeningBean> queryList(Integer start);
}
