package cn.sparke.special.modules.v1.word.service;

import cn.sparke.special.modules.v1.word.bean.WordUserReportBean;
import cn.sparke.special.modules.v1.word.mapper.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/7/12.
 */
@Service
@Transactional
public class WordService {
    @Autowired
    WordMapper wordMapper;
    public void addReport(WordUserReportBean wordUserReportBean){
        wordMapper.delete(wordUserReportBean.getUserId(),wordUserReportBean.getCatalogId());
        wordUserReportBean.preInsert();
        wordMapper.insertReport(wordUserReportBean);
    }
}
