package cn.sparke.special.modules.v1.question.mapper;

import cn.sparke.core.common.bean.BaseEntity;
import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.special.modules.v1.question.bean.QuestionBean;
import cn.sparke.special.modules.v1.question.bean.WrongBookBean;
import cn.sparke.special.modules.v1.question.bean.WrongBookDetailBean;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/7/13.
 */
public interface WrongBookMapper extends BaseMapper<WrongBookBean> {
    Page<WrongBookBean> findBookList(WrongBookBean bookBean);
    QuestionBean getWrongBooksDetail(@Param("wrongBookId") String wrongBookId,@Param("userId") String userId,@Param("type") int type);
    int getWrongCount(@Param("userId") String userId,@Param("sectionCode") int sectionCode);
    WrongBookDetailBean getDetailByQuestionId(@Param("userId") String userId,@Param("questionId") String questionId,@Param("structureId") String structureId );
    int deleteWrongBook(@Param("userId") String userId,@Param("questionId") String questionId);
    int deleteWrongBookDetail(@Param("userId") String userId,@Param("itemId") String itemId);
    int insert(WrongBookBean wrongBookBean);
    int insertList(@Param("bookList") List<WrongBookBean> bookList);
    int insertDetail(WrongBookDetailBean wrongBookDetailBean);
    int insertDetailList(@Param("bookDetailList") List<WrongBookDetailBean> bookDetailList);
    WrongBookBean getByQuestionId(@Param("userId") String userId,@Param("questionId") String questionId,@Param("structureId") String structureId);
    int updateList(@Param("bookList") List<WrongBookBean> bookList);
}
