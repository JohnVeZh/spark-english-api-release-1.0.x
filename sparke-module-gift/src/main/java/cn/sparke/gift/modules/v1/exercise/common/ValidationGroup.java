package cn.sparke.gift.modules.v1.exercise.common;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface ValidationGroup {
    //交卷
    public interface paperSubmit{};
    //听力阅读中途退出
    public interface quit{};
    //写作翻译做题提交
    public interface submit{};
}
