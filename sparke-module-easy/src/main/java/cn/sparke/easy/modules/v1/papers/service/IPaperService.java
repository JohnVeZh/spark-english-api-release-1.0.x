package cn.sparke.easy.modules.v1.papers.service;

import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.easy.modules.v1.papers.bean.PaperBean;
import cn.sparke.easy.modules.v1.papers.bean.PaperStructureBean;

import java.util.List;

/**
 * Created by wanghaiguang on 2017/7/11.
 */
public interface IPaperService {

    //根据试卷目录Id(paperCatalogId),获取简系列试卷列表
    PagerBean<PaperBean> queryPapersByCatalogId(Integer start, String catalogId);


    //根据试卷Id(paperId),获取试卷模型
    List<PaperStructureBean> getPaperById(String paperId);

}
