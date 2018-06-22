package cn.sparke.easy.modules.v1.captionlistenings.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.easy.modules.v1.captionlistenings.bean.CaptionListeningBean;

import java.util.List;

/**
 * Created by wanghaiguang on 2017/7/11.
 */
public interface CaptionListeningMapper extends BaseMapper<CaptionListeningBean> {
    List<CaptionListeningBean>  queryList();
}
