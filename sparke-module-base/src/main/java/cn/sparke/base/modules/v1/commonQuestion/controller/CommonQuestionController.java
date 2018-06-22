package cn.sparke.base.modules.v1.commonQuestion.controller;

import cn.sparke.base.modules.v1.commonQuestion.mapper.CommonQuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;

/**
 * Created by zhangbowen on 2017/7/10.
 */
@RestController
@RequestMapping("/${version}/common_questions")
public class CommonQuestionController {
    @Autowired
    private CommonQuestionMapper commonQuestionMapper;

    /**
     * 列表
     * @return
     */
    @GetMapping
    public ResponseEntity list() {
        return ResponseEntity.ok(commonQuestionMapper.findList(null));
    }

    /**
     * 详情
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity info(@PathVariable String id) {
        return ResponseEntity.ok(commonQuestionMapper.getById(id));
    }
}
