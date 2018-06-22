package cn.sparke.easy.modules.v1.studymaterialswritings.service;

import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.easy.modules.v1.studymaterialswritings.bean.StudyMaterialsWritingBean;

import java.util.List;

/**
 * Created by wanghaiguang on 2017/7/11.
 */
public interface IStudyMaterialsWritingService {

    //根据类型获取相应列表(type:1.写作 2.翻译 3.阅读)
    PagerBean<StudyMaterialsWritingBean> queryListByType(Integer start, Integer type);

    //根据ID获取内容详情
    StudyMaterialsWritingBean getById(String id);

}
