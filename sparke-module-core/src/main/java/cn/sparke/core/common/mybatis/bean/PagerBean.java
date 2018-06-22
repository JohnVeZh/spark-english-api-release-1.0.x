package cn.sparke.core.common.mybatis.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by zhangbowen on 2016/1/25.
 */
@JsonIgnoreProperties(value = {"rows", "start"})
public class PagerBean<T> {
    private long total;
    private List<T> data;


    public PagerBean() {
    }

    public PagerBean(List<T> data, long total) {
        this.total = total;
        this.data = data;
    }

    public List getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

}
