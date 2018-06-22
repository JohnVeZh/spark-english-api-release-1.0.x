package cn.sparke.gift.modules.v1.estimate.bean.vo;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/8/21 11:31
 */
public class SubmitAnswerVo {

    @Valid
    @NotNull(message = "请提交听力答案信息")
    @Size(min = 25, max = 25, message = "请提交正确数量的听力答案信息")
    private List<ObjectiveAnswerVo> listenAnswers;

    @Valid
    @NotNull(message = "请提交阅读答案信息")
    @Size(min = 30, max = 30, message = "请提交正确数量的阅读答案信息")
    private List<ObjectiveAnswerVo> readAnswers;

    @Valid
    @NotNull(message = "请提交翻译答案信息")
    private SubjectiveAnswerVo translationAnswers;

    @Valid
    @NotNull(message = "请提交写作答案信息")
    private SubjectiveAnswerVo writingAnswers;

    public List<ObjectiveAnswerVo> getListenAnswers() {
        return listenAnswers;
    }

    public void setListenAnswers(List<ObjectiveAnswerVo> listenAnswers) {
        this.listenAnswers = listenAnswers;
    }

    public List<ObjectiveAnswerVo> getReadAnswers() {
        return readAnswers;
    }

    public void setReadAnswers(List<ObjectiveAnswerVo> readAnswers) {
        this.readAnswers = readAnswers;
    }

    public SubjectiveAnswerVo getTranslationAnswers() {
        return translationAnswers;
    }

    public void setTranslationAnswers(SubjectiveAnswerVo translationAnswers) {
        this.translationAnswers = translationAnswers;
    }

    public SubjectiveAnswerVo getWritingAnswers() {
        return writingAnswers;
    }

    public void setWritingAnswers(SubjectiveAnswerVo writingAnswers) {
        this.writingAnswers = writingAnswers;
    }
}
