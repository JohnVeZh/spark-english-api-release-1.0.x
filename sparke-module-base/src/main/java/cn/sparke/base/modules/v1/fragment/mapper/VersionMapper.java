package cn.sparke.base.modules.v1.fragment.mapper;

import cn.sparke.base.modules.v1.fragment.bean.VersionBean;
import cn.sparke.core.common.mybatis.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zhangbowen on 2017/7/10.
 */
public interface VersionMapper extends BaseMapper<VersionBean> {
    int getPassVerify(@Param("type") int type,@Param("code") int code);
}
