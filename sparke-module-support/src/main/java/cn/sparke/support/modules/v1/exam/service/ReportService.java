package cn.sparke.support.modules.v1.exam.service;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.support.modules.v1.exam.bean.report.vo.*;
import cn.sparke.support.modules.v1.exam.mapper.ReportMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/12 10:20
 */
@Service
public class ReportService {

    @Resource
    private ReportMapper reportMapper;

    //    获取用户的所有报告
    public Page<ReportListItem> getReportList(Integer start, Integer rows) {
        AuthEntity authEntity = ContextUtils.getCurAuth();
        //填充分页参数
        PageHelper.offsetPage(start, rows);
        return reportMapper.findByUserIdAndSectionCode(authEntity.getUserId(), authEntity.getSectionCode());
    }

    //    获取报告详细信息
    public Report getReportDetail(String reportId) {
        return reportMapper.getReportVoById(reportId);
    }

    public Report getAvgReport2() {
        AuthEntity authEntity = ContextUtils.getCurAuth();
        List<ReportStructure> reportStructureList = reportMapper.findReportByUserIdAndSectionCode(authEntity.getUserId(), authEntity.getSectionCode());
        Map<String, ReportStructure> firstMap = Maps.newHashMap();
        if (reportStructureList != null && reportStructureList.size() > 0) {
            for (ReportStructure reportStructure : reportStructureList) {
                ReportStructure item = firstMap.get(reportStructure.getName());
                if (item == null) {
                    item = reportStructure;
                    item.setChildren(mergeReportQuestionItem2ByName(item.getChildren()));
                } else {
                    List<ReportQuestionItem> reportQuestionItemList = mergeReportQuestionItem2ByName(item.getChildren(), reportStructure.getChildren());
                    item.setChildren(reportQuestionItemList);
                }
                firstMap.put(reportStructure.getName(), item);
            }
            return calculateAverage(firstMap);
        } else {
            return null;
        }
    }

    private List<ReportQuestionItem> mergeReportQuestionItem2ByName(List<ReportQuestionItem> children) {
        Map<String, ReportQuestionItem> map = Maps.newHashMap();
        for (int i = 0; i < children.size(); i++) {
            ReportQuestionItem reportQuestionItem = children.get(i);
            ReportQuestionItem temp = map.get(reportQuestionItem.getName());
            if (temp == null) {
                temp = reportQuestionItem;
            } else {
                int totalNum = temp.getTotalNum() + reportQuestionItem.getTotalNum();
                int rightNum = temp.getRightNum() + reportQuestionItem.getRightNum();
                int didNum = temp.getDidNum() + reportQuestionItem.getDidNum();
                temp.setTotalNum(totalNum);
                temp.setDidNum(didNum);
                temp.setRightNum(rightNum);
                temp.setRightRate((float) formatDouble1((double) rightNum / (double) totalNum));
            }
            map.put(reportQuestionItem.getName(), temp);
        }
        List<ReportQuestionItem> list = Lists.newArrayList();
        for (String key : map.keySet()) {
            list.add(map.get(key));
        }
        return list;
    }

    private List<ReportQuestionItem> mergeReportQuestionItem2ByName(List<ReportQuestionItem> a, List<ReportQuestionItem> b) {
        Map<String, ReportQuestionItem> map = Maps.newHashMap();
        for (ReportQuestionItem reportQuestionItem : a) {
            ReportQuestionItem value = map.get(reportQuestionItem.getName());
            if (value == null) {
                value = new ReportQuestionItem();
            } else {
                int totalNum = value.getTotalNum() + reportQuestionItem.getTotalNum();
                int rightNum = value.getRightNum() + reportQuestionItem.getRightNum();
                value.setTotalNum(totalNum);
                value.setDidNum(value.getDidNum() + reportQuestionItem.getDidNum());
                value.setRightNum(rightNum);
                value.setRightRate((float) formatDouble1((double) rightNum / (double) totalNum));
            }
            map.put(reportQuestionItem.getName(), value);
        }
        List<ReportQuestionItem> list = Lists.newArrayList();
        for (String key : map.keySet()) {
            list.add(map.get(key));
        }
        return list;
    }

    //计算整体错误lv
    private Report calculateAverage(Map<String, ReportStructure> firstMap) {
        List<ReportStructure> structureList = Lists.newArrayList();
        int rightNum = 0;
        int totalNum = 0;
        for (String key : firstMap.keySet()) {
            ReportStructure reportStructure = firstMap.get(key);
            totalNum += reportStructure.getChildren().stream().map(ReportQuestionItem::getTotalNum).reduce((a, b) -> a + b).get();
            rightNum += reportStructure.getChildren().stream().map(ReportQuestionItem::getRightNum).reduce((a, b) -> a + b).get();
            structureList.add(reportStructure);
        }
        return new Report(formatDouble1((double) rightNum / (double) totalNum), structureList);
    }

    /**
     * 保留两位小数，四舍五入的一个老土的方法
     */
    public static double formatDouble1(double d) {
        return (double) Math.round(d * 100) / 100;
    }
}
