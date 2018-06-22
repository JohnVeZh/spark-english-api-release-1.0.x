package cn.sparke.support.modules.v1.exam.bean.report.vo;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/12 10:48
 */
public class DetailStructure {
    private String id;
    private String name;
    private int didNum;
    private double rightRate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDidNum() {
        return didNum;
    }

    public void setDidNum(int didNum) {
        this.didNum = didNum;
    }

    public double getRightRate() {
        return rightRate;
    }

    public void setRightRate(double rightRate) {
        this.rightRate = rightRate;
    }
}
