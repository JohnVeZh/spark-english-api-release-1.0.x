package cn.sparke.support.modules.v1.exam.service;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.bean.ResponseErrorEntity;
import cn.sparke.core.common.constants.StatusCode;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.core.common.utils.Utils;
import cn.sparke.support.modules.v1.caption.bean.vo.PaperCatalog;
import cn.sparke.support.modules.v1.caption.constants.PaperCatalogType;
import cn.sparke.support.modules.v1.caption.mapper.PaperMapper;
import cn.sparke.support.modules.v1.exam.bean.paper.vo.PaperInfo;
import cn.sparke.support.modules.v1.exam.bean.paper.vo.PaperStructureItem;
import cn.sparke.support.modules.v1.exam.bean.paper.vo.QuestionItem;
import cn.sparke.support.modules.v1.exam.bean.submit.dto.RightOption;
import cn.sparke.support.modules.v1.exam.bean.submit.po.TbPaperStructure;
import cn.sparke.support.modules.v1.exam.bean.submit.po.TbQuestionRecord;
import cn.sparke.support.modules.v1.exam.bean.submit.po.TbQuestionRecordDetail;
import cn.sparke.support.modules.v1.exam.bean.submit.po.TbQuestionReport;
import cn.sparke.support.modules.v1.exam.bean.submit.po.TbQuestionReportDetail;
import cn.sparke.support.modules.v1.exam.bean.submit.po.TbQuestionReportRecord;
import cn.sparke.support.modules.v1.exam.bean.submit.po.TbQuestionWrongBook;
import cn.sparke.support.modules.v1.exam.bean.submit.po.TbQuestionWrongBookDetail;
import cn.sparke.support.modules.v1.exam.bean.submit.vo.reponse.PaperReport;
import cn.sparke.support.modules.v1.exam.bean.submit.vo.reponse.QuestionSubItem;
import cn.sparke.support.modules.v1.exam.bean.submit.vo.reponse.StructureItem;
import cn.sparke.support.modules.v1.exam.bean.submit.vo.request.SubmitPaper;
import cn.sparke.support.modules.v1.exam.bean.submit.vo.request.SubmitQuestionItem;
import cn.sparke.support.modules.v1.exam.bean.submit.vo.request.SubmitQuestionSubItem;
import cn.sparke.support.modules.v1.exam.constants.ParperType;
import cn.sparke.support.modules.v1.exam.constants.QuestionType;
import cn.sparke.support.modules.v1.exam.constants.QuestionUserStatus;
import cn.sparke.support.modules.v1.exam.constants.ReportType;
import cn.sparke.support.modules.v1.exam.mapper.ExamMapper;
import cn.sparke.support.modules.v1.exam.mapper.QuestionMapper;
import cn.sparke.support.modules.v1.exam.mapper.ReportMapper;
import cn.sparke.support.modules.v1.exam.mapper.report.TbPaperStructureMapper;
import cn.sparke.support.modules.v1.exam.mapper.report.TbQuestionRecordDetailMapper;
import cn.sparke.support.modules.v1.exam.mapper.report.TbQuestionRecordMapper;
import cn.sparke.support.modules.v1.exam.mapper.report.TbQuestionReportDetailMapper;
import cn.sparke.support.modules.v1.exam.mapper.report.TbQuestionReportMapper;
import cn.sparke.support.modules.v1.exam.mapper.report.TbQuestionReportRecordMapper;
import cn.sparke.support.modules.v1.exam.mapper.report.TbQuestionWrongBookDetailMapper;
import cn.sparke.support.modules.v1.exam.mapper.report.TbQuestionWrongBookMapper;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 14:55
 */
@Service
public class ExamService {
    @Resource
    private ExamMapper examMapper;

    @Resource
    private PaperMapper paperMapper;

