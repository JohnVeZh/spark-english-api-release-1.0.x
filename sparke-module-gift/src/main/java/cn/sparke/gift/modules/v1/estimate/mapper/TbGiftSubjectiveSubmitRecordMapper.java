package cn.sparke.gift.modules.v1.estimate.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.gift.modules.v1.estimate.bean.po.TbGiftSubjectiveSubmitRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/8/21 13:35
 */
@Mapper
public interface TbGiftSubjectiveSubmitRecordMapper extends BaseMapper<TbGiftSubjectiveSubmitRecordMapper> {
    TbGiftSubjectiveSubmitRecord getByUserIdAndSectionCode(@Param("userId") String userId,@Param("sectionCode")  int sectionCode);


    int updatePreUse(@Param("userId") String userId,@Param("sectionCode")  int sectionCode);

    int updateMidUse(@Param("userId") String userId,@Param("sectionCode")  int sectionCode);

    int updatePostUse(@Param("userId") String userId,@Param("sectionCode")  int sectionCode);
}
