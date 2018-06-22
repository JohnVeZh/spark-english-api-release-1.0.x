package cn.sparke.support.modules.v1.caption.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.support.modules.v1.caption.bean.vo.PaperDetails;
import cn.sparke.support.modules.v1.caption.bean.vo.PaperUserInfo;
import cn.sparke.support.modules.v1.caption.service.PaperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 配套专区
 *
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 21:22
 */
@LoginAnnot
@RestController
@RequestMapping("${version}/caption_hearing")
public class PaperController {

    @Resource
    private PaperService paperService;

    //获取试卷目录列表
    @GetMapping("/catalog/papers")
    public ResponseEntity getCatalog() {
        return ResponseEntity.ok(paperService.findPagerCatalog());
    }


    //    用户选择试卷

    @PutMapping("/papers/{groupId}")
    public ResponseEntity putPapers(@PathVariable String groupId) {
        return paperService.addPaper(groupId);
    }

    //    用户选择的试卷
    @GetMapping("/papers/user")
    public ResponseEntity getUserPapers() {
        return paperService.getUserPaper();
    }

    //    获取试卷组下的试卷列表
    @GetMapping("/{paperId}/papers")
    public ResponseEntity papers(@PathVariable String paperId) {
        return paperService.getPaperDetails(paperId);
    }

}
