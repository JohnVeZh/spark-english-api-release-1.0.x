package cn.sparke.core.modules.captcha.service;

import cn.sparke.core.common.utils.Utils;
import cn.sparke.core.modules.cache.CacheFacade;
import cn.sparke.core.modules.captcha.bean.CaptchaBean;
import cn.sparke.core.modules.captcha.constants.CaptchaConstants;
import cn.sparke.core.modules.captcha.util.CaptchaUtil;
import com.github.bingoohuang.patchca.color.SingleColorFactory;
import com.github.bingoohuang.patchca.custom.ConfigurableCaptchaService;
import com.github.bingoohuang.patchca.filter.predefined.CurvesRippleFilterFactory;
import com.github.bingoohuang.patchca.service.Captcha;
import com.github.bingoohuang.patchca.word.AdaptiveRandomWordFactory;
import com.github.bingoohuang.patchca.word.RandomWordFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.awt.*;

/**
 * Created by zhangbowen on 2017/6/5.
 */
@Service
public class CaptchaService {
    private ConfigurableCaptchaService configurableCaptchaService;

    @PostConstruct
    public void init() {
        configurableCaptchaService = new ConfigurableCaptchaService();
        configurableCaptchaService.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
        configurableCaptchaService.setFilterFactory(new CurvesRippleFilterFactory(configurableCaptchaService.getColorFactory()));
        RandomWordFactory wordFactory = new AdaptiveRandomWordFactory();
        wordFactory.setMinLength(4);
        wordFactory.setMaxLength(4);
        configurableCaptchaService.setWordFactory(wordFactory);
    }

    public CaptchaBean generateCaptcha(String type) {
        Captcha captcha = configurableCaptchaService.getCaptcha();
        String captchaBase64 = CaptchaUtil.imgToByte(captcha.getImage());
        String token = Utils.uuid();
        CacheFacade.set(token + CaptchaConstants.CAPTCHA_KEY + type, captcha.getWord(), Utils.MINUTE);
        CaptchaBean captchaBean = new CaptchaBean();
        captchaBean.setCaptchaToken(token);
        captchaBean.setData(captchaBase64);
        return captchaBean;
    }

    /**
     * 验证验证码
     *
     * @param code
     * @param type
     * @return
     */
    public boolean validCode(String type, String code, String token) {
        // 校验验证码
        String cacheCode = CacheFacade.getObject(token + CaptchaConstants.CAPTCHA_KEY + type);
        if (cacheCode == null) {
            return false;
        }
        // 校验失败
        return code.equalsIgnoreCase(cacheCode);
    }

    public void removeCode(String type, String token) {
        CacheFacade.delete(token + CaptchaConstants.CAPTCHA_KEY + type);
    }
}
