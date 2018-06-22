package cn.sparke.base.modules.v1.fragment.bean;


import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by yan on 2016/6/29.
 * app启动所需要的参数
 */
public class StartBean extends BaseEntity {
    private StartImg startImg;
    // 是否通过审核
    private int passVerify;
    private String serviceMobile;
    public StartImg getStartImg() {
        return startImg;
    }

    public void setStartImg(StartImg startImg) {
        this.startImg = startImg;
    }

    public int getPassVerify() {
        return passVerify;
    }

    public void setPassVerify(int passVerify) {
        this.passVerify = passVerify;
    }

    public String getServiceMobile() {
        return serviceMobile;
    }

    public void setServiceMobile(String serviceMobile) {
        this.serviceMobile = serviceMobile;
    }
}
