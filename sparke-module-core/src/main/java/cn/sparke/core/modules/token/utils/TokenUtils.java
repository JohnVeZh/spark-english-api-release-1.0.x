package cn.sparke.core.modules.token.utils;

import cn.sparke.core.modules.token.constants.TokenConstants;

/**
 * Created by zhangbowen on 2017/7/9.
 */
public class TokenUtils {
    /**
     * 获取token后缀
     *
     * @param terminal
     * @return
     */
    public static String getSuffix(Integer terminal) {
        if (terminal != 0) {
            switch (terminal) {
                case TokenConstants.TERMINAL.ANDROID:
                case TokenConstants.TERMINAL.IOS:
                    return TokenConstants.TOKEN_SUFFIX.APP;
                case TokenConstants.TERMINAL.M:
                case TokenConstants.TERMINAL.ZHI_MI:
                    return TokenConstants.TOKEN_SUFFIX.M;
                case TokenConstants.TERMINAL.PC:
                    return TokenConstants.TOKEN_SUFFIX.PC;

            }
        }
        return null;
    }
}
