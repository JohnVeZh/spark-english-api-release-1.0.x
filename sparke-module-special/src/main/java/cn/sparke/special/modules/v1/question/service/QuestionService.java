package cn.sparke.special.modules.v1.question.service;


import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.special.modules.v1.paper.bean.StructureBean;
import cn.sparke.special.modules.v1.paper.mapper.PaperMapper;
import cn.sparke.special.modules.v1.paper.mapper.StructureMapper;
import cn.sparke.special.modules.v1.question.bean.*;
import cn.sparke.special.modules.v1.question.constants.DifficultyLevel;
import cn.sparke.special.modules.v1.question.constants.QuestionStatus;
import cn.sparke.special.modules.v1.question.constants.WrongBookType;
import cn.sparke.special.modules.v1.question.mapper.QuestionItemMapper;
import cn.sparke.special.modules.v1.question.mapper.QuestionOptionMapper;
import cn.sparke.special.modules.v1.question.mapper.WrongBookMapper;
import cn.sparke.special.modules.v1.record.bean.QuestionRecordBean;
import cn.sparke.special.modules.v1.record.bean.QuestionRecordDetailBean;
import cn.sparke.special.modules.v1.record.constants.RecordType;
import cn.sparke.special.modules.v1.record.mapper.QuestionRecordMapper;
import cn.sparke.special.modules.v1.report.bean.QuestionReportBean;
import cn.sparke.special.modules.v1.report.bean.QuestionReportRecordBean;
import cn.sparke.special.modules.v1.report.constants.ReportType;
import cn.sparke.special.modules.v1.report.mapper.QuestionReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
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
 * Created by zhangbowen on 2017/7/10.
 */
@Service
@Transactional
public class QuestionService {
    @Autowired
    PaperMapper paperMapper;
    @Autowired
    QuestionRecordMapper recordMapper;
    @Autowired
    QuestionItemMapper itemMapper;
    @Autowired
    QuestionOptionMapper optionMapper;
    @Autowired
    WrongBookMapper wrongBookMapper;
    @Autowired
    QuestionReportMapper reportMapper;
    @Autowired
    StructureMapper structureMapper;

    public void quit(QuestionReportBean reportBean){
        StructureBean structureBean = structureMapper.getStructure(reportBean.getPaperStructureId());
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
//        WrongBookBean wrongBookBean = null;
        List<WrongBookDetailBean> wrongBookDetailBeanList = new ArrayList<>();
        List<QuestionItemBean> itemBeanList = questionBean.getQuestionItemList();
        //根据类型分别处理（1、听力2、阅读）
        recordBean.setDifficultyLevel(DifficultyLevel.defaultValue);
        recordBean.setIsFinish(0);
        recordBean.setUseTime(reportBean.getUseTime());
        recordBean.setType(RecordType.special);
        recordBean.setSort(1);
        recordBean.setPaperId(reportBean.getPaperId());
        recordBean.setQuestionId(questionBean.getId());
        recordBean.setQuestionNum(questionBean.getQuestionNum());
        recordBean.setQuestionType(reportBean.getPaperType());
        recordBean.setStructureId(reportBean.getPaperStructureId());
        recordBean.setSectionCode(reportBean.getSectionCode());
        recordBean.setUserId(reportBean.getUserId());
        recordBean.preInsert();
        List<QuestionOptionBean> optionBeanList = optionMapper.getAnswerOption(questionBean.getId());
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
//            if(status > 1){
//                if(wrongBookBean == null){
//                    wrongBookBean = new WrongBookBean();
//                    wrongBookBean.setType(WrongBookType.special);
//                    wrongBookBean.setUserId(recordBean.getUserId());
//                    wrongBookBean.setQuestionId(questionBean.getId());
//                    wrongBookBean.setSectionCode(reportBean.getSectionCode());
//                    wrongBookBean.setPaperId(reportBean.getPaperId());
//                    wrongBookBean.setStructureId(reportBean.getPaperStructureId());
//                    wrongBookBean.setStructureAlias(reportBean.getPaperStructureAlias());
//                    wrongBookBean.setSort(1);
//                }
//                WrongBookDetailBean wrongBookDetailBean = new WrongBookDetailBean();
//                wrongBookDetailBean.setUserId(wrongBookBean.getUserId());
//                wrongBookDetailBean.setStructureAlias(wrongBookBean.getStructureAlias());
//                wrongBookDetailBean.setStructureId(reportBean.getPaperStructureId());
//                wrongBookDetailBean.setQuestionItemId(userItemBean.getId());
//                wrongBookDetailBean.setQuestionId(questionBean.getId());
//                wrongBookDetailBean.setPaperId(reportBean.getPaperId());
//                wrongBookDetailBean.setSort((j+1));
//                wrongBookDetailBean.setRecordDetailsId(recordDetailBean.getId());
//                wrongBookDetailBeanList.add(wrongBookDetailBean);
//            }
        }

//        if(wrongBookBean != null){
//            wrongBookBean.setWrongBookDetailBeanList(wrongBookDetailBeanList );
//        }

