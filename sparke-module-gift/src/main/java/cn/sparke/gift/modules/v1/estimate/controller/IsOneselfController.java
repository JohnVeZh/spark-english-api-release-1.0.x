package cn.sparke.gift.modules.v1.estimate.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.gift.modules.v1.estimate.service.SubjectiveRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/8/21 10:33
 */
@LoginAnnot
@Controller
@RequestMapping("${version}/estimate")
public class IsOneselfController {
    @Autowired
    private SubjectiveRuleService subjectiveRuleService;

    @RequestMapping(value = "/{paperId}/is_oneself", method = RequestMethod.GET)
    private ResponseEntity isOneself(@PathVariable String paperId) {
        return subjectiveRuleService.isOneself(paperId);
    }
}
