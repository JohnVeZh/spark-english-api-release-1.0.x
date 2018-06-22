package cn.sparke.community.modules.v1.activity.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by yangye on 2017/7/11.
 * 必须要有get set 方法，不然无法注入
 */
@ConfigurationProperties(prefix = "project.webPath")
@Component
public class CommunityActivityProperties {
    public String web_path_img;     // 服务器图片路径

    public String getWeb_path_img() {
        return web_path_img;
    }

    public void setWeb_path_img(String web_path_img) {
        this.web_path_img = web_path_img;
    }
}
