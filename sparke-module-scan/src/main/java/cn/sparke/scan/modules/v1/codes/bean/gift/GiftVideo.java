package cn.sparke.scan.modules.v1.codes.bean.gift;

/**
 * Created by wanghaiguang on 2017/8/19.
 * 大礼包视频
 */
public class GiftVideo {

    private String title;//视频名称

    private String ccid; //cc视频id

    private String detail; //描述视频内容

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCcid() {
        return ccid;
    }

    public void setCcid(String ccid) {
        this.ccid = ccid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
