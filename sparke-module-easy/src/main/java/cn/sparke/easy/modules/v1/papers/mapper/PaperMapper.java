package cn.sparke.easy.modules.v1.papers.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.easy.modules.v1.papers.bean.PaperBean;
import cn.sparke.easy.modules.v1.papers.bean.PaperStructureBean;

import java.util.List;
import java.util.Map;

/**
 * Created by wanghaiguang on 2017/7/10.
 */
public interface PaperMapper extends BaseMapper<PaperBean> {

    //根据试卷目录Id(paperCatalogId),获取简系列试卷列表
    List<PaperBean> queryPapersByCatalogId(Map<String,Object> map);


    //根据试卷Id(paperId),获取试卷模型
    List<PaperStructureBean> getPaperById(String paperId);

}
