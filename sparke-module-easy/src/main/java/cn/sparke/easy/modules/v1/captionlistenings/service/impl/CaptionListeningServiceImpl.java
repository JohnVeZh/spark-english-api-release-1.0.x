package cn.sparke.easy.modules.v1.captionlistenings.service.impl;

import cn.sparke.core.common.constants.PageConstants;
import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.easy.modules.v1.captionlistenings.bean.CaptionListeningBean;
import cn.sparke.easy.modules.v1.captionlistenings.mapper.CaptionListeningMapper;
import cn.sparke.easy.modules.v1.captionlistenings.service.ICaptionListeningService;
import cn.sparke.easy.modules.v1.common.MyPageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wanghaiguang on 2017/7/11.
 */
@Service
public class CaptionListeningServiceImpl implements ICaptionListeningService {

    @Autowired
    private CaptionListeningMapper captionListeningMapper;

    @Override
    public PagerBean<CaptionListeningBean> queryList(Integer start) {
        //填充分页参数
        PageHelper.offsetPage(start, PageConstants.PAGE_NUM);
        List<CaptionListeningBean> beans = captionListeningMapper.queryList();
        //分页
        return MyPageUtil.getPagerBean(new PageInfo<CaptionListeningBean>(beans));
    }
}