    @Resource
    private ReportMapper reportMapper;
    @Resource
    private TbPaperStructureMapper paperStructureMapper;
    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private TbQuestionWrongBookMapper questionWrongBookMapper;

    @Resource
    private TbQuestionWrongBookDetailMapper questionWrongBookDetailMapper;

    @Resource
    private TbQuestionRecordDetailMapper questionRecordDetailMapper;
    @Resource
    private TbQuestionRecordMapper questionRecordMapper;
    @Resource
    private TbQuestionReportDetailMapper questionReportDetailMapper;
    @Resource
    private TbQuestionReportMapper questionReportMapper;
    @Resource
    private TbQuestionReportRecordMapper questionReportRecordMapper;


    public List<PaperCatalog> getPaperList() {
        return paperMapper.findPaperByCatalog(PaperCatalogType.exam, ContextUtils.getCurAuth().getSectionCode());
    }

    @Cacheable(value = "download_paper")
    public PaperInfo download(String paperId) {
        PaperInfo paperInfo = examMapper.getPaper(paperId);
        List<PaperStructureItem> paperStructureItemList = examMapper.findPaperStructure(paperId);
        //将list转换成map
        Map<String, PaperStructureItem> map = paperStructureItemList.stream().collect(Collectors.toMap(PaperStructureItem::getId, paperStructureItem -> paperStructureItem));
        //将结构下的第二级复制到第三级以后
        Map<String, PaperStructureItem> second = new HashMap<>();

        for (PaperStructureItem paperStructureItem : paperStructureItemList) {
            if (paperStructureItem.getLevel() == 1) {
                second.put(paperStructureItem.getId(), paperStructureItem);
            } else if (paperStructureItem.getLevel() == 2) {
                second.put(paperStructureItem.getId(), map.get(paperStructureItem.getId()));
            } else if (paperStructureItem.getLevel() > 2) {
                String parentIds = paperStructureItem.getParentIds();
                if (!Strings.isNullOrEmpty(parentIds)) {
                    String id = parentIds.split(",")[1];
                    if (second.get(paperStructureItem.getId()) == null) {
                        second.put(paperStructureItem.getId(), map.get(id));
                    }
                }
            }
        }

        paperStructureItemList = this.buildPaperCatelog2("0", paperStructureItemList, second);
        paperInfo.setStructureList(paperStructureItemList);
        return paperInfo;
    }

    //填充第二级属性
    private static void setStructure(PaperStructureItem paperStructure, List<QuestionItem> questionItemList) {
        if (paperStructure != null && questionItemList != null) {
            questionItemList.forEach(questionItem -> {
                if (QuestionType.hearing == questionItem.getType() || QuestionType.read == questionItem.getType()) {
                    questionItem.setStructureId(paperStructure.getId());
                    questionItem.setStructureAlias(paperStructure.getAlias());
                }
            });
        }
    }

    private List<PaperStructureItem> buildPaperCatelog2(String parentId, List<PaperStructureItem> paperStructureItemList, Map<String, PaperStructureItem> second) {
        List<PaperStructureItem> chilPaperTree = new ArrayList<>();
        paperStructureItemList.forEach(paperStructureItem -> {
            if (paperStructureItem.getIsLeaf() == 1) {
                if (paperStructureItem.getLevel() == 2) {
                    setStructure(second.get(paperStructureItem.getId()), paperStructureItem.getQuestionList());
                } else if (paperStructureItem.getLevel() > 2) {
                    String secondParent = paperStructureItem.getParentIds().split(",")[1];
                    PaperStructureItem paperStructure = second.get(secondParent);
                    setStructure(paperStructure, paperStructureItem.getQuestionList());
                }
            }
            if (paperStructureItem.getParentId().equals(parentId)) {
                List<PaperStructureItem> child = buildPaperCatelog2(paperStructureItem.getId(), paperStructureItemList, second);
                paperStructureItem.setChildren(child);
                chilPaperTree.add(paperStructureItem);
            }
        });
        return chilPaperTree;
    }

