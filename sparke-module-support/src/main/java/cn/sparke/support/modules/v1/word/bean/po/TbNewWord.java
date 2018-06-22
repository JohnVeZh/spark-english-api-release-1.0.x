package cn.sparke.support.modules.v1.word.bean.po;

import cn.sparke.core.common.bean.BaseEntity;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 11:34
 */
public class TbNewWord extends BaseEntity {
    private String userId;
    private String wordId;

    public TbNewWord() {
    }

    public TbNewWord(String userId, String wordId) {
        this.userId = userId;
        this.wordId = wordId;
        super.preInsert();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWordId() {
        return wordId;
    }

    public void setWordId(String wordId) {
        this.wordId = wordId;
    }
}
