package cn.sparke.user.modules.v1.share.service;

import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.user.modules.v1.share.bean.ShareBean;
import cn.sparke.user.modules.v1.share.bean.ShareContent;
import cn.sparke.user.modules.v1.share.mapper.ShareMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by zhangbowen on 2017/7/11.
 */
@Service
public class ShareService {
    @Autowired
    private ShareMapper shareMapper;

    /**
     * 分享
     *
     * @param shareContent
     * @return
     */
    public ShareBean share(ShareContent shareContent) {
        if (shareContent == null || StringUtils.isEmpty(shareContent.getContent())) {
            return new ShareBean();
        }
        ShareBean shareBean = new ShareBean();
        shareBean.setUserId(ContextUtils.getCurAuth().getUserId());
        shareBean.setContent(shareContent.getContent());
        shareBean.preInsert();
        shareMapper.insert(shareBean);
        return shareBean;
    }

    public ShareBean getById(String id) {
        return shareMapper.getById(id);
    }
}
