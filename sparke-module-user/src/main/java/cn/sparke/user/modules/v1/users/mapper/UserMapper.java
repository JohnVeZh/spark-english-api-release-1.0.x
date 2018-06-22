package cn.sparke.user.modules.v1.users.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.user.modules.v1.users.entity.UserEntity;

/**
 * Created by zhangbowen on 2017/1/2.
 */
public interface UserMapper extends BaseMapper<UserEntity> {
    UserEntity getSmallUser(String userId);
}