    /**
     * 目前只有做错的题目会添加进错题本
     */
    @Transactional
    public ResponseEntity submitPaper(SubmitPaper submitPaper) {
        AuthEntity authEntity = ContextUtils.getCurAuth();
        //试卷结构名称查询
        TbPaperStructure paperStructure = paperStructureMapper.getById(submitPaper.getPaperStructureId());
        if (paperStructure == null) {
            return new ResponseErrorEntity(StatusCode.SUBMIT_PAPER_STRUCTURE, HttpStatus.BAD_REQUEST);
        }
        List<TbPaperStructure> paperStructureList = paperStructureMapper.findByPid(submitPaper.getPaperStructureId());
        if (paperStructure == null || paperStructureList.size() < 0) {
            return new ResponseErrorEntity(StatusCode.SUBMIT_PAPER_STRUCTURE, HttpStatus.BAD_REQUEST);
        }
        Map<String, Integer> paperStructureMap = paperStructureList.stream().collect(Collectors.toMap(TbPaperStructure::getId, TbPaperStructure::getSort));

        //获取该用户这个试卷的错题本数据
        List<TbQuestionWrongBook> questionWrongBookList = questionWrongBookMapper.findByPaperIdAndUserId(submitPaper.getPaperId(), authEntity.getUserId());
        //获取用户错题本问题大题ID
        List<String> questionWrongBookIdList = questionWrongBookList.stream().map(TbQuestionWrongBook::getQuestionId).collect(Collectors.toList());
        Map<String, String> questionWrongBookMap = questionWrongBookList.stream().collect(Collectors.toMap(TbQuestionWrongBook::getQuestionId, TbQuestionWrongBook::getId, (s, a) -> a));
        //获取用户错题本小题ID
        List<String> questionItemIdList = questionWrongBookDetailMapper.findItemIdByPaperIdAndUserId(submitPaper.getPaperId(), authEntity.getUserId());

        //添加到错题本大题
        List<TbQuestionWrongBook> questionWrongBooks = new ArrayList<>();

        //更改错题本大题的添加时间
        List<String> updateWrongBookIds = new ArrayList<>();

        //添加到错题本小题
        List<TbQuestionWrongBookDetail> questionWrongBookDetailList = new ArrayList<>();


        PaperReport paperReport = new PaperReport();
        paperReport.setPaperId(submitPaper.getPaperId());


        //获取获取提交选项ID
        List<String> subAnswer = submitPaper.getQuestionList().stream().flatMap(submitQuestionItem -> submitQuestionItem.getQuestionItemList().stream()).map(SubmitQuestionSubItem::getId).collect(Collectors.toList());

        //拼装返回数据：小题map
        Map<String, List<QuestionSubItem>> subQuestionMap = new HashMap<>();
        //拼装返回数据：结构数据
        List<StructureItem> structureList = new ArrayList<>();

        //正确选项Map
        Map<String, String> rightOptionMap = new HashMap<>();
        if (subAnswer != null && subAnswer.size() > 0) {
            rightOptionMap = questionMapper.findRightOptionByIdList(subAnswer).stream().collect(Collectors.toMap(RightOption::getSubQuestionId, RightOption::getRightOptionId, (s, a) -> a));
        }


        //批量插入做题记录表
        List<TbQuestionRecord> questionRecordList = new ArrayList<>();
        //批量插入报告做题映射表
        List<TbQuestionReportRecord> questionReportRecordList = new ArrayList<>();
        //批量插入做题记录详情表
        List<TbQuestionRecordDetail> questionRecordDetailList = new ArrayList<>();
        //批量插入报告详情表
        List<TbQuestionReportDetail> questionReportDetailList = new ArrayList<>();

        //1 插入报告表
        double allNum = 0;
        double rightNum = 0;
        double wrongNum = 0;

        String reportId = Utils.uuid();
        paperReport.setId(reportId);

        //填充报表
        TbQuestionReport questionReport = fillTbQuestionReport(paperStructure, submitPaper, authEntity, reportId);

        List<SubmitQuestionItem> questionList = submitPaper.getQuestionList();

        for (int i = 0; i < questionList.size(); i++) {
            SubmitQuestionItem submitQuestionItem = questionList.get(i);
            List<SubmitQuestionSubItem> submitQuestionSubItemList = submitQuestionItem.getQuestionItemList();
            //2 插入做题记录表
            TbQuestionRecord questionRecord = fillTbQuestionRecord(submitPaper, authEntity, i, submitQuestionItem, submitQuestionSubItemList);
            questionRecordList.add(questionRecord);

            //3 插入报告做题映射表
            TbQuestionReportRecord questionReportRecord = fillTbQuestionReportRecord(reportId, i, questionRecord);
            questionReportRecordList.add(questionReportRecord);

            //小题的总数
            double subQuestionTotal = 0;
            //小题已做数目
            double subQuestionDid = 0;
            //小题未作数量
            double subQuestionNot = 0;
            //小题正确数量
            double subQuestionRight = 0;
            //小题错误数量
            double subQuestionWrong = 0;
            //小题正确率
            double subQuestionRightRate = 0;

            for (int j = 0; j < submitQuestionSubItemList.size(); j++) {

                SubmitQuestionSubItem submitQuestionSubItem = submitQuestionSubItemList.get(j);

                //4 插入做题记录详情表
                TbQuestionRecordDetail questionRecordDetail = new TbQuestionRecordDetail();
                questionRecordDetail.preInsert();
                questionRecordDetail.setQuestionId(submitQuestionItem.getId());

                questionRecordDetail.setQuestionItemId(submitQuestionSubItem.getId());
                questionRecordDetail.setUserId(authEntity.getUserId());
                questionRecordDetail.setQuestionRecordId(questionRecord.getId());

                String userOptionId = submitQuestionSubItem.getUserOptionId();

                String rightOptionId = rightOptionMap.get(submitQuestionSubItem.getId());
                if (Strings.isNullOrEmpty(rightOptionId)) {
                    rightOptionId = "";
                }
                int status = QuestionUserStatus.undid;
                //判断用户是否做该题
                if (!Strings.isNullOrEmpty(userOptionId)) {
                    //用户已经做了这个题目
                    questionRecordDetail.setUserOptionId(userOptionId);
                    //判断用户是否答对
                    if (rightOptionId.equals(submitQuestionSubItem.getUserOptionId())) {
                        //用户回答正确
                        status = QuestionUserStatus.right;
                        rightNum++;
                        subQuestionRight++;
                    } else {
                        //用户回答错误
                        status = QuestionUserStatus.wrong;
                        wrongNum++;
                        subQuestionWrong++;
                        //判断用户是否需要加入错题本
                        if (questionWrongBookIdList.contains(submitQuestionItem.getId())) {
                            //用户不需要加入错题本，修改加入错题本时间
                            updateWrongBookIds.add(submitQuestionItem.getId());
                        } else {
                            //用户需要加入错题本
                            TbQuestionWrongBook questionWrongBook = fillTbQuestionWrongBook(submitPaper.getPaperId(), authEntity, paperStructure, submitQuestionItem.getId(), j);
                            questionWrongBookMap.put(submitQuestionItem.getId(), questionWrongBook.getId());
                            questionWrongBooks.add(questionWrongBook);
                        }

                        if (!questionItemIdList.contains(submitQuestionSubItem.getId())) {
                            //做错的题目添加进错题本
                            TbQuestionWrongBookDetail questionWrongBookDetail = fillTbQuestionWrongBookDetail(submitQuestionItem.getStructureId(), submitQuestionItem.getStructureAlias(), submitPaper, authEntity, questionWrongBookMap, submitQuestionItem, j, submitQuestionSubItem, questionRecordDetail);
                            questionWrongBookDetailList.add(questionWrongBookDetail);
                        }
                    }
                    subQuestionDid++;
                } else {
                    subQuestionNot++;
                }
                questionRecordDetail.setStatus(status);
                questionRecordDetail.setRightOptionId(rightOptionId);
                questionRecordDetail.setSort(j + 1);
                questionRecordDetailList.add(questionRecordDetail);
                allNum++;
                subQuestionTotal++;


                //拼装返回数据
                List<QuestionSubItem> questionSubItemList = subQuestionMap.get(submitQuestionItem.getStructureId());
                if (questionSubItemList == null) {
                    questionSubItemList = new ArrayList<>();
                }
                QuestionSubItem questionSubItem = new QuestionSubItem();
                questionSubItem.setId(questionRecordDetail.getQuestionItemId());
                questionSubItem.setStatus(questionRecordDetail.getStatus());
                questionSubItem.setUserOptionId(questionRecordDetail.getUserOptionId());
                questionSubItem.setRightOptionId(questionRecordDetail.getRightOptionId());
                questionSubItemList.add(questionSubItem);
                subQuestionMap.put(submitQuestionItem.getStructureId(), questionSubItemList);
            }
            subQuestionRightRate = subQuestionRight / subQuestionTotal;
            //5
            TbQuestionReportDetail questionReportDetail = new TbQuestionReportDetail();
            questionReportDetail.preInsert();

            questionReportDetail.setReportId(questionReport.getId());
            questionReportDetail.setTotalNum((int) subQuestionTotal);
            questionReportDetail.setDidNum((int) subQuestionDid);
            questionReportDetail.setNotDoneNum((int) subQuestionNot);
            questionReportDetail.setRightNum((int) subQuestionRight);
            questionReportDetail.setWrongNum((int) subQuestionWrong);
            questionReportDetail.setRightRate(subQuestionRightRate);

            questionReportDetail.setStructureId(submitQuestionItem.getStructureId());
            questionReportDetail.setStructureAlias(submitQuestionItem.getStructureAlias());
            questionReportDetail.setSort(i + 1);
            questionReportDetailList.add(questionReportDetail);
        }


        //根据报告名称合并报告详情
        questionReportDetailList = mergeReportDetailByName(questionReportDetailList);

        int rightAllNum = questionReportDetailList.stream().map(TbQuestionReportDetail::getRightNum).reduce((a, b) -> a + b).get();
        int totalAllNum = questionReportDetailList.stream().map(TbQuestionReportDetail::getTotalNum).reduce((a, b) -> a + b).get();
        questionReport.setRightNum(rightAllNum);
        questionReport.setWrongNum(totalAllNum);
        double rightRate = formatDouble1((double) rightNum / (double) allNum);
        questionReport.setRightRate(rightRate);
        paperReport.setPaperRightRate(rightRate);
        questionReportMapper.insert(questionReport);
        questionReportDetailMapper.insertList(questionReportDetailList);
        questionReportRecordMapper.insertList(questionReportRecordList);
        questionRecordMapper.insertList(questionRecordList);
        questionRecordDetailMapper.insertList(questionRecordDetailList);

        //插入错题本大题
        if (questionWrongBooks.size() > 0) {
            questionWrongBookMapper.insertList(questionWrongBooks);
        }
        //更改大题插入时间
        if (updateWrongBookIds.size() > 0) {
            questionWrongBookMapper.batchUpdate(updateWrongBookIds, new Date());
        }
        //插入错题本小题
        if (questionWrongBookDetailList.size() > 0) {
            questionWrongBookDetailMapper.insertList(questionWrongBookDetailList);
        }

        //拼装返回数据
        questionReportDetailList.forEach(questionReportDetail -> {
            StructureItem structureItem = new StructureItem();
            structureItem.setId(questionReportDetail.getStructureId());
            structureItem.setName(questionReportDetail.getStructureAlias());
            structureItem.setDidNum(questionReportDetail.getDidNum());
            structureItem.setRightRate(formatDouble1(questionReportDetail.getRightRate()));
            structureItem.setRightNum(questionReportDetail.getRightNum());
            structureItem.setQuestionList(subQuestionMap.get(questionReportDetail.getStructureId()));
            structureItem.setSort(paperStructureMap.get(questionReportDetail.getStructureId()));
            structureList.add(structureItem);
        });
        structureList.sort(Comparator.comparing(StructureItem::getSort));
        paperReport.setStructureList(structureList);
        return ResponseEntity.ok(paperReport);
    }

