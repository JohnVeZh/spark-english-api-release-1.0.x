package cn.sparke.easy.modules.v1.studymaterialswritings.service.impl;

import cn.sparke.core.common.constants.PageConstants;
import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.easy.modules.v1.common.MyPageUtil;
import cn.sparke.easy.modules.v1.studymaterialswritings.bean.StudyMaterialsWritingBean;
import cn.sparke.easy.modules.v1.studymaterialswritings.mapper.StudyMaterialsWritingMapper;
import cn.sparke.easy.modules.v1.studymaterialswritings.service.IStudyMaterialsWritingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wanghaiguang on 2017/7/11.
 */
@Service
public class StudyMaterialsWritingServiceImpl implements IStudyMaterialsWritingService {

    @Autowired
    private StudyMaterialsWritingMapper studyMaterialsWritingMapper;

    @Override
    public PagerBean<StudyMaterialsWritingBean> queryListByType(Integer start, Integer type) {
        //填充分页参数
        PageHelper.offsetPage(start, PageConstants.PAGE_NUM);
        List<StudyMaterialsWritingBean> beans = studyMaterialsWritingMapper.queryListByType(type);
        //进行分页
        return MyPageUtil.getPagerBean(new PageInfo<StudyMaterialsWritingBean>(beans));
    }


    @Override
    public StudyMaterialsWritingBean getById(String id) {
        return studyMaterialsWritingMapper.getById(id);
    }


}
