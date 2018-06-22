package cn.sparke.gift.modules.v1.exercise.service;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.gift.modules.v1.exercise.bean.*;
import cn.sparke.gift.modules.v1.exercise.constant.*;
import cn.sparke.gift.modules.v1.exercise.mapper.GiftExerciseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * Created by Administrator on 2017/8/18.
 */
@Transactional
@Service
public class GiftExerciseService{
    @Autowired
    GiftExerciseMapper mapper;

    public void quit(QuestionReportBean reportBean){
        StructureBean structureBean = mapper.getStructure(reportBean.getPaperStructureId());
        if(structureBean == null){
            structureBean = new StructureBean();
            structureBean.setAlias("");
        }else{
            reportBean.setPaperId(structureBean.getPaperId());
        }
        reportBean.setPaperStructureAlias(structureBean.getAlias());
        QuestionBean questionBean = reportBean.getQuestion();
        List<QuestionRecordDetailBean> recordDetailBeanList = new ArrayList<>();
        QuestionRecordBean recordBean = new QuestionRecordBean();
        List<QuestionItemBean> itemBeanList = questionBean.getQuestionItemList();
        //根据类型分别处理（1、听力2、阅读）
        recordBean.setDifficultyLevel(DifficultyLevel.defaultValue);
        recordBean.setIsFinish(0);
        recordBean.setType(RecordType.gift);//记录类型
        recordBean.setSort(1);
        recordBean.setPaperId(reportBean.getPaperId());
        recordBean.setQuestionId(questionBean.getId());
        recordBean.setQuestionNum(questionBean.getQuestionNum());
        recordBean.setQuestionType(reportBean.getContentType());
        recordBean.setSectionCode(reportBean.getSectionCode());
        recordBean.setStructureId(reportBean.getPaperStructureId());
        recordBean.setUserId(reportBean.getUserId());
        recordBean.preInsert();
        List<QuestionOptionBean> optionBeanList = mapper.getAnswerOption(questionBean.getId());
        Map<String,String> answerMap = optionBeanList.stream().collect(Collectors.toMap(QuestionOptionBean::getItemId,QuestionOptionBean::getId));
        for(int j = 0;j<itemBeanList.size();j++){
            QuestionItemBean userItemBean = itemBeanList.get(j);
            QuestionRecordDetailBean recordDetailBean = new QuestionRecordDetailBean();
            int status = QuestionStatus.wrong;//做题状态默认错误
            String rightOptionId = null;
            if(userItemBean != null){
                if(answerMap!=null){
                    rightOptionId = answerMap.get(userItemBean.getId());
                    if(rightOptionId != null && rightOptionId.equals(userItemBean.getUserOptionId()) ){
                        status = QuestionStatus.right;
                    }else{
                        if(userItemBean.getUserOptionId() == null || userItemBean.getUserOptionId().equals("")){
                            status = QuestionStatus.noDid;
                        }else{
                            status = QuestionStatus.wrong;
                        }
                    }
                }
            }
            userItemBean.setRightOptionId(rightOptionId);
            userItemBean.setStatus(status);
            itemBeanList.set(j,userItemBean);
            //组装记录
            recordDetailBean.setQuestionId(recordBean.getQuestionId());
            recordDetailBean.setQuestionItemId(userItemBean.getId());
            recordDetailBean.setQuestionRecordId(recordBean.getId());
            recordDetailBean.setRightOptionId(rightOptionId);
            recordDetailBean.setStatus(status);
            recordDetailBean.setUserId(recordBean.getUserId());
            recordDetailBean.setUserOptionId(userItemBean.getUserOptionId());
            recordDetailBean.setSort((j+1));
            recordDetailBean.preInsert();
            recordDetailBeanList.add(recordDetailBean);
            }
        List<Supplier> taskList = new ArrayList<>();

        if(recordBean != null) {
            taskList.add(() -> mapper.deleteRecordAndDetail(recordBean));
            taskList.add(() -> mapper.deleteReport(reportBean));
            taskList.add(() -> mapper.insertRecord(recordBean));
        }
        if(recordDetailBeanList != null && recordDetailBeanList.size()>0) {
            taskList.add(() ->  mapper.insertRecordDetailList(recordDetailBeanList));
        }
        //组装错题本

        taskList.forEach(Supplier::get);
    }


