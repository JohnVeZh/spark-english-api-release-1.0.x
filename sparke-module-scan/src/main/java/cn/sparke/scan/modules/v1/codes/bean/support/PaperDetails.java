package cn.sparke.scan.modules.v1.codes.bean.support;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 13:33
 */
public class PaperDetails {

    private String id;
    private String name;
    private PaperCaptionListening captionListening;
    private PaperVideo video;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PaperCaptionListening getCaptionListening() {
        return captionListening;
    }

    public void setCaptionListening(PaperCaptionListening captionListening) {
        this.captionListening = captionListening;
    }

    public PaperVideo getVideo() {
        return video;
    }

    public void setVideo(PaperVideo video) {
        this.video = video;
    }
}
