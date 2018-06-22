package cn.sparke.base.modules.v1.popup.service;

import cn.sparke.base.modules.v1.popup.bean.PopUpEntity;
import cn.sparke.base.modules.v1.popup.mapper.PopUpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ning
 *
 */
@Service
public class PopUpService {
    @Autowired
    private PopUpMapper popUpMapper;
    public PopUpEntity selectByshowModule(Byte showModule){
        return popUpMapper.selectByShowModuel(showModule);
    }
}
