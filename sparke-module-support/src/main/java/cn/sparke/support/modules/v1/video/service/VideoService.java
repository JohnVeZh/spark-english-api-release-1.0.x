package cn.sparke.support.modules.v1.video.service;

import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.support.modules.v1.video.bean.vo.TeacherVideos;
import cn.sparke.support.modules.v1.video.mapper.IVideoMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 16:01
 */
@Service
public class VideoService {

    @Resource
    private IVideoMapper videoMapper;
    //查找网课中的名师视频
    public Page<TeacherVideos> getTearcherVideoList(Integer start, Integer rows) {
        int sectionCode = ContextUtils.getCurAuth().getSectionCode();
        //填充分页参数
        PageHelper.offsetPage(start, rows);
        return videoMapper.findFamousTeacherBySectionCode(sectionCode);
    }
}
