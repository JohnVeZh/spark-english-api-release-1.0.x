package cn.sparke.special.modules.v1.report.service;

import cn.sparke.special.modules.v1.collection.mapper.QuestionCollectionMapper;
import cn.sparke.special.modules.v1.paper.bean.PaperBean;
import cn.sparke.special.modules.v1.question.mapper.WrongBookMapper;
import cn.sparke.special.modules.v1.record.bean.QuestionRecordBean;
import cn.sparke.special.modules.v1.record.mapper.QuestionRecordMapper;
import cn.sparke.special.modules.v1.report.bean.*;
import cn.sparke.special.modules.v1.report.constants.ReportConstants;
import cn.sparke.special.modules.v1.report.mapper.QuestionReportMapper;
import cn.sparke.special.modules.v1.word.mapper.WordMapper;
import cn.sparke.special.modules.v1.word.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/16.
 */
@Service
public class QuestionReportService{
    @Autowired
    WordMapper wordMapper;
    @Autowired
    QuestionReportMapper questionReportMapper;
    @Autowired
    QuestionCollectionMapper questionCollectionMapper;
    @Autowired
    WrongBookMapper wrongBookMapper;
    @Autowired
    QuestionRecordMapper recordMapper;

    public AbilityBean getWrongCollectionRecordNum(String userId,int sectionCode) {
        AbilityBean abilityBean = new AbilityBean();
        //获取错词本、题目收藏、我的错题、练习记录 数量
        int wrongWordNum = wordMapper.getWrongWordCount(userId, sectionCode);
        int collectionNum = questionCollectionMapper.getCollectionCount(userId, sectionCode);
        int wrongQuestionNum = wrongBookMapper.getWrongCount(userId, sectionCode);
        int recordNum = recordMapper.getRecordCount(sectionCode, userId);
        abilityBean.setWrongWordNum(wrongWordNum);
        abilityBean.setCollectionNum(collectionNum);
        abilityBean.setWrongQuestionNum(wrongQuestionNum);
        abilityBean.setRecordNum(recordNum);
        return abilityBean;
    }

