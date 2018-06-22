package cn.sparke.core.common.constants;


/**
 * Created by zhangbowen on 2015/6/24.
 */
public enum StatusCode {
    SERVER_ERROR(1, "服务器正在维护"),
    VALIDATION_FAILED(2, "参数异常"),
    PASSWORD_ERROR(3, "密码错误"),
    VALIDATE_CODE_ERROR(4, "验证码错误"),
    PHONE_EXIST(5, "该手机号已经注册"),
    USER_CLOSE(6, "用户已被查封"),
    SEND_SMS_ERROR(7, "验证码发送失败"),
    USER_NOT_EXIST(8, "用户不存在"),
    PAGER_ERROR(10, "分页参数异常"),
    USER_NOT_REG(11, "用户未注册"),
    USER_DISABLED(12, "您的账号已被禁用！"),
    ALREADY_ADD_WORD(13, "已添加到错词本！"),
    ALREADY_SET_PAPER(14, "已设置过该试卷！"),
    COUPON_CODE_EXPIRED(15, "优惠码已过期"),
    COUPON_CODE_NUM_SHORTAGE(16, "优惠码可兑换次数不足"),
    NOT_FOUND_COUPON_RULE(17, "没有可兑换的优惠券"),
    COUPON_EXPIRED(18, "优惠券已过期或已被使用"),
    EXIST_GAIN_COUPON(19, "您已领取过优惠券"),
    CAN_NOT_USE_COUPON(20, "购买的商品无法使用优惠券"),
    GOODS_LESS_THAN_COUPON(21, "商品金额小于优惠券使用金额"),
    ADDRESS_ERROR(22, "收货地址错误"),
    ALREADY_BUY_NETWORK(23, "您已拥有该网课"),
    REDEEM_EXPIRED(24, "兑换码已使用或已过期"),
    ORDER_NOT_FOUND(25, "订单已支付或不存在"),
    ORDER_CAN_NOT_DELETE(25, "订单当前状态不可删除"),
    CANNOT_REFUND(26, "订单不存在或当前状态不可退单"),
    ORDER_CANNOT_EVALUATE(27, "订单不存在或当前状态不可评价"),
    CAPTCHA_ERROR(28, "图形验证码错误"),
    ORDER_PRICE_ERROR(29, "订单金额不可为0"),
    GOODS_INFO_ERROR(30, "商品信息错误"),

    ACTIVATION_CODE_NOT_EXIST(31, "激活码不存在"),
    ACTIVATION_CODE_BE_ACTIVATED(32, "激活码已被激活"),
    ACTIVATION_CODE_EXPIRED(33, "激活码已过期"),
    ACTIVATION_CODE_DUPLICATED(33, "相同学段不能重复激活"),
    GIFT_REPORT_NOT_GENERATE(34, "暂未生成学习方案"),
    GIFT_TEACHER_EVALUATE_ING(35, "老师评分中，请24小时后查看"),
    GIFT_STUDY_SCHEME_RULE_NOT_EXIST(36, "暂未配置推荐学习方案规则"),

    GIFT_ESTIMATE_FIELD_TRANSLATION_NOT_NULL(37, "请提交翻译答案信息"),
    GIFT_ESTIMATE_FIELD_WRITING_NOT_NULL(38, "请提交写作答案信息"),
    GIFT_ESTIMATE_FIELD_TRANSLATION_ONESELF_NOT_NULL(39, "请提交翻译自评信息"),
    GIFT_ESTIMATE_FIELD_WRITING_ONESELF_NOT_NULL(40, "请提交写作自评信息"),

    GIFT_ESTIMATE_PAPERID_ERROR(41, "试卷ID有误"),
    GIFT_ESTIMATE_PAPER_AREALY_REPORT(42, "该试卷已生成报告"),
    CODE_NOT_FOUND(43, "二维码不存在"),
    GIFT_NOT_ACTIVATED(44, "大礼包未激活"),
    VIDEO_NOT_FOUNT(45, "视频资源不存在"),

    ACTIVATION_CODE_NOT_BE_ACTIVATED(46,"大礼包激活码没有被激活"),
    GIFT_PAPER_NOT_FOUNT(47,"大礼包对应试卷不存在"),
	EXIST_REPORT(48, "已存在做题报告，不可重复做题！"),

    SUBMIT_PAPER_STRUCTURE(49, "提交的试卷结构有误！"),
    ;


    private int value;
    private String description;

    StatusCode(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
