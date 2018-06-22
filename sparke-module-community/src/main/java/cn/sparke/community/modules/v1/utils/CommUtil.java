package cn.sparke.community.modules.v1.utils;

import cn.sparke.community.modules.v1.activity.constant.CommunityActivityConstants;
import org.apache.commons.lang.StringUtils;

/**
 * @author yangye    2017/7/11 9:41
 */
public class CommUtil {


    /**
     * @Title:          formatImgPath
     * @author:         yangye
     * @Description:    判断图片字段是否为空，如果不为空则添加系统路径
     * @return          返回类型
     * @throws
     */
    public static String formatImgPath(String str) {
        String imgPath = "";
        if(StringUtils.isNotBlank(str)) {
            if(str.startsWith("http")){
                imgPath = str;
            }else{
                imgPath = CommunityActivityConstants.WebPath.WEB_PATH_IMG + str;
            }
        }
        return imgPath;
    }
}
