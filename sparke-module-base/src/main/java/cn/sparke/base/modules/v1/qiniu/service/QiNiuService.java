package cn.sparke.base.modules.v1.qiniu.service;

import cn.sparke.base.modules.v1.qiniu.constants.QiNiuConstants;
import com.qiniu.util.Auth;
import cn.sparke.base.modules.v1.qiniu.bean.ResultTokenBean;
import cn.sparke.base.modules.v1.qiniu.constants.QiNiuProperties;
import cn.sparke.core.modules.cache.CacheFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

/**
 * Created by zhangbowen on 2017/7/8.
 */
@Service
public class QiNiuService {
    private Auth auth = null;
    @Autowired
    private QiNiuProperties qiNiuProperties;

    @PostConstruct
    public void init() {
        if (!StringUtils.isEmpty(qiNiuProperties.access_key_id) && !StringUtils.isEmpty(qiNiuProperties.access_key_secret)) {
            auth = Auth.create(qiNiuProperties.access_key_id, qiNiuProperties.access_key_secret);
        }
    }

    /**
     * 获取上传凭证
     *
     * @return
     */
    public ResultTokenBean uploadSign() {
        String cacheToken = CacheFacade.getObject(QiNiuConstants.TOKEN);
        if (cacheToken != null) {
            return new ResultTokenBean(cacheToken);
        }
        String token = auth.uploadToken(qiNiuProperties.bucket, null, 18000L, null);
        CacheFacade.set(QiNiuConstants.TOKEN, token, 18000 - 60);
        return new ResultTokenBean(token);
    }
}