    /**
     * 填充错题本列表
     *
     * @param paperId        试卷ID
     * @param authEntity     用户登录信息
     * @param paperStructure 试卷结构信息
     * @param questionId     问题ID
     * @param sort           序号
     * @return
     */
    private TbQuestionWrongBook fillTbQuestionWrongBook(String paperId, AuthEntity authEntity, TbPaperStructure paperStructure, String questionId, int sort) {
        TbQuestionWrongBook questionWrongBook = new TbQuestionWrongBook();
        questionWrongBook.preInsert();
        questionWrongBook.setType(PaperCatalogType.caption);
        questionWrongBook.setSort(sort);
        questionWrongBook.setSectionCode(authEntity.getSectionCode());
        questionWrongBook.setStructureId(paperStructure.getId());
        questionWrongBook.setStructureAlias(paperStructure.getAlias());
        questionWrongBook.setPaperId(paperId);
        questionWrongBook.setQuestionId(questionId);
        questionWrongBook.setUserId(authEntity.getUserId());
        return questionWrongBook;
    }

    // 加入错题的小题表
    private TbQuestionWrongBookDetail fillTbQuestionWrongBookDetail(String structureId, String structureAlias, SubmitPaper submitPaper, AuthEntity authEntity, Map<String, String> questionWrongBookMap, SubmitQuestionItem submitQuestionItem, int j, SubmitQuestionSubItem submitQuestionSubItem, TbQuestionRecordDetail questionRecordDetail) {
        // 加入错题的小题表
        TbQuestionWrongBookDetail questionWrongBookDetail = new TbQuestionWrongBookDetail();
        questionWrongBookDetail.preInsert();
        questionWrongBookDetail.setSort(j);
        questionWrongBookDetail.setQuestionItemId(submitQuestionSubItem.getId());
        questionWrongBookDetail.setRecordDetailsId(questionRecordDetail.getId());
        questionWrongBookDetail.setUserId(authEntity.getUserId());
        questionWrongBookDetail.setWrongBookId(questionWrongBookMap.get(submitQuestionItem.getId()));
        questionWrongBookDetail.setQuestionId(submitQuestionItem.getId());
        questionWrongBookDetail.setStructureId(structureId);
        questionWrongBookDetail.setStructureAlias(structureAlias);
//        questionWrongBookDetail.setStructureId(submitQuestionItem.getStructureId());
//        questionWrongBookDetail.setStructureAlias(submitQuestionItem.getStructureAlias());
        questionWrongBookDetail.setPaperId(submitPaper.getPaperId());
        return questionWrongBookDetail;
    }

