package cn.sparke.gift.modules.v1.exercise.constant;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/7/16.
 */
public class ReportConstants {
    /**
     * 词汇能力计算（最大基数）
     */
    public static int wordUpset = 2500;
    /**
     * 分数（注意顺序）：听力、阅读、翻译、写作
     */
    public static float[] scores = new float[]{248.5f, 248.5f, 106.5f, 106.5f};
    /**
     * 翻译/写作难度对应权重（注意顺序）：简单、一般、困难
     */
    public static float[] difficultyWeight = new float[]{0.95f, 0.85f, 0.65f};
    /**
     * 分项名称（注意顺序）：听力、阅读、翻译、写作、背单词
     */
    public static String[] names = new String[]{"听力", "阅读", "翻译", "写作","词汇量"};
    /**
     * 分项类型值（注意顺序）：听力、阅读、翻译、写作、背单词
     */
    public static int[] types = new int[]{1, 2, 3,4,5};
    /**
     * 报告各分项总分 （注意顺序）：听力、阅读、翻译、写作、背单词
     */
    public static float[] realScores = new float[]{248.5f, 248.5f, 106.5f, 106.5f,100f};


}
