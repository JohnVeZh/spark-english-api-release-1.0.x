package cn.sparke.special.modules.v1.paper.service;


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
import cn.sparke.special.modules.v1.question.mapper.QuestionMapper;
import cn.sparke.special.modules.v1.question.mapper.QuestionOptionMapper;
import cn.sparke.special.modules.v1.question.mapper.WrongBookMapper;
import cn.sparke.special.modules.v1.record.bean.QuestionRecordBean;
import cn.sparke.special.modules.v1.record.bean.QuestionRecordDetailBean;
import cn.sparke.special.modules.v1.record.constants.RecordType;
import cn.sparke.special.modules.v1.record.mapper.QuestionRecordMapper;
import cn.sparke.special.modules.v1.report.bean.QuestionReportBean;
import cn.sparke.special.modules.v1.report.bean.QuestionReportRecordBean;
import cn.sparke.special.modules.v1.report.constants.CatalogType;
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
import java.util.stream.Collectors;

import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * Created by zhangbowen on 2017/7/10.
 */
@Service
public class PaperService {
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
    @Autowired
    QuestionMapper questionMapper;
    @Transactional
    public QuestionReportBean submitPaper(QuestionReportBean reportBean){
        StructureBean structureBean = structureMapper.getStructure(reportBean.getPaperStructureId());
        if (structureBean == null) {
            structureBean = new StructureBean();
            structureBean.setAlias("");
        }else{
            reportBean.setPaperId(structureBean.getPaperId());
        }
        QuestionBean questionBean = reportBean.getQuestion();
        reportBean.setQuestionId(questionBean.getId());
        reportBean.setPaperStructureAlias(structureBean.getAlias());
        reportBean.setCatalogType(CatalogType.special);//1、专项练习2、配套专区3、大礼包
        reportBean.setType(ReportType.question);//1.试卷报告 2.试卷结构报告 3.题目报告
        reportBean.setSort(1);
        List<QuestionRecordDetailBean> recordDetailBeanList = new ArrayList<>();
        reportBean.preInsert();
        int rightNum = 0;
        int wrongNum = 0;
        int totalNum = reportBean.getTotalNum() != null ? reportBean.getTotalNum() : 0;
        BigDecimal rightDate = new BigDecimal(0).setScale(2);
        QuestionRecordBean recordBean = new QuestionRecordBean();
        QuestionReportRecordBean reportRecord = new QuestionReportRecordBean();
        WrongBookBean wrongBookBean = null;
        List<WrongBookDetailBean> wrongBookDetailBeanList = new ArrayList<>();
        List<QuestionItemBean> itemBeanList = questionBean.getQuestionItemList();
        recordBean.setDifficultyLevel(DifficultyLevel.defaultValue);
        recordBean.setIsFinish(1);
        recordBean.setType(RecordType.special);
        recordBean.setSort(1);
        recordBean.setPaperId(reportBean.getPaperId());
        recordBean.setQuestionId(questionBean.getId());
        recordBean.setQuestionNum(questionBean.getQuestionNum());
        recordBean.setQuestionType(questionBean.getType());
        recordBean.setSectionCode(reportBean.getSectionCode());
        recordBean.setStructureId(reportBean.getPaperStructureId());
        recordBean.setUserId(reportBean.getUserId());
        recordBean.setQuestionNum(reportBean.getTotalNum());
        recordBean.preInsert();
        //组装报告记录表
        reportRecord.setRecordId(recordBean.getId());
        reportRecord.setReportId(reportBean.getId());
        reportRecord.setSort(1);
        reportRecord.preInsert();
        List<QuestionOptionBean> optionBeanList = optionMapper.getAnswerOption(questionBean.getId());
        Map<String, String> answerMap = optionBeanList.stream().collect(Collectors.toMap(QuestionOptionBean::getItemId, QuestionOptionBean::getId,(a,b)->a));
        for (int j = 0; j < itemBeanList.size(); j++) {
            QuestionItemBean userItemBean = itemBeanList.get(j);
            QuestionRecordDetailBean recordDetailBean = new QuestionRecordDetailBean();
            int status = QuestionStatus.wrong;//做题状态默认错误
            String rightOptionId = null;
            if (userItemBean != null) {
                if (answerMap != null) {
                    rightOptionId = answerMap.get(userItemBean.getId());
                    if (rightOptionId != null && rightOptionId.equals(userItemBean.getUserOptionId())) {
                        rightNum++;
                        status = QuestionStatus.right;
                    } else {
                        wrongNum++;
                        if (userItemBean.getUserOptionId() == null || userItemBean.getUserOptionId().equals("")) {
                            status = QuestionStatus.noDid;
                        } else {
                            status = QuestionStatus.wrong;
                        }
                    }
                } else {
                    wrongNum++;
                }
            }
            userItemBean.setRightOptionId(rightOptionId);
            userItemBean.setStatus(status);
            itemBeanList.set(j, userItemBean);
            //组装记录
            recordDetailBean.setQuestionId(recordBean.getQuestionId());
            recordDetailBean.setQuestionItemId(userItemBean.getId());
            recordDetailBean.setQuestionRecordId(recordBean.getId());
            recordDetailBean.setRightOptionId(rightOptionId);
            recordDetailBean.setStatus(status);
            recordDetailBean.setUserId(recordBean.getUserId());
            recordDetailBean.setUserOptionId(userItemBean.getUserOptionId());
            recordDetailBean.setSort((j + 1));
            recordDetailBean.preInsert();
            recordDetailBeanList.add(recordDetailBean);

            //组装错题
            if (status > 1) {
                if (wrongBookBean == null) {
                    wrongBookBean = new WrongBookBean();
                    wrongBookBean.setType(WrongBookType.special);
                    wrongBookBean.setUserId(recordBean.getUserId());
                    wrongBookBean.setQuestionId(questionBean.getId());
                    wrongBookBean.setSectionCode(reportBean.getSectionCode());
                    wrongBookBean.setStructureId(reportBean.getPaperStructureId());
                    wrongBookBean.setStructureAlias(reportBean.getPaperStructureAlias());
                    wrongBookBean.setSort(1);
                    wrongBookBean.setPaperId(reportBean.getPaperId());
                }
                WrongBookDetailBean wrongBookDetailBean = new WrongBookDetailBean();
                wrongBookDetailBean.setUserId(wrongBookBean.getUserId());
                wrongBookDetailBean.setStructureAlias(wrongBookBean.getStructureAlias());
                wrongBookDetailBean.setStructureId(reportBean.getPaperStructureId());
                wrongBookDetailBean.setQuestionItemId(userItemBean.getId());
                wrongBookDetailBean.setQuestionId(questionBean.getId());
                wrongBookDetailBean.setPaperId(reportBean.getPaperId());
                wrongBookDetailBean.setSort((j + 1));
                wrongBookDetailBean.setRecordDetailsId(recordDetailBean.getId());
                wrongBookDetailBeanList.add(wrongBookDetailBean);
            }
        }
        if (wrongBookBean != null) {
            wrongBookBean.setWrongBookDetailBeanList(wrongBookDetailBeanList);
        }
        questionBean.setQuestionItemList(itemBeanList);
        rightDate = totalNum > 0 ? BigDecimal.valueOf(rightNum).divide(BigDecimal.valueOf(totalNum), 2, ROUND_HALF_UP) : BigDecimal.valueOf(0).setScale(2);
        reportBean.setQuestion(questionBean);
        reportBean.setRightNum(rightNum);
        reportBean.setWrongNum(wrongNum);
        reportBean.setRightRate(rightDate);
        List<Supplier> taskList = new ArrayList<>();

        //加入记录
        if (recordBean != null) {
            taskList.add(() -> recordMapper.deleteRecordAndDetail(recordBean));
            taskList.add(() -> reportMapper.deleteReport(reportBean));
            taskList.add(() -> recordMapper.insertRecord(recordBean));
        }
        if (recordDetailBeanList != null && recordDetailBeanList.size() > 0) {
            taskList.add(() -> recordMapper.insertRecordDetailList(recordDetailBeanList));
        }

        //组装错题本

        if (wrongBookBean != null) {
            String toDo = "insert";
            List<WrongBookDetailBean> inDetailBeanList = new ArrayList<>();
            WrongBookBean bookBean = wrongBookMapper.getByQuestionId(wrongBookBean.getUserId(), wrongBookBean.getQuestionId(), wrongBookBean.getStructureId());
            if (bookBean == null) {
                wrongBookBean.preInsert();
            } else {
                wrongBookBean.setId(bookBean.getId());
                wrongBookBean.preUpdate();
                toDo = "update";
            }
            List<WrongBookDetailBean> detailBeanList = wrongBookBean.getWrongBookDetailBeanList();
            WrongBookBean finalWrongBookBean = wrongBookBean;
            detailBeanList.forEach(wrongBookDetailBean -> {
                        WrongBookDetailBean detailBean = wrongBookMapper.getDetailByQuestionId(wrongBookDetailBean.getUserId(), wrongBookDetailBean.getQuestionId(), wrongBookDetailBean.getStructureId());
                        if (detailBean == null) {
                            wrongBookDetailBean.preInsert();
                            wrongBookDetailBean.setWrongBookId(finalWrongBookBean.getId());
                            inDetailBeanList.add(wrongBookDetailBean);
                        }
                    }
            );

            if (inDetailBeanList != null && inDetailBeanList.size() > 0) {
                WrongBookBean finalWrongBookBean1 = wrongBookBean;
                if (toDo.equals("insert")) {
                    taskList.add(() -> wrongBookMapper.insert(finalWrongBookBean1));
                }
                if (toDo.equals("update")) {
                    taskList.add(() -> wrongBookMapper.update(finalWrongBookBean1));
                }
                taskList.add(() -> wrongBookMapper.insertDetailList(inDetailBeanList));
            }
        }

        if (reportRecord != null) {
            taskList.add(() -> reportMapper.insertReportRecord(reportRecord));
        }
        if (reportBean != null) {
            taskList.add(() -> reportMapper.deleteReportAndReportRecord(reportBean));
            taskList.add(() -> reportMapper.insert(reportBean));
        }
        taskList.forEach(Supplier::get);
        QuestionBean nextBean = questionMapper.getNextQuestion(reportBean.getUserId(), reportBean.getSectionCode(), reportBean.getPaperStructureId());
        if (nextBean != null) {
            reportBean.setNextQuestion(nextBean);
        }
        reportBean.setSort(null);
        reportBean.setUpdateDate(null);
        reportBean.setUserId(null);
        reportBean.setQuestionId(null);
        reportBean.setCatalogType(null);
        reportBean.setPaperStructureAlias(null);
        reportBean.setType(null);
        reportBean.setSectionCode(null);
        reportBean.setPaperType(null);
        reportBean.getQuestion().setIsFinish(null);
        reportBean.getQuestion().setDifficultyLevel(null);
        reportBean.getQuestion().setType(null);
        reportBean.getQuestion().setQuestionNum(null);
        return reportBean;
    }
}