    //填充报表
    private TbQuestionReport fillTbQuestionReport(TbPaperStructure paperStructure, SubmitPaper submitPaper, AuthEntity authEntity, String reportId) {
        TbQuestionReport questionReport = new TbQuestionReport();
        questionReport.preInsert();
        questionReport.setId(reportId);
        //这里生成结构报告
        questionReport.setCatalogType(2);
        questionReport.setSort(0);
        questionReport.setDidNum(submitPaper.getDidNum());
        questionReport.setNotDoneNum(submitPaper.getNotDoneNum());
        questionReport.setPaperId(submitPaper.getPaperId());
        questionReport.setSectionCode(authEntity.getSectionCode());
        questionReport.setUserId(authEntity.getUserId());
        questionReport.setTotalNum(submitPaper.getTotalNum());
        questionReport.setUseTime(submitPaper.getUseTime());

        questionReport.setPaperStructureAlias(paperStructure.getAlias());
        questionReport.setPaperStructureId(submitPaper.getPaperStructureId());
        questionReport.setType(ReportType.structure);
        return questionReport;
    }

    //3 插入报告做题映射表
    private TbQuestionReportRecord fillTbQuestionReportRecord(String reportId, int i, TbQuestionRecord questionRecord) {
        TbQuestionReportRecord questionReportRecord = new TbQuestionReportRecord();
        questionReportRecord.preInsert();
        questionReportRecord.setReportId(reportId);
        //上一步的ID
        questionReportRecord.setRecordId(questionRecord.getId());
        questionReportRecord.setSort(i + 1);
        return questionReportRecord;
    }

