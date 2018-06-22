package cn.sparke.base.modules.v1.popup.mapper;

import cn.sparke.base.modules.v1.popup.bean.PopUpEntity;
import cn.sparke.core.common.mybatis.base.BaseMapper;

import java.util.List;

public interface PopUpMapper extends BaseMapper<PopUpEntity>{
    int deleteByPrimaryKey(String id);

    int insert(PopUpEntity record);

    int insertSelective(PopUpEntity record);

    PopUpEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PopUpEntity record);

    int updateByPrimaryKey(PopUpEntity record);

    PopUpEntity selectByShowModuel(Byte showModule);
}