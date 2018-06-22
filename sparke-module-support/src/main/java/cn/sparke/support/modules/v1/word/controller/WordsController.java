package cn.sparke.support.modules.v1.word.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.support.modules.v1.word.bean.vo.Words;
import cn.sparke.support.modules.v1.word.service.WordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 10:45
 */
@LoginAnnot
@RestController
@RequestMapping("${version}/words")
public class WordsController {

    @Resource
    private WordService wordService;

    @GetMapping("/catalogs")
    public ResponseEntity getCatalogs() {
        return ResponseEntity.ok(wordService.findCatalogs());
    }

    @GetMapping("/catalogs/{catalogId}")
    public ResponseEntity getCatalogsById(@RequestParam(value = "start", defaultValue = "0") Integer start,
                                          @RequestParam(value = "rows", defaultValue = "10") Integer rows,
                                          @PathVariable String catalogId) {
        return ResponseEntity.ok(wordService.findWords(catalogId, start, rows));
    }

    @GetMapping("/news")
    public ResponseEntity getNewWord(@RequestParam(value = "start", defaultValue = "0") Integer start,
                                     @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        return ResponseEntity.ok(wordService.getNewWord(start, rows));
    }

    @PostMapping("/news/{wordId}")
    public ResponseEntity addNewWord(@PathVariable String wordId) {
        return wordService.addNewWord(wordId);
    }

    @DeleteMapping("/news/{wordId}")
    public ResponseEntity deleteNewWord(@PathVariable String wordId) {
        return wordService.deleteNewWord(wordId);
    }
}
