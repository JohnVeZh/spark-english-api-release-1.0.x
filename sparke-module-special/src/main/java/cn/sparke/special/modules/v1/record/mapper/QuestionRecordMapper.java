package cn.sparke.special.modules.v1.record.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.special.modules.v1.record.bean.QuestionRecordBean;
import cn.sparke.special.modules.v1.record.bean.QuestionRecordDetailBean;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */
public interface QuestionRecordMapper extends BaseMapper<QuestionRecordBean>{
    int deleteRecordAndDetail(QuestionRecordBean recordBean);
    int deleteRecordAndDetailList(@Param("recordList") List<QuestionRecordBean> recordList);
    int insertRecord(QuestionRecordBean recordBean);
    int insertList(@Param("recordList") List<QuestionRecordBean> recordList);
    int insertRecordDetail(QuestionRecordDetailBean detailBean);
    int insertRecordDetailList(@Param("detailList") List<QuestionRecordDetailBean> detailList);
    Page<QuestionRecordBean> findRecordList(QuestionRecordBean recordBean);
    int getRecordCount (@Param("sectionCode") int sectionCode,@Param("userId") String userId);
}
