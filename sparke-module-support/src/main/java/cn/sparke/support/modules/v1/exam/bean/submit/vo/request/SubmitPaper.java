package cn.sparke.support.modules.v1.exam.bean.submit.vo.request;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/11 19:55
 */
public class SubmitPaper {
    @NotBlank(message = "请提交试卷ID")
    private String paperId;
    //1听力 2阅读
    @NotNull(message = "请提交试卷类型")
    private Integer paperType;

    @NotBlank(message = "请提交试卷结构ID")
    private String paperStructureId;

    @NotNull(message = "请提交使用时间")
    private Integer useTime;

    @NotNull(message = "请提交总题目数")
    private Integer totalNum;

    @NotNull(message = "请提交已做题目数")
    private Integer didNum;

    @NotNull(message = "请提交未做题目数")
    private Integer notDoneNum;

    @Valid
    @NotNull(message = "请提交做题详情")
    @Size(min = 1, message = "请提交做题详情")
    private List<SubmitQuestionItem> questionList;

    public int getPaperType() {
        return paperType;
    }

    public void setPaperType(int paperType) {
        this.paperType = paperType;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getPaperStructureId() {
        return paperStructureId;
    }

    public void setPaperStructureId(String paperStructureId) {
        this.paperStructureId = paperStructureId;
    }

    public Integer getUseTime() {
        return useTime;
    }

    public void setUseTime(Integer useTime) {
        this.useTime = useTime;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getDidNum() {
        return didNum;
    }

    public void setDidNum(Integer didNum) {
        this.didNum = didNum;
    }

    public Integer getNotDoneNum() {
        return notDoneNum;
    }

    public void setNotDoneNum(Integer notDoneNum) {
        this.notDoneNum = notDoneNum;
    }

    public List<SubmitQuestionItem> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<SubmitQuestionItem> questionList) {
        this.questionList = questionList;
    }
}
