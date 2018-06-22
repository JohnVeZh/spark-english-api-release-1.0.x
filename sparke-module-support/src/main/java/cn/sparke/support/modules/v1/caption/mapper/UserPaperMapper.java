package cn.sparke.support.modules.v1.caption.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.support.modules.v1.caption.bean.po.TbUserPaper;
import cn.sparke.support.modules.v1.caption.bean.vo.PaperCatalog;
import cn.sparke.support.modules.v1.caption.bean.vo.PaperDetails;
import cn.sparke.support.modules.v1.caption.bean.vo.PaperUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 21:28
 */
@Mapper
public interface UserPaperMapper extends BaseMapper<TbUserPaper> {
    /**
     * 通过用户ID 学段Code获取用户选择的试卷
     */
    List<TbUserPaper> findByUserIdAndPaperAndSectionCode(@Param("userId") String userId, @Param("sectionCode") int sectionCode);

    /**
     * 修改用户选择的订单
     */
    public int updateByPrimaryKeySelective(TbUserPaper tbUserPaper);

    /**
     * 通过学段和用户ID获取试卷信息
     */
    PaperUserInfo getPaperInfoByUserId(@Param("userId") String userId, @Param("sectionCode") int sectionCode);

    /**
     * 获取试卷的详细信息
     * 根据父试卷id获取所有的子试卷
     */
    List<PaperDetails> getPaperDetails(@Param("groupId") String groupId);
}