    //2 插入做题记录表
    private TbQuestionRecord fillTbQuestionRecord(SubmitPaper submitPaper, AuthEntity authEntity, int i, SubmitQuestionItem submitQuestionItem, List<SubmitQuestionSubItem> submitQuestionSubItemList) {
        TbQuestionRecord questionRecord = new TbQuestionRecord();
        questionRecord.setType(ParperType.support);
        questionRecord.preInsert();
        questionRecord.setUserId(authEntity.getUserId());
        questionRecord.setPaperId(submitPaper.getPaperId());
        questionRecord.setSectionCode(authEntity.getSectionCode());
        questionRecord.setQuestionType(submitPaper.getPaperType());
        //这里是传递结构的第二级(长对话、短对话)
        questionRecord.setStructureId(submitPaper.getPaperStructureId());
        //放进for start
        questionRecord.setQuestionNum(submitQuestionSubItemList.size());
        questionRecord.setQuestionId(submitQuestionItem.getId());
        questionRecord.setIsFinish(submitQuestionItem.getIsFinish());
        //放进for end
        questionRecord.setSort(i + 1);
        return questionRecord;
    }


    /**
     * 根据报告名称合并报告详情
     * 这里一个报告下存在多个听力下才进行合并，现在还没这个需求
     */
    private List<TbQuestionReportDetail> mergeReportDetailByName(List<TbQuestionReportDetail> questionReportDetailList) {
        Map<String, TbQuestionReportDetail> map = new HashMap<>();
        questionReportDetailList.forEach(tbQuestionReportDetail -> {
            TbQuestionReportDetail temp = map.get(tbQuestionReportDetail.getStructureId());
            if (temp == null) {
                temp = JSON.parseObject(JSON.toJSONString(tbQuestionReportDetail), TbQuestionReportDetail.class);
            } else {
                double rightNum = temp.getRightNum() + tbQuestionReportDetail.getRightNum();
                double totalNum = temp.getTotalNum() + tbQuestionReportDetail.getTotalNum();
                temp.setDidNum(temp.getDidNum() + tbQuestionReportDetail.getDidNum());
                temp.setNotDoneNum(temp.getNotDoneNum() + tbQuestionReportDetail.getNotDoneNum());
                temp.setWrongNum(temp.getWrongNum() + tbQuestionReportDetail.getWrongNum());
                temp.setRightNum((int) rightNum);
                temp.setTotalNum((int) totalNum);
                temp.setRightRate(formatDouble1(rightNum / totalNum));

            }
            map.put(tbQuestionReportDetail.getStructureId(), temp);
        });
        return new ArrayList<TbQuestionReportDetail>(map.values());
    }

    /**
     * 保留两位小数，四舍五入的一个老土的方法
     */
    public static double formatDouble1(double d) {
        return (double) Math.round(d * 100) / 100;
    }
}
