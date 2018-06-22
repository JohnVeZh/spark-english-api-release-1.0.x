package cn.sparke.support.modules.v1.word.service;

import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.core.common.mybatis.utils.PagerUtils;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.support.modules.v1.word.bean.po.TbNewWord;
import cn.sparke.support.modules.v1.word.bean.vo.Words;
import cn.sparke.support.modules.v1.word.bean.vo.WordsCatalogs;
import cn.sparke.support.modules.v1.word.constants.WordCatalogType;
import cn.sparke.support.modules.v1.word.mapper.ITbWordCatalogMapper;
import cn.sparke.support.modules.v1.word.mapper.ITbWordMapper;
import cn.sparke.support.modules.v1.word.mapper.TbNewWordMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 11:01
 */
@Service
public class WordService {

    @Resource
    private ITbWordCatalogMapper wordCatalogMapper;

    @Resource
    private ITbWordMapper wordMapper;

    @Resource
    private TbNewWordMapper newWordMapper;

    /**
     * 获取所有目录
     */
    public List<WordsCatalogs> findCatalogs() {
        return wordCatalogMapper.findByTypeAndLevel(WordCatalogType.WORD.getValues(), ContextUtils.getCurAuth().getSectionCode(), "1");
    }

    /**
     * 获取指定目录下的所有单词
     */
    public PagerBean<Words> findWords(String catalogId, Integer start, Integer rows) {
        String userId = ContextUtils.getCurAuth().getUserId();
        //填充分页参数
        PageHelper.offsetPage(start, rows);
        Page<Words> wordsList = wordMapper.findByCatalogId(userId,catalogId);
        return  PagerUtils.getPager(wordsList);
    }

    /**
     * 获取生词本数据
     */
    public PagerBean<Words> getNewWord(Integer start, Integer rows) {
        String userId = ContextUtils.getCurAuth().getUserId();
        //填充分页参数
        PageHelper.offsetPage(start, rows);
        Page<Words> list = newWordMapper.findByUserId(userId);
        return PagerUtils.getPager(list);
    }

    /**
     * 添加到生词本数据
     */
    @Transactional
    public ResponseEntity addNewWord(String wordId) {
        String userId = ContextUtils.getCurAuth().getUserId();
        TbNewWord dbNewWord = newWordMapper.getByUserAndWordId(userId, wordId);
        if (dbNewWord != null) {
            //已经添加到错题本了
            return ResponseEntity.ok(null);
        }
        TbNewWord tbNewWord = new TbNewWord(userId, wordId);
        newWordMapper.insert(tbNewWord);
        return ResponseEntity.accepted().build();
    }

    public ResponseEntity deleteNewWord(String wordId) {
        newWordMapper.deleteByWordIdAndUserId(wordId, ContextUtils.getCurAuth().getUserId());
        return ResponseEntity.noContent().build();
    }
}
