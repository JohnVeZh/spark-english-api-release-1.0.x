package cn.sparke.easy.modules.v1.studymaterialswritings.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.easy.modules.v1.studymaterialswritings.bean.StudyMaterialsWritingBean;

import java.util.List;

/**
 * Created by wanghaiguang on 2017/7/10.
 */
public interface StudyMaterialsWritingMapper extends BaseMapper<StudyMaterialsWritingBean> {

    //根据类型获取相应列表(type:1.写作 2.翻译 3.阅读)
    List<StudyMaterialsWritingBean> queryListByType(Integer type);

}
