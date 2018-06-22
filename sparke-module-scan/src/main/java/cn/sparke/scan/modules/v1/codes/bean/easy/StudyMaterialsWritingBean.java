package cn.sparke.scan.modules.v1.codes.bean.easy;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by john on 2017/7/10.
 * 写作翻译阅读实体
 */
public class StudyMaterialsWritingBean extends BaseEntity {

    private String title;//标题
    private String content;//内容
    private String qrCode;//二维码
    private Integer type;//类型

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
