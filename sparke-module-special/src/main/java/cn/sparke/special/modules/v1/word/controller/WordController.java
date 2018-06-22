package cn.sparke.special.modules.v1.word.controller;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.special.modules.v1.word.bean.WordUserReportBean;
import cn.sparke.special.modules.v1.word.bean.WordBean;
import cn.sparke.special.modules.v1.word.bean.WordCatalogBean;
import cn.sparke.special.modules.v1.word.bean.WordWrongBookBean;
import cn.sparke.special.modules.v1.word.mapper.WordCatalogMapper;
import cn.sparke.special.modules.v1.word.mapper.WordMapper;
import cn.sparke.special.modules.v1.word.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/11.
 */
@RestController
@RequestMapping("/${version}/words")
public class WordController {
    @Autowired
    WordCatalogMapper wordCatalogMapper;
    @Autowired
    WordMapper wordMapper;
    @Autowired
    WordService wordService;

    /**
     * 获取背单词二级目录列表
     * @param parentCatalogId
     * @return
     */
    @GetMapping("/catalogs")
    public ResponseEntity findTwoCatalogList(@RequestParam("parentCatalogId") String parentCatalogId){
        AuthEntity entity = ContextUtils.getCurAuth();
        String userId = entity.getUserId();
        int sectionCode = entity.getSectionCode();
        List<WordCatalogBean> wordCatalogBeanList = wordCatalogMapper.findTwoCatalogList(userId,sectionCode,parentCatalogId);
        return  ResponseEntity.ok(wordCatalogBeanList);
    }

    /**
     *获取背单词三级目录列表
     * @param parentCatalogId
     * @return
     */
    @GetMapping("/catalogs/{parentCatalogId}")
    public ResponseEntity findThreeCatalogList(@PathVariable("parentCatalogId") String parentCatalogId){
        AuthEntity entity = ContextUtils.getCurAuth();
        String userId = entity.getUserId();
        int sectionCode = entity.getSectionCode();
        List<WordCatalogBean> wordCatalogBeanList = wordCatalogMapper.findThreeCatalogList(userId,sectionCode,parentCatalogId);
        return  ResponseEntity.ok(wordCatalogBeanList);
    }

    /**
     * 按目录获取单词列表
     * @param catalogId
     * @return
     */
    @GetMapping
    public ResponseEntity findWordList(@RequestParam("catalogId") String catalogId){
        int hasReport = 0;
        String userId = ContextUtils.getCurAuth().getUserId();
        if(userId != null){
            hasReport = wordMapper.hasReport(userId,catalogId);
        }
        List<WordBean> wordBeanList = wordMapper.findList(catalogId);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("hasReport",hasReport);
        resultMap.put("words",wordBeanList);
        return  ResponseEntity.ok(resultMap);
    }

    /**
     * 插入单词学习报告
     * @param wordUserReportBean
     * @return
     */
    @PostMapping("/reports")
    @LoginAnnot
    public ResponseEntity inserReport(@RequestBody WordUserReportBean wordUserReportBean){
        int hasReport = 0;
        String userId = ContextUtils.getCurAuth().getUserId();
        int sectionCode = ContextUtils.getCurAuth().getSectionCode();
        BigDecimal rightRate  = BigDecimal.valueOf(0).setScale(2) ;
        if(wordUserReportBean.getTotalNum()>0){
            rightRate = BigDecimal.valueOf(wordUserReportBean.getRightNum()).divide(BigDecimal.valueOf(wordUserReportBean.getTotalNum())).setScale(2);
        }
        wordUserReportBean.setRightRate(rightRate);
        wordUserReportBean.setUserId(userId);
        wordUserReportBean.setSectionCode(sectionCode);
        wordUserReportBean.setSort(1);
        wordService.addReport(wordUserReportBean);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 获取错词本列表
     * @return
     */
    @GetMapping("/wrongs")
    @LoginAnnot
    public ResponseEntity findWrongList(){
        String userId = ContextUtils.getCurAuth().getUserId();
        int sectionCode = ContextUtils.getCurAuth().getSectionCode();
        List<WordBean> wordBeanList = wordMapper.findWrongList(userId,sectionCode);
        return  ResponseEntity.ok(wordBeanList);
    }

    /**
     * 加入错词本
     * @param wordId
     * @return
     */
    @PostMapping("/wrongs/{wordId}")
    @LoginAnnot
    public ResponseEntity addWrongBook(@PathVariable("wordId")String wordId){
        String userId = ContextUtils.getCurAuth().getUserId();
        int sectionCode = ContextUtils.getCurAuth().getSectionCode();
        if(wordMapper.getExistWrongBook(wordId,userId)==0){
            WordWrongBookBean wordWrongBookBean = new WordWrongBookBean();
            wordWrongBookBean.setUserId(userId);
            wordWrongBookBean.setWordId(wordId);
            wordWrongBookBean.setSectionCode(sectionCode);
            wordWrongBookBean.preInsert();
            wordMapper.insertWrongBook(wordWrongBookBean);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 移除错词本
     * @param wordId
     * @return
     */
    @DeleteMapping("/wrongs/{wordId}")
    @LoginAnnot
    public ResponseEntity removeWrongBook(@PathVariable("wordId")String wordId){
        String userId = ContextUtils.getCurAuth().getUserId();
        wordMapper.deleteWrongBook(wordId,userId);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
