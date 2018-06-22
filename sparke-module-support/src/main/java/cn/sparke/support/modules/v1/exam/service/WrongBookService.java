package cn.sparke.support.modules.v1.exam.service;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.core.common.utils.Utils;
import cn.sparke.core.modules.cache.service.CacheService;
import cn.sparke.support.modules.v1.exam.bean.paper.vo.QuestionItem;
import cn.sparke.support.modules.v1.exam.bean.paper.vo.QuestionSubItem;
import cn.sparke.support.modules.v1.exam.bean.submit.po.TbPaperStructure;
import cn.sparke.support.modules.v1.exam.bean.wrongbook.po.TbQuestionItemNum;
import cn.sparke.support.modules.v1.exam.bean.wrongbook.vo.RecommendPaper;
import cn.sparke.support.modules.v1.exam.bean.wrongbook.vo.StructureItem;
import cn.sparke.support.modules.v1.exam.bean.wrongbook.vo.WrongBooks;
import cn.sparke.support.modules.v1.exam.mapper.QuestionItemNumMapper;
import cn.sparke.support.modules.v1.exam.mapper.WrongBookMapper;
import cn.sparke.support.modules.v1.exam.mapper.report.TbPaperStructureMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 21:26
 */
@Service
public class WrongBookService {
    private static final int ERROR_RATE_EXP = 7200;

    @Resource
    private CacheService cacheService;

    @Resource
    private TbPaperStructureMapper tbPaperStructureMapper;

    @Resource
    private WrongBookMapper wrongBookMapper;

    @Resource
    private QuestionItemNumMapper questionItemNumMapper;

    //    获取用户错题本数据
    public List findWrongBook() {
        AuthEntity authEntity = ContextUtils.getCurAuth();
        List<WrongBooks> wrongBooksList = wrongBookMapper.findWrongBook(authEntity.getUserId(),authEntity.getSectionCode());
        for (WrongBooks wrongBooks : wrongBooksList) {
            int num = 0;
            List<StructureItem> structureItemList = wrongBooks.getStructureList();
            for (StructureItem structureItem : structureItemList) {
                num += structureItem.getNum();
            }
            wrongBooks.setNum(num);
        }
        return wrongBooksList;
    }

    //这里传入的是第一级结构ID
    public List<QuestionItem> findWrongQuestionByStructureId(String structureId) {
        TbPaperStructure tbPaperStructure = new TbPaperStructure();
        tbPaperStructure.setId(structureId);
        List<TbPaperStructure> tbPaperStructureList = tbPaperStructureMapper.findLeafChilBypId(structureId);
        if (tbPaperStructureList == null) {
            tbPaperStructureList = new ArrayList<>();
        }
        tbPaperStructureList.add(tbPaperStructure);
        List<QuestionItem> questionItemList = wrongBookMapper.findWrongQuestionByStructureId(tbPaperStructureList, ContextUtils.getCurAuth().getUserId());
        List<String> questionSubItemIdList = questionItemList.stream().flatMap(questionItem -> questionItem.getQuestionItemList().stream()).map(QuestionSubItem::getId).collect(Collectors.toList());
        if (questionSubItemIdList != null && questionSubItemIdList.size() > 0) {
            List<TbQuestionItemNum> tbQuestionItemNumList = questionItemNumMapper.findByIdList(questionSubItemIdList);
            Map<String, Integer> map = tbQuestionItemNumList.stream().collect(Collectors.toMap(TbQuestionItemNum::getQuestionItemId, tbQuestionItemNum -> tbQuestionItemNum != null ? tbQuestionItemNum.getNum() : 0));
            questionItemList.forEach(questionItem -> {
                questionItem.getQuestionItemList().forEach(questionSubItem -> {
                    questionSubItem.setQuestionNo(map.get(questionSubItem.getId()));
                });
            });
        }
        //questionItemList.forEach(questionItem -> { questionItem.getQuestionItemList().sort(Comparator.comparing(QuestionSubItem::getQuestionNo));});
        return questionItemList;
    }

    //获取推荐的错题列表
    public List<RecommendPaper> getRecommendList() {
        List<RecommendPaper> recommendPaperVoList = (List<RecommendPaper>) cacheService.get("RecommendList");
        if (recommendPaperVoList == null || recommendPaperVoList.size() <= 0) {
            PageHelper.offsetPage(0, 20);
            double[] errorRate = new double[]{0.45, 0.22, 0.48, 0.50, 0.63, 0.57, 0.53, 0.59, 0.47, 0.49};
            List<RecommendPaper> recommendPaperList = wrongBookMapper.findRecommendPaper(Math.random());
            recommendPaperVoList = wrongBookMapper.findRecommendWrongBook(recommendPaperList.stream().map(RecommendPaper::getId).collect(Collectors.toList()));
            recommendPaperVoList.forEach(recommendPaper -> recommendPaper.getQuestionList().forEach(recommendQuestion -> {
                Double cacheErrorRate = errorRate[Utils.random(0, errorRate.length)];
                recommendQuestion.setWrongRate(cacheErrorRate);
            }));
            cacheService.set("RecommendList", recommendPaperVoList, ERROR_RATE_EXP);
        }
        return recommendPaperVoList;
    }

    public List<QuestionItem> findWrongQuestionByQuestionId(String questionId) {
        return wrongBookMapper.findWrongQuestionByQuestionItemId(questionId);
    }
}
