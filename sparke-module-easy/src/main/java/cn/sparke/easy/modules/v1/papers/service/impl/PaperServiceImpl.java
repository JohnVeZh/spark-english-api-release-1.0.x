package cn.sparke.easy.modules.v1.papers.service.impl;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.constants.PageConstants;
import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.easy.modules.v1.common.MapUtil;
import cn.sparke.easy.modules.v1.common.MyPageUtil;
import cn.sparke.easy.modules.v1.papers.bean.PaperBean;
import cn.sparke.easy.modules.v1.papers.bean.PaperStructureBean;
import cn.sparke.easy.modules.v1.papers.mapper.PaperMapper;
import cn.sparke.easy.modules.v1.papers.service.IPaperService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghaiguang on 2017/7/11.
 */
@Service
public class PaperServiceImpl implements IPaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Override
    public PagerBean<PaperBean> queryPapersByCatalogId(Integer start,String catalogId) {
        //填充分页参数
        PageHelper.offsetPage(start, PageConstants.PAGE_NUM);
        AuthEntity entity = ContextUtils.getCurAuth();
        Map<String, Object> map = MapUtil.setMapValues("catalogId", catalogId, "sectionCode", entity.getSectionCode());
        List<PaperBean> beans = paperMapper.queryPapersByCatalogId(map);
        //进行分页
        return MyPageUtil.getPagerBean(new PageInfo<PaperBean>(beans));
    }


    //根据试卷Id(paperId),获取试卷模型
    @Override
    public List<PaperStructureBean> getPaperById(String paperId) {
        return paperMapper.getPaperById(paperId);
    }


}
