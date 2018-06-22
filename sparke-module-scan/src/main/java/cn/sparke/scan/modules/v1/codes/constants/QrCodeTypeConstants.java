package cn.sparke.scan.modules.v1.codes.constants;

/**
 * Created by wanghaiguang on 2017/7/13.
 * 二维码类型
 */

public interface QrCodeTypeConstants {

    int EXAMINATION_ACOUSTIC = 1; //考场原音
    int FRAGMENTAION = 2; //碎片
    int SIMPLE_VIDEO = 3; //简视频
    int SIMPLE_WRITING = 4; //简写作
    int COMMON_WORD = 5; //常用词汇
    int CAPTION_LISTENING = 6; //字幕听力
    int WRITING_TRANSLATION_READING = 7; //写作翻译阅读
    int TRUE_EXAMINATION = 8; //配套专区全真考场
    int TEACHER_VIDEO = 9; //配套专区名师视频
    int WORD = 10; //:配套专区常用词汇
    int CAPTION = 11; //配套专区字幕听力
    int GIFT_COURSE=12; //大礼包扫码看课
    int GIFT_RECORD_PAPER=13; //大礼包扫码录题


}
