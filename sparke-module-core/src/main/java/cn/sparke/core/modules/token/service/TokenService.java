package cn.sparke.core.modules.token.service;

import cn.sparke.core.modules.cache.CacheFacade;
import cn.sparke.core.modules.token.utils.TokenUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * Created by zhangbowen on 2015/12/22.
 */
@Service
public class TokenService {

    /**
     * 处理token
     *
     * @param terminal
     * @param userId
     * @return
     */
    public String handleToken(Integer terminal, String userId) {
        if (terminal == null) {
            return null;
        }
        String token = DigestUtils.md5DigestAsHex((userId + System.currentTimeMillis()).getBytes());
        String suffix = TokenUtils.getSuffix(terminal);
        if (suffix != null) {
            CacheFacade.set(userId + suffix, token, 60 * 60 * 24 * 7);
        }
        return token;
    }

    /**
     * 删除token
     *
     * @param terminal
     * @param userId
     * @return
     */
    public void removeToken(Integer terminal, String userId) {
        if (terminal == null) {
            return;
        }
        String suffix = TokenUtils.getSuffix(terminal);
        if (suffix != null) {
            CacheFacade.delete(userId + suffix);
        }
    }
}
