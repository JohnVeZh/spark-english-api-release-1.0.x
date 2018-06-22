package cn.sparke.support.modules.v1.caption.bean.vo;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 13:34
 */
public class PaperCaptionListening {

    private String audioUrl;
    private Integer audioSize;
    private String subtitleUrl;
    private Integer subtitleSize;

    public Integer getAudioSize() {
        return audioSize;
    }

    public void setAudioSize(Integer audioSize) {
        this.audioSize = audioSize;
    }

    public Integer getSubtitleSize() {
        return subtitleSize;
    }

    public void setSubtitleSize(Integer subtitleSize) {
        this.subtitleSize = subtitleSize;
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
