package cn.sparke.order.modules.v1.weixinPay.bean;

public class QrCodeResultBean {
    private String qrCode;

    public QrCodeResultBean() {
    }

    public QrCodeResultBean(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
