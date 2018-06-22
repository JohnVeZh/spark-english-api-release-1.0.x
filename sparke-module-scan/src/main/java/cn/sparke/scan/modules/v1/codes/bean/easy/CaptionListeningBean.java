package cn.sparke.scan.modules.v1.codes.bean.easy;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * Created by wanghaiguang on 2017/7/11.
 * 字幕听力实体类
 */

public class CaptionListeningBean extends BaseEntity{

    private String paperId; //试卷id
    private String audioUrl; //音频地址
    private String subtitleUrl; //字幕文件地址

    //非数据库字段
    private String name; //试卷名称

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public String getSubtitleUrl() {
        return subtitleUrl;
    }

    public void setSubtitleUrl(String subtitleUrl) {
        this.subtitleUrl = subtitleUrl;
    }
}
