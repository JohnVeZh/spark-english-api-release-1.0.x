package cn.sparke.support.modules.v1.writing.service;

import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.support.modules.v1.writing.bean.vo.WritingTranslationVo;
import cn.sparke.support.modules.v1.writing.mapper.WritingTranslationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 18:51
 */
@Service
public class WritingTranslationService {
    @Resource
    private WritingTranslationMapper writingTranslationMapper;

    public List findWritingTranslation() {
        int sectionCode = ContextUtils.getCurAuth().getSectionCode();
        return writingTranslationMapper.findWritingTranslation(sectionCode);
    }
}
