package cn.sparke.gift.modules.v1.studyScheme.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.gift.modules.v1.studyScheme.service.StudySchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by yangye on 2017-08-21.
 */
@RestController
@RequestMapping("/${version}/study_scheme")
@LoginAnnot
public class StudySchemeController {

    @Autowired
    private StudySchemeService studySchemeService;

    /**
     * 用户学习方案
     */
    @GetMapping("/details")
    public ResponseEntity details() {
//        return studySchemeService.details("8a987df75c169470015c47d290b31f26", ContextUtils.getCurAuth().getSectionCode());
        return studySchemeService.details(ContextUtils.getCurAuth().getUserId(), ContextUtils.getCurAuth().getSectionCode());
    }

    /**
     * 学习方案列表
     *
     * @return
     */
    @GetMapping
    public ResponseEntity list() {
        return ResponseEntity.ok(studySchemeService.list());
    }

    /**
     * 学习方案详情
     *
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity info(@PathVariable String id) {
        return ResponseEntity.ok(studySchemeService.info(id));
    }

    /**
     * 提交用户方案
     * @param parameter
     * @return
     */
    @PostMapping
    public ResponseEntity submitScheme(@RequestBody Map<String,String>  parameter ){
        if(parameter.get("id")==null){
            return  new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        studySchemeService.submitScheme(parameter.get("id"));
        return new ResponseEntity(HttpStatus.CREATED);
    }
}