package cn.sparke.user.modules.v1.share.bean;

public class ResultPage {
    private String url;

    public ResultPage(String url) {
        this.url = url;
    }

    public ResultPage() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
