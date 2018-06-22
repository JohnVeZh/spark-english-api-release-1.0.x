package cn.sparke.special.modules.v1.collection.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.special.modules.v1.collection.bean.QuestionCollectionBean;
import cn.sparke.special.modules.v1.collection.bean.QuestionCollectionDetailBean;
import cn.sparke.special.modules.v1.question.bean.QuestionBean;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/7/14.
 */
public interface QuestionCollectionMapper extends BaseMapper {
//    int delete(@Param("contentType") int contentType,@Param("contentId") String contentId,@Param("userId") String userId);
    QuestionBean getCollection(@Param("userId") String userId, @Param("collectionId") String collectionId, @Param("type") int contentType);
    int getCollectionCount(@Param("userId") String userId,@Param("sectionCode") int sectionCode);
    int insertDetail(QuestionCollectionDetailBean collectionDetail);
    QuestionCollectionBean getCollectionInfo(@Param("userId") String userId,@Param("questionId") String questionId);
    int update(QuestionCollectionBean collectionBean);
    QuestionCollectionDetailBean getCollectionDetailInfo(@Param("userId") String userId,@Param("itemId") String itemId);
    int updateDetail(QuestionCollectionDetailBean detailBean);
    int getDetailCountByQuestionId(@Param("userId") String userId,@Param("questionId")String questionId);
    int deleteDetail(@Param("userId")String userId,@Param("questionItemId")String questionItemId);
    int delete(@Param("userId")String userId,@Param("questionId")String questionId);
}
