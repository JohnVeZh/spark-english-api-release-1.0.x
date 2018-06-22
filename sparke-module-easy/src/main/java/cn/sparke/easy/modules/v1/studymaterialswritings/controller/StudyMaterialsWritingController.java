package cn.sparke.easy.modules.v1.studymaterialswritings.controller;

import cn.sparke.core.common.mybatis.utils.PagerUtils;
import cn.sparke.easy.modules.v1.studymaterialswritings.bean.StudyMaterialsWritingBean;
import cn.sparke.easy.modules.v1.studymaterialswritings.mapper.StudyMaterialsWritingMapper;
import cn.sparke.easy.modules.v1.studymaterialswritings.service.IStudyMaterialsWritingService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wanghaiguang on 2017/7/10.
 * 写作翻译阅读controller
 */
@RestController
@RequestMapping("/${version}")
public class StudyMaterialsWritingController {

    @Autowired
    private IStudyMaterialsWritingService studyMaterialsWritingService;

    /**
     * 根据类型获取相应列表(type:1.写作 2.翻译 3.阅读)
     * @param start
     * @param type
     * @return
     */
    @GetMapping ("/study_materials_writings")
    public ResponseEntity findList(@RequestParam Integer start, @RequestParam Integer type) {
        return ResponseEntity.ok(studyMaterialsWritingService.queryListByType(start,type));
    }

    /**
     * 根据ID获取相应内容详情
     * @param writingId
     * @return
     */
    @GetMapping("/study_materials_writings/{writingId}")
    public ResponseEntity getById(@PathVariable String writingId){
        return ResponseEntity.ok(studyMaterialsWritingService.getById(writingId));
    }

}
