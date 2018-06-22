package cn.sparke.easy.modules.v1.papers.bean;

import cn.sparke.core.common.bean.BaseEntity;

import java.util.List;

/**
 * Created by wanghaiguang on 2017/7/28.
 */
public class ItemBean extends BaseEntity {

    private String content; //小题内容
    private String analysis; //解析

    private List<OptionBean> optionList;




    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public List<OptionBean> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<OptionBean> optionList) {
        this.optionList = optionList;
    }
}
