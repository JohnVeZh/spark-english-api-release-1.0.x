package cn.sparke.gift.modules.v1.estimate.service;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.gift.modules.v1.estimate.bean.vo.EstimateCatalog;
import cn.sparke.gift.modules.v1.estimate.mapper.EstimateMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 估分Service
 * @author houxusen
 */
@Service
public class EstimateService {

    @Resource
    private EstimateMapper estimateMapper;

    /**
     * 查询估分目录列表
     * @return
     */
    public List<EstimateCatalog> queryEstimateCatalog(){
        AuthEntity curAuth = ContextUtils.getCurAuth();
        return estimateMapper.queryEstimateCatalog(curAuth.getUserId(),curAuth.getSectionCode());
    }
}
