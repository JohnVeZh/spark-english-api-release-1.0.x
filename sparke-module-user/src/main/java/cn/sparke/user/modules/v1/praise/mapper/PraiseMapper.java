package cn.sparke.user.modules.v1.praise.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.user.modules.v1.praise.bean.PraiseBean;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zhangbowen on 2017/7/11.
 */
public interface PraiseMapper extends BaseMapper<PraiseBean> {
    void cancelPraise(@Param("userId") String userId, @Param("contentId") String contentId);

    PraiseBean existPraise(@Param("userId") String userId, @Param("contentId") String contentId);


    void addCommentPraiseNum(@Param("contentId") String contentId, @Param("num") int num);

    void addActivityPraiseNum(@Param("contentId") String contentId, @Param("num") int num);
}