        List<Supplier> taskList = new ArrayList<>();

        if(recordBean != null) {
            taskList.add(() -> recordMapper.deleteRecordAndDetail(recordBean));
            taskList.add(() -> reportMapper.deleteReport(reportBean));
            taskList.add(() -> recordMapper.insertRecord(recordBean));
        }
        if(recordDetailBeanList != null && recordDetailBeanList.size()>0) {
            taskList.add(() ->  recordMapper.insertRecordDetailList(recordDetailBeanList));
        }
        //组装错题本

//        if(wrongBookBean != null){
//            String toDo = "insert";
//            List<WrongBookDetailBean> inDetailBeanList = new ArrayList<>();
//            WrongBookBean bookBean =  wrongBookMapper.getByQuestionId(wrongBookBean.getUserId(),wrongBookBean.getQuestionId(),wrongBookBean.getStructureId());
//            if(bookBean == null){
//                wrongBookBean.preInsert();
//            }else{
//                wrongBookBean.setId(bookBean.getId());
//                wrongBookBean.preUpdate();
//                toDo = "update";
//            }
//            List<WrongBookDetailBean> detailBeanList =  wrongBookBean.getWrongBookDetailBeanList();
//            WrongBookBean finalWrongBookBean = wrongBookBean;
//            detailBeanList.forEach(wrongBookDetailBean -> {
//                WrongBookDetailBean detailBean = wrongBookMapper.getDetailByQuestionId(wrongBookDetailBean.getUserId(),wrongBookDetailBean.getQuestionId(),wrongBookDetailBean.getStructureId());
//                if(detailBean == null){
//                    wrongBookDetailBean.preInsert();
//                    wrongBookDetailBean.setWrongBookId(finalWrongBookBean.getId());
//                    inDetailBeanList.add(wrongBookDetailBean);
//                }}
//            );
//
//            if(inDetailBeanList != null && inDetailBeanList.size()>0){
//                WrongBookBean finalWrongBookBean1 = wrongBookBean;
//                if(toDo.equals("insert")){
//                    taskList.add(() ->wrongBookMapper.insert(finalWrongBookBean1));
//                }
//                if(toDo.equals("update")){
//                    taskList.add(() ->wrongBookMapper.update(finalWrongBookBean1));
//                }
//                taskList.add(() ->wrongBookMapper.insertDetailList(inDetailBeanList));
//            }
//        }
        taskList.forEach(Supplier::get);
    }


    public void submit(QuestionReportBean reportBean){
        StructureBean structureBean = structureMapper.getStructure(reportBean.getPaperStructureId());
        if(structureBean != null){
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
        recordBean.setType(RecordType.special);
        recordBean.setSort(1);
        recordBean.setPaperId(reportBean.getPaperId());
        recordBean.setQuestionId(questionBean.getId());
        recordBean.setQuestionNum(1);
        recordBean.setQuestionType(reportBean.getPaperType());
        recordBean.setSectionCode(sectionCode);
        recordBean.setStructureId(reportBean.getPaperStructureId());
        recordBean.setUserId(userId);
        recordBean.preInsert();
        if(recordBean != null) {
            taskList.add(() -> recordMapper.deleteRecordAndDetail(recordBean));
            taskList.add(() -> recordMapper.insertRecord(recordBean));
        }
        taskList.forEach(Supplier::get);
    }

}
