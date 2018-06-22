package cn.sparke.core.modules.captcha.util;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * Created by zhangbowen on 2017/6/5.
 */
public class CaptchaUtil {
    public static String imgToByte(RenderedImage img) {
        final ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ImageIO.write(img, "png", os);
            return Base64.getEncoder().encodeToString(os.toByteArray());
        } catch (final IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

}
