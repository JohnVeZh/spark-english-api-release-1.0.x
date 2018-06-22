package cn.sparke.scan.modules.v1.codes.bean;

import cn.sparke.core.common.bean.BaseEntity;
import cn.sparke.scan.modules.v1.codes.bean.easy.*;
import cn.sparke.scan.modules.v1.codes.bean.gift.GiftVideo;
import cn.sparke.scan.modules.v1.codes.bean.support.FamousTeacherVideo;
import cn.sparke.scan.modules.v1.codes.bean.support.PaperDetails;

import java.util.List;
import java.util.Map;

/**
 * Created by john on 2017/7/10.
 * 二维码实体
 */
public class CodeBean extends BaseEntity {

    private String code; //二维码内容
    //使用场景1简系列,2配套专区
    private int useScene;
    //页面跳转会用到
    //1.考场原音 2.碎片 3.简视频 4.简写作 5.常用词汇 6.字幕听力 7.写作翻译阅读
    // 8:配套专区全真考场,9:配套专区名师视频,10:配套专区常用词汇,11配套专区字幕听力
    // 12大礼包扫码看课,13大礼包扫码录题
    private Integer type;
    //学段,配到专区会用到,当扫描二维码的学段和用户当前的学段不对应时才显示
    private Integer targetSelectionCode;

    private String title; //二维码标题
    private Integer targetType; //目标类型 1列表 2详情'


    //字幕听力列表时的数据,类型为11,并且目标类型为1
    private List<PaperDetails> captionPaperList;

    //字幕听力列表时的数据,类型为11,并且目标类型为2
    private PaperDetails captionPaper;
    //名师视频详情(type类型为9,targetType类型为2)
    private FamousTeacherVideo teacherVideo;

    private Integer sectionCode;//学段类型

    private PaperCatalogeBean paperCatalogInfo; //考场原音
    private FragmentationBean fragmentInfo; //碎片
    private NetworkVideoBean videoCatalogInfo; //简视频
    private List<FragmentationBean> writingList; //简写作
    private CommonWordBean commonWord; //常用词汇
    private CaptionListeningBean captionListeningInfo; //字幕听力
    private StudyMaterialsWritingBean writingTranslation; //写作翻译阅读


    private List<GiftVideo> videoList; //大礼包扫码看课视频列表,type类型为12

    private List recordPaperList; //大礼包扫码录题列表,type类型为13,targetType=1

    private Map recordPaperInfo; //大礼包扫码录题详情,type类型为13,targetType=2

    private Map reportInfo; //报告详情

    private String reportID;

    private Integer isExistPaper; //1存在 0不存在


    public CodeBean() {
    }

    public CodeBean(Integer type, Integer targetSelectionCode) {
        this.type = type;
        this.targetSelectionCode = targetSelectionCode;
    }

    public Integer getIsExistPaper() {
        return isExistPaper;
    }

    public void setIsExistPaper(Integer isExistPaper) {
        this.isExistPaper = isExistPaper;
    }

    public CodeBean(int useScene, Integer type, Integer targetSelectionCode) {
        this.useScene = useScene;
        this.type = type;
        this.targetSelectionCode = targetSelectionCode;
    }

    public String getReportID() {
        return reportID;
    }

    public void setReportID(String reportID) {
        this.reportID = reportID;
    }

    public Map getReportInfo() {
        return reportInfo;
    }

    public void setReportInfo(Map reportInfo) {
        this.reportInfo = reportInfo;
    }

    public Map getRecordPaperInfo() {
        return recordPaperInfo;
    }

    public void setRecordPaperInfo(Map recordPaperInfo) {
        this.recordPaperInfo = recordPaperInfo;
    }

    public List getRecordPaperList() {
        return recordPaperList;
    }

    public void setRecordPaperList(List recordPaperList) {
        this.recordPaperList = recordPaperList;
    }

    public List<GiftVideo> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<GiftVideo> videoList) {
        this.videoList = videoList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(Integer sectionCode) {
        this.sectionCode = sectionCode;
    }

    public List<PaperDetails> getCaptionPaperList() {
        return captionPaperList;
    }

    public void setCaptionPaperList(List<PaperDetails> captionPaperList) {
        this.captionPaperList = captionPaperList;
    }

    public PaperDetails getCaptionPaper() {
        return captionPaper;
    }

    public void setCaptionPaper(PaperDetails captionPaper) {
        this.captionPaper = captionPaper;
    }

    public FamousTeacherVideo getTeacherVideo() {
        return teacherVideo;
    }

    public void setTeacherVideo(FamousTeacherVideo teacherVideo) {
        this.teacherVideo = teacherVideo;
    }

    public Integer getTargetSelectionCode() {
        return targetSelectionCode;
    }

    public void setTargetSelectionCode(Integer targetSelectionCode) {
        this.targetSelectionCode = targetSelectionCode;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTargetType() {
        return targetType;
    }

    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }

    public PaperCatalogeBean getPaperCatalogInfo() {
        return paperCatalogInfo;
    }

    public void setPaperCatalogInfo(PaperCatalogeBean paperCatalogInfo) {
        this.paperCatalogInfo = paperCatalogInfo;
    }

    public FragmentationBean getFragmentInfo() {
        return fragmentInfo;
    }

    public void setFragmentInfo(FragmentationBean fragmentInfo) {
        this.fragmentInfo = fragmentInfo;
    }

    public NetworkVideoBean getVideoCatalogInfo() {
        return videoCatalogInfo;
    }

    public void setVideoCatalogInfo(NetworkVideoBean videoCatalogInfo) {
        this.videoCatalogInfo = videoCatalogInfo;
    }

    public List<FragmentationBean> getWritingList() {
        return writingList;
    }

    public void setWritingList(List<FragmentationBean> writingList) {
        this.writingList = writingList;
    }

    public CommonWordBean getCommonWord() {
        return commonWord;
    }

    public void setCommonWord(CommonWordBean commonWord) {
        this.commonWord = commonWord;
    }

    public CaptionListeningBean getCaptionListeningInfo() {
        return captionListeningInfo;
    }

    public void setCaptionListeningInfo(CaptionListeningBean captionListeningInfo) {
        this.captionListeningInfo = captionListeningInfo;
    }

    public StudyMaterialsWritingBean getWritingTranslation() {
        return writingTranslation;
    }

    public void setWritingTranslation(StudyMaterialsWritingBean writingTranslation) {
        this.writingTranslation = writingTranslation;
    }
}
