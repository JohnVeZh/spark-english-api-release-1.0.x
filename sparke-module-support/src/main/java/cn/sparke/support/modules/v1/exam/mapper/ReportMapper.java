package cn.sparke.support.modules.v1.exam.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.support.modules.v1.exam.bean.report.vo.DetailReport;
import cn.sparke.support.modules.v1.exam.bean.report.vo.Report;
import cn.sparke.support.modules.v1.exam.bean.report.vo.ReportListItem;
import cn.sparke.support.modules.v1.exam.bean.report.vo.ReportStructure;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/12 10:21
 */
@Mapper
public interface ReportMapper extends BaseMapper<Report> {
    Page<ReportListItem> findByUserIdAndSectionCode(@Param("userId") String userId, @Param("sectionCode") int sectionCode);

    @Deprecated
    DetailReport getReportDetail(@Param("reportId") String reportId);

    List<ReportStructure> findReportByReportId(@Param("reportId") String reportId);

    List<ReportStructure> findReportByUserIdAndSectionCode(@Param("userId") String userId, @Param("sectionCode") int sectionCode);

    Report getReportVoById(@Param("reportId") String reportId);
}