    public AbilityBean getAbility(String userId,int sectionCode){
        float ls = 0,rs = 0,ts = 0,ws = 0,wds = 0;
        int totalScore = 0;
        float wordAbilityValue = 0,listenAbilityValue = 0,readAbilityValue = 0,transAbilityValue = 0,writeAbilityValue = 0 ;
        Long start = System.currentTimeMillis();
        if(userId != null && !userId.equals("")){
            //获取听力阅读翻译写作单词等基础计算数据
            int wordTotal = wordMapper.getWordTotal(sectionCode);
//            System.out.println("获取单词总数时间： "+(System.currentTimeMillis()-start)+"ms");
            NumBean wordBean = wordMapper.getDidAndRightWordTotal(userId,sectionCode);
//            System.out.println("获取单词已做数量时间： "+(System.currentTimeMillis()-start)+"ms");
            wordBean.setTotal(wordTotal);
            List<PaperBean> paperBeanList = questionReportMapper.getPaperList(sectionCode);
//            System.out.println("获取试卷列表时间： "+(System.currentTimeMillis()-start)+"ms");
            int listeningTotal=0,readTotal=0,translation=0,writ = 0;
            for(PaperBean paperBean:paperBeanList){
                if(paperBean.getQuestionNum() != null && paperBean.getContentType() == 1){
                    listeningTotal += paperBean.getQuestionNum();
                }else if(paperBean.getQuestionNum() != null && paperBean.getContentType() == 2){
                    readTotal += paperBean.getQuestionNum();
                }else if(paperBean.getQuestionNum() != null && paperBean.getContentType() == 3){
                    translation += paperBean.getQuestionNum();
                }else if(paperBean.getQuestionNum() != null && paperBean.getContentType() == 4){
                    writ += paperBean.getQuestionNum();
                }
            }
//            System.out.println("处理完试卷时间： "+(System.currentTimeMillis()-start)+"ms");
            List<QuestionReportBean> questionReportList = questionReportMapper.getDidAndRightTotal(userId,sectionCode);
//            System.out.println("获取报告列表时间： "+(System.currentTimeMillis()-start)+"ms");
            int  listeningDidTotal=0,listeningRightTotal=0,readDidTotal=0,readRightTotal=0;
            for(QuestionReportBean reportBean:questionReportList){
                if(reportBean.getPaperType() != null && reportBean.getPaperType() == 1){
                    if(reportBean.getTotalNum() != null ){
                        listeningDidTotal += reportBean.getTotalNum();
                    }
                    if(reportBean.getRightNum() != null ){
                        listeningRightTotal+=reportBean.getRightNum();
                    }
                }else if(reportBean.getPaperType() != null && reportBean.getPaperType() == 2){
                    if(reportBean.getTotalNum() != null){
                        readDidTotal += reportBean.getTotalNum();
                    }
                    if(reportBean.getRightNum() != null ){
                        readRightTotal+=reportBean.getRightNum();
                    }
                }
            }
//            System.out.println("处理完报告时间： "+(System.currentTimeMillis()-start)+"ms");
            NumBean listenNumBean = new NumBean();
            listenNumBean.setTotal(listeningTotal);
            listenNumBean.setDidTotal(listeningDidTotal);
            listenNumBean.setRightTotal(listeningRightTotal);
            NumBean readNumBean = new NumBean();
            readNumBean.setTotal(readTotal);
            readNumBean.setDidTotal(readDidTotal);
            readNumBean.setRightTotal(readRightTotal);
            int easyTranslation=0,secondaryTranslation=0,difficultTranslation=0,easyWrit=0,secondaryWrit=0,difficultWrit=0;
            List<QuestionRecordBean> questionRecordBeanList = questionReportMapper.getDifficultyLevelTotal(userId,sectionCode);
//            System.out.println("获取记录时间： "+(System.currentTimeMillis()-start)+"ms");
            for(QuestionRecordBean recordBean:questionRecordBeanList){
                if(recordBean.getDifficultyLevel() != null){
                    if(recordBean.getQuestionType() != null && recordBean.getQuestionType() == 3){
                        if(recordBean.getDifficultyLevel() == 1){
                            easyTranslation++;
                        }else if(recordBean.getDifficultyLevel() == 2){
                            secondaryTranslation++;
                        }else if(recordBean.getDifficultyLevel() == 3){
                            difficultTranslation++;
                        }
                    }else if(recordBean.getQuestionType() != null && recordBean.getQuestionType() == 4){
                        if(recordBean.getDifficultyLevel() == 1){
                            easyWrit++;
                        }else if(recordBean.getDifficultyLevel() == 2){
                            secondaryWrit++;
                        }else if(recordBean.getDifficultyLevel() == 3){
                            difficultWrit++;
                        }
                    }
                }
            }
//            System.out.println("处理完记录时间： "+(System.currentTimeMillis()-start)+"ms");
            int translationReply = easyTranslation+secondaryTranslation+difficultTranslation;
            int writingReply = easyWrit+secondaryWrit+difficultWrit;
            // 能力值计算
            wordAbilityValue = 1F * wordBean.getDidTotal() / ReportConstants.wordUpset;
            listenAbilityValue = listenNumBean.getDidTotal()<1 ? 0 : this.trainingWeight(listenNumBean.getDidTotal(), listenNumBean.getTotal()) * listenNumBean.getRightTotal() / listenNumBean.getDidTotal();
            listenAbilityValue = listenAbilityValue>1 ? 1 : listenAbilityValue;
            readAbilityValue = readNumBean.getDidTotal()<1 ? 0 : this.trainingWeight(readNumBean.getDidTotal(), readNumBean.getTotal()) * readNumBean.getRightTotal() / readNumBean.getDidTotal();
            readAbilityValue = readAbilityValue>1 ? 1 : readAbilityValue;
            transAbilityValue = translationReply<1 ? 0 : (ReportConstants.difficultyWeight[0] * easyTranslation + ReportConstants.difficultyWeight[1] * secondaryTranslation + ReportConstants.difficultyWeight[2] * difficultTranslation) / translationReply;
            writeAbilityValue = writingReply<1 ? 0 : (ReportConstants.difficultyWeight[0] * easyWrit + ReportConstants.difficultyWeight[1] * secondaryWrit + ReportConstants.difficultyWeight[2] * difficultWrit) / writingReply;

            //计算分数
            ls = Math.round(2 * ReportConstants.scores[0] * listenAbilityValue) / 2F;
            rs = Math.round(2 * ReportConstants.scores[1] * readAbilityValue) / 2F;
            ts = Math.round(2 * ReportConstants.scores[2] * transAbilityValue) / 2F;
            ws = Math.round(2 * ReportConstants.scores[3] * writeAbilityValue) / 2F;
            wds = Math.round(100 * wordAbilityValue);
            totalScore =  Math.round(ReportConstants.scores[0] * listenAbilityValue + ReportConstants.scores[1] * readAbilityValue + ReportConstants.scores[2] * transAbilityValue + ReportConstants.scores[3] * writeAbilityValue);
        }
//        System.out.println("计算完分数时间： "+(System.currentTimeMillis()-start)+"ms");
        AbilityBean abilityBean = new AbilityBean();

        if(totalScore<249){
            totalScore = 249;
        }
        abilityBean.setScore(totalScore);
        List<ScoreBean> scoreList = new ArrayList<>();
        ScoreBean lsScoreBean = new ScoreBean();
        lsScoreBean.setName(ReportConstants.names[0]);
        lsScoreBean.setScore(ls);
        lsScoreBean.setType(1);
        lsScoreBean.setAbilityValue(listenAbilityValue);
        lsScoreBean.setTotalScore(ReportConstants.realScores[0]);
        ScoreBean rsScoreBean = new ScoreBean();
        rsScoreBean.setName(ReportConstants.names[1]);
        rsScoreBean.setScore(rs);
        rsScoreBean.setType(2);
        rsScoreBean.setAbilityValue(readAbilityValue);
        rsScoreBean.setTotalScore(ReportConstants.realScores[1]);
        ScoreBean tsScoreBean = new ScoreBean();
        tsScoreBean.setName(ReportConstants.names[2]);
        tsScoreBean.setScore(ts);
        tsScoreBean.setType(3);
        tsScoreBean.setAbilityValue(transAbilityValue);
        tsScoreBean.setTotalScore(ReportConstants.realScores[2]);
        ScoreBean wsScoreBean = new ScoreBean();
        wsScoreBean.setName(ReportConstants.names[3]);
        wsScoreBean.setScore(ws);
        wsScoreBean.setType(4);
        wsScoreBean.setAbilityValue(writeAbilityValue);
        wsScoreBean.setTotalScore(ReportConstants.realScores[3]);
        ScoreBean wdsScoreBean = new ScoreBean();
        wdsScoreBean.setName(ReportConstants.names[4]);
        wdsScoreBean.setScore(wds);
        wdsScoreBean.setType(5);
        wdsScoreBean.setAbilityValue(wordAbilityValue);
        wdsScoreBean.setTotalScore(ReportConstants.realScores[4]);
        scoreList.add(wdsScoreBean);
        scoreList.add(lsScoreBean);
        scoreList.add(rsScoreBean);
        scoreList.add(wsScoreBean);
        scoreList.add(tsScoreBean);
        abilityBean.setScoreList(scoreList);
//        System.out.println("方法运行完时间： "+(System.currentTimeMillis()-start)+"ms");
        return abilityBean;
    }



//    public AbilityBean getAbility(String userId,int sectionCode){
//        float ls = 0,rs = 0,ts = 0,ws = 0,wds = 0;
//        float wordAbilityValue = 0,listenAbilityValue = 0,readAbilityValue = 0,transAbilityValue = 0,writeAbilityValue = 0 ;
//        Long start = System.currentTimeMillis();
//        if(userId != null && !userId.equals("")) {
//            //获取听力阅读翻译写作单词等基础计算数据
//            int wordTotal = wordMapper.getWordTotal(sectionCode);
//            System.out.println("获取单词总数时间： " + (System.currentTimeMillis() - start) + "ms");
//            NumBean wordBean = wordMapper.getDidAndRightWordTotal(userId, sectionCode);
//            System.out.println("获取单词已做总数： " + (System.currentTimeMillis() - start) + "ms");
//            wordBean.setTotal(wordTotal);
//            int listeningTotal = 0, readTotal = 0, translation = 0, writ = 0;
//            listeningTotal = questionReportMapper.getListeningTotal(sectionCode);
//            System.out.println("获取听力总数时间： " + (System.currentTimeMillis() - start) + "ms");
//            NumBean listenNumBean = questionReportMapper.getDidAndRightListeningTotal(userId, sectionCode);
//            System.out.println("获取听力已做总数时间： " + (System.currentTimeMillis() - start) + "ms");
//            listenNumBean.setTotal(listeningTotal);
//            readTotal = questionReportMapper.getReadingTotal(sectionCode);
//            System.out.println("获取阅读总数时间： " + (System.currentTimeMillis() - start) + "ms");
//            NumBean readNumBean = questionReportMapper.getDidAndReadingTotal(userId, sectionCode);
//            System.out.println("获取阅读已做总数时间： " + (System.currentTimeMillis() - start) + "ms");
//            readNumBean.setTotal(readTotal);
//            translation = questionReportMapper.getTranslationTotal(sectionCode);
//            System.out.println("获取翻译总数时间： " + (System.currentTimeMillis() - start) + "ms");
//            int easyTranslation = questionReportMapper.getEasyTranslationTotal(userId, sectionCode);
//            System.out.println("获取翻译简单总数时间： " + (System.currentTimeMillis() - start) + "ms");
//            int secondaryTranslation = questionReportMapper.getSecondaryTranslationTotal(userId, sectionCode);
//            System.out.println("获取翻译中等难度总数时间： " + (System.currentTimeMillis() - start) + "ms");
//            int difficultTranslation = questionReportMapper.getDifficultTranslationTotal(userId, sectionCode);
//            System.out.println("获取翻译困难总数时间： " + (System.currentTimeMillis() - start) + "ms");
//            int translationReply = easyTranslation + secondaryTranslation + difficultTranslation;
//            writ = questionReportMapper.getWritingTotal(sectionCode);
//            System.out.println("获取写作总数时间： " + (System.currentTimeMillis() - start) + "ms");
//            int easyWrit = questionReportMapper.getEasyWritingTotal(userId, sectionCode);
//            System.out.println("获取写作简单总数时间： " + (System.currentTimeMillis() - start) + "ms");
//            int secondaryWrit = questionReportMapper.getSecondaryWritingTotal(userId, sectionCode);
//            System.out.println("获取写作中等总数时间： " + (System.currentTimeMillis() - start) + "ms");
//            int difficultWrit = questionReportMapper.getDifficultWritingTotal(userId, sectionCode);
//            System.out.println("获取写作困难总数时间： " + (System.currentTimeMillis() - start) + "ms");
//            int writingReply = easyWrit + secondaryWrit + difficultWrit;
//            // 能力值计算
//            wordAbilityValue = 1F * wordBean.getDidTotal() / ReportConstants.wordUpset;
//            listenAbilityValue = listenNumBean.getDidTotal() < 1 ? 0 : this.trainingWeight(listenNumBean.getDidTotal(), listenNumBean.getTotal()) * listenNumBean.getRightTotal() / listenNumBean.getDidTotal();
//            listenAbilityValue = listenAbilityValue > 1 ? 1 : listenAbilityValue;
//            readAbilityValue = readNumBean.getDidTotal() < 1 ? 0 : this.trainingWeight(readNumBean.getDidTotal(), readTotal) * readNumBean.getRightTotal() / readNumBean.getDidTotal();
//            readAbilityValue = readAbilityValue > 1 ? 1 : readAbilityValue;
//            transAbilityValue = translationReply < 1 ? 0 : (ReportConstants.difficultyWeight[0] * easyTranslation + ReportConstants.difficultyWeight[1] * secondaryTranslation + ReportConstants.difficultyWeight[2] * difficultTranslation) / translationReply;
//            writeAbilityValue = writingReply < 1 ? 0 : (ReportConstants.difficultyWeight[0] * easyWrit + ReportConstants.difficultyWeight[1] * secondaryWrit + ReportConstants.difficultyWeight[2] * difficultWrit) / writingReply;
//            System.out.println("计算完能力值时间： " + (System.currentTimeMillis() - start) + "ms");
//            //计算分数
//            ls = Math.round(2 * ReportConstants.scores[0] * listenAbilityValue) / 2F;
//            rs = Math.round(2 * ReportConstants.scores[1] * readAbilityValue) / 2F;
//            ts = Math.round(2 * ReportConstants.scores[2] * transAbilityValue) / 2F;
//            ws = Math.round(2 * ReportConstants.scores[3] * writeAbilityValue) / 2F;
//            wds = Math.round(100 * wordAbilityValue);
//        }
//        float totalScore = ls + rs + ts + ws;
//        if(totalScore<249){
//            totalScore = 249;
//        }
//        System.out.println("计算完分数时间： "+(System.currentTimeMillis()-start)+"ms");
//        AbilityBean abilityBean = new AbilityBean();
//        abilityBean.setScore(totalScore);
//        List<ScoreBean> scoreList = new ArrayList<>();
//        ScoreBean lsScoreBean = new ScoreBean();
//        lsScoreBean.setName(ReportConstants.names[0]);
//        lsScoreBean.setScore(ls);
//        lsScoreBean.setType(1);
//        lsScoreBean.setAbilityValue(listenAbilityValue);
//        lsScoreBean.setTotalScore(ReportConstants.realScores[0]);
//        ScoreBean rsScoreBean = new ScoreBean();
//        rsScoreBean.setName(ReportConstants.names[1]);
//        rsScoreBean.setScore(rs);
//        rsScoreBean.setType(2);
//        rsScoreBean.setAbilityValue(readAbilityValue);
//        rsScoreBean.setTotalScore(ReportConstants.realScores[1]);
//        ScoreBean tsScoreBean = new ScoreBean();
//        tsScoreBean.setName(ReportConstants.names[2]);
//        tsScoreBean.setScore(ts);
//        tsScoreBean.setType(3);
//        tsScoreBean.setAbilityValue(transAbilityValue);
//        tsScoreBean.setTotalScore(ReportConstants.realScores[2]);
//        ScoreBean wsScoreBean = new ScoreBean();
//        wsScoreBean.setName(ReportConstants.names[3]);
//        wsScoreBean.setScore(ws);
//        wsScoreBean.setType(4);
//        wsScoreBean.setAbilityValue(writeAbilityValue);
//        wsScoreBean.setTotalScore(ReportConstants.realScores[3]);
//        ScoreBean wdsScoreBean = new ScoreBean();
//        wdsScoreBean.setName(ReportConstants.names[4]);
//        wdsScoreBean.setScore(wds);
//        wdsScoreBean.setType(5);
//        wdsScoreBean.setAbilityValue(wordAbilityValue);
//        wdsScoreBean.setTotalScore(ReportConstants.realScores[4]);
//        scoreList.add(wdsScoreBean);
//        scoreList.add(lsScoreBean);
//        scoreList.add(rsScoreBean);
//        scoreList.add(wsScoreBean);
//        scoreList.add(tsScoreBean);
//        abilityBean.setScoreList(scoreList);
//        System.out.println("结束时间： "+(System.currentTimeMillis()-start)+"ms");
//        return abilityBean;
//    }
    public List<SpecialSuggestionBean> getAbilityDetail(List<ScoreBean> scoreList,int sectionCode){
        // 分析建议
        List<SpecialSuggestionBean> list = new ArrayList<>();
       for(int i = 0; i<scoreList.size();i++){
           ScoreBean scoreBean = scoreList.get(i);
           SpecialSuggestionBean suggestion = questionReportMapper.getSuggestion(scoreBean.getType(),scoreBean.getScore(),sectionCode);
           if(suggestion == null){
               suggestion  = new SpecialSuggestionBean();
           }
           suggestion.setName(scoreBean.getName());
           suggestion.setType(scoreBean.getType());
           suggestion.setScore(scoreBean.getScore());
           suggestion.setTotalScore(scoreBean.getTotalScore());
           suggestion.setType(scoreBean.getType());
           list.add(suggestion);
       }
        return list;
    }
    /**
     * 做题数量权重
     * @param did
     * @param total
     * @return
     */
    private float trainingWeight(int did, int total) {
        float scale = total<1 ? 0 : 1F * did / total;
        return scale<0.35 ? 0.9F : scale>=0.35 ? 1.05F : 1;
    }
    private BigDecimal toFixScale(double number, int scale) {
        return new BigDecimal(number).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

}