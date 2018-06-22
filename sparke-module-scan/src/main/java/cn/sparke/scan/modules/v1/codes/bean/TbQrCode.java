package cn.sparke.scan.modules.v1.codes.bean;

import cn.sparke.core.common.bean.BaseEntity;

import java.util.Date;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/17 16:29
 */
public class TbQrCode extends BaseEntity {
    /**
     * 使用场景1简系列,2配套专区
     */
    private int useScene;

    /**
     * 二维码内容
     */
    private String code;

    /**
     * 学段(配套专区会用到)
     */
    private Integer sectionCode;

    /**
     * 二维码类型（1.简系列考场原音 2.简系列碎片 3.简系列学习视频 4.简系列简写作 5.简系列词汇 6.简系列字幕听力 7.简系列写作翻译,
     * 8:配套专区全真考场,9:配套专区名师视频,10:配套专区常用词汇,11配套专区字幕听力,12大礼包扫码看课,13大礼包扫码录题)
     */
    private int type;

    /**
     * 目标类型 1列表 2详情
     */
    private int targetType;

    private String title; //二维码标题

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 备注
     */
    private String remarks;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUseScene() {
        return useScene;
    }

    public void setUseScene(int useScene) {
        this.useScene = useScene;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(Integer sectionCode) {
        this.sectionCode = sectionCode;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTargetType() {
        return targetType;
    }

    public void setTargetType(int targetType) {
        this.targetType = targetType;
    }

    @Override
    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String getRemarks() {
        return remarks;
    }

    @Override
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