    public void submit(QuestionReportBean reportBean){
        StructureBean structureBean = mapper.getStructure(reportBean.getPaperStructureId());
        if (structureBean != null) {
            reportBean.setPaperId(structureBean.getPaperId());
        }
        QuestionRecordBean recordBean = new QuestionRecordBean();
        AuthEntity entity = ContextUtils.getCurAuth();
        String userId = entity.getUserId();
        int sectionCode  = entity.getSectionCode();
        List<Supplier> taskList = new ArrayList<>();
        QuestionBean questionBean = reportBean.getQuestion();
        recordBean.setDifficultyLevel(questionBean.getDifficultyLevel());
        recordBean.setIsFinish(1);
        recordBean.setType(RecordType.gift);//记录类型
        recordBean.setSort(0);
        recordBean.setPaperId(reportBean.getPaperId());
        recordBean.setQuestionId(questionBean.getId());
        recordBean.setQuestionNum(1);
        recordBean.setQuestionType(reportBean.getContentType());
        recordBean.setSectionCode(sectionCode);
        recordBean.setStructureId(reportBean.getPaperStructureId());
        recordBean.setUserId(userId);
        recordBean.preInsert();
        if(recordBean != null) {
            taskList.add(() -> mapper.deleteRecordAndDetail(recordBean));
            taskList.add(() -> mapper.insertRecord(recordBean));
        }
        taskList.forEach(Supplier::get);
    }
    public QuestionReportBean submitPaper(QuestionReportBean reportBean){
        AuthEntity entity = ContextUtils.getCurAuth();
        StructureBean structureBean = mapper.getStructure(reportBean.getPaperStructureId());
        if(structureBean == null){
            structureBean = new StructureBean();
            structureBean.setAlias("");
        }else{
            reportBean.setPaperId(structureBean.getPaperId());
        }
        String userId = entity.getUserId();
        int sectionCode  = entity.getSectionCode();
        QuestionBean questionBean = reportBean.getQuestion();
        reportBean.setQuestionId(questionBean.getId());
        reportBean.setPaperStructureAlias(structureBean.getAlias());
        reportBean.setCatalogType(CatalogType.gift);//1、专项练习 2、配套专区 3、大礼包类型
        reportBean.setType(ReportType.question);//1.试卷报告 2.试卷结构报告 3.题目报告
        reportBean.setSectionCode(sectionCode);
        reportBean.setUserId(userId);
        reportBean.setSort(1);
        List<QuestionRecordDetailBean> recordDetailBeanList = new ArrayList<>();
        reportBean.preInsert();
        int rightNum = 0;
        int wrongNum = 0;
        int totalNum =  reportBean.getTotalNum() != null ? reportBean.getTotalNum():0;
        BigDecimal rightDate = new BigDecimal(0).setScale(2);
        QuestionRecordBean recordBean = new QuestionRecordBean();
        QuestionReportRecordBean reportRecord = new QuestionReportRecordBean();
        List<QuestionItemBean> itemBeanList = questionBean.getQuestionItemList();
        recordBean.setDifficultyLevel(DifficultyLevel.defaultValue);
        recordBean.setIsFinish(1);
        recordBean.setType(RecordType.gift);//记录类型
        recordBean.setSort(1);
        recordBean.setPaperId(reportBean.getPaperId());
        recordBean.setQuestionId(questionBean.getId());
        recordBean.setQuestionNum(questionBean.getQuestionNum());
        recordBean.setQuestionType(questionBean.getType());
        recordBean.setSectionCode(sectionCode);
        recordBean.setStructureId(reportBean.getPaperStructureId());
        recordBean.setUserId(userId);
        recordBean.setQuestionNum(reportBean.getTotalNum());
        recordBean.setUseTime(reportBean.getUseTime());
        recordBean.preInsert();
        //组装报告记录表
        reportRecord.setRecordId(recordBean.getId());
        reportRecord.setReportId(reportBean.getId());
        reportRecord.setSort(1);
        reportRecord.preInsert();
        List<QuestionOptionBean> optionBeanList = mapper.getAnswerOption(questionBean.getId());
        Map<String,String> answerMap = optionBeanList.stream().collect(Collectors.toMap(QuestionOptionBean::getItemId,QuestionOptionBean::getId));
        for(int j = 0;j<itemBeanList.size();j++){
            QuestionItemBean userItemBean = itemBeanList.get(j);
            QuestionRecordDetailBean recordDetailBean = new QuestionRecordDetailBean();
            int status = QuestionStatus.wrong;//做题状态默认错误
            String rightOptionId = null;
            if(userItemBean != null){
                if(answerMap!=null){
                    rightOptionId = answerMap.get(userItemBean.getId());
                    if(rightOptionId != null && rightOptionId.equals(userItemBean.getUserOptionId()) ){
                        rightNum++;
                        status = QuestionStatus.right;
                    }else{
                        wrongNum++;
                        if(userItemBean.getUserOptionId() == null || userItemBean.getUserOptionId().equals("")){
                            status = QuestionStatus.noDid;
                        }else{
                            status = QuestionStatus.wrong;
                        }
                    }
                }else{
                    wrongNum++;
                }
            }
            userItemBean.setRightOptionId(rightOptionId);
            userItemBean.setStatus(status);
            itemBeanList.set(j,userItemBean);
            //组装记录
            recordDetailBean.setQuestionId(recordBean.getQuestionId());
            recordDetailBean.setQuestionItemId(userItemBean.getId());
            recordDetailBean.setQuestionRecordId(recordBean.getId());
            recordDetailBean.setRightOptionId(rightOptionId);
            recordDetailBean.setStatus(status);
            recordDetailBean.setUserId(recordBean.getUserId());
            recordDetailBean.setUserOptionId(userItemBean.getUserOptionId());
            recordDetailBean.setSort((j+1));
            recordDetailBean.preInsert();
            recordDetailBeanList.add(recordDetailBean);
        }
        questionBean.setQuestionItemList(itemBeanList);
        rightDate = totalNum>0 ? BigDecimal.valueOf(rightNum).divide(BigDecimal.valueOf(totalNum), 2,ROUND_HALF_UP): BigDecimal.valueOf(0).setScale(2);
        reportBean.setQuestion(questionBean);
        reportBean.setRightNum(rightNum);
        reportBean.setWrongNum(wrongNum);
        reportBean.setRightRate(rightDate);
        List<Supplier> taskList = new ArrayList<>();

        //加入记录
        if(recordBean != null ) {
            taskList.add(() -> mapper.deleteRecordAndDetail(recordBean));
            taskList.add(() -> mapper.insertRecord(recordBean));
        }
        if(recordDetailBeanList != null && recordDetailBeanList.size()>0) {
            taskList.add(() ->mapper.insertRecordDetailList(recordDetailBeanList));
        }
        if(reportRecord!= null ) {
            taskList.add(() ->mapper.insertReportRecord(reportRecord));
        }
        if(reportBean!= null ) {
            taskList.add(() -> mapper.deleteReport(reportBean));
            taskList.add(() ->mapper.insertReport(reportBean));
        }
        taskList.forEach(Supplier::get);
        reportBean.setSort(null);
        reportBean.setUpdateDate(null);
        reportBean.setUserId(null);
        reportBean.setQuestionId(null);
        reportBean.setCatalogType(null);
        reportBean.setPaperStructureAlias(null);
        reportBean.setType(null);
        reportBean.setSectionCode(null);
        reportBean.setContentType(null);
        reportBean.getQuestion().setIsFinish(null);
        reportBean.getQuestion().setDifficultyLevel(null);
        reportBean.getQuestion().setType(null);
        reportBean.getQuestion().setQuestionNum(null);
        return reportBean;
    }
}
