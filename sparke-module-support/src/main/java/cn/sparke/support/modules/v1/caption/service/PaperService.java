package cn.sparke.support.modules.v1.caption.service;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.support.modules.v1.caption.bean.po.TbUserPaper;
import cn.sparke.support.modules.v1.caption.bean.vo.PaperUserInfo;
import cn.sparke.support.modules.v1.caption.constants.PaperCatalogType;
import cn.sparke.support.modules.v1.caption.mapper.PaperMapper;
import cn.sparke.support.modules.v1.caption.mapper.UserPaperMapper;
import cn.sparke.support.modules.v1.word.bean.vo.Words;
import cn.sparke.support.modules.v1.word.mapper.ITbWordMapper;
import cn.sparke.support.modules.v1.word.mapper.TbNewWordMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ToQuery
 * @version V1.0
 * @date 2017/7/10 21:26
 */
@Service
public class PaperService {

    @Resource
    private PaperMapper paperMapper;

    @Resource
    private ITbWordMapper wordMapper;

    @Resource
    private UserPaperMapper userPaperMapper;

    @Resource
    private TbNewWordMapper newWordMapper;

    //获取试卷目录
    public List<?> findPagerCatalog() {
        int sectionCode = ContextUtils.getCurAuth().getSectionCode();
        return paperMapper.findPaperGroupCatalog(PaperCatalogType.caption, sectionCode);
    }


    //添加试卷
    public ResponseEntity addPaper(String groupId) {
        AuthEntity authEntity = ContextUtils.getCurAuth();
        List<TbUserPaper> list = userPaperMapper.findByUserIdAndPaperAndSectionCode(authEntity.getUserId(), authEntity.getSectionCode());
        list = list == null ? new ArrayList<>() : list;
        if (list.size() > 0) {
            TbUserPaper tbUserPaper = list.get(0);
            tbUserPaper.setGroupId(groupId);
            userPaperMapper.updateByPrimaryKeySelective(tbUserPaper);
        } else {
            TbUserPaper userPaper = new TbUserPaper(groupId, authEntity.getSectionCode(), authEntity.getUserId());
            userPaper.preInsert();
            userPaperMapper.insert(userPaper);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    //    获取用户选择的试卷
    public ResponseEntity getUserPaper() {
        AuthEntity authEntity = ContextUtils.getCurAuth();
        PaperUserInfo paperUserInfo = userPaperMapper.getPaperInfoByUserId(authEntity.getUserId(), authEntity.getSectionCode());
        return ResponseEntity.ok(paperUserInfo);
    }

    public ResponseEntity getPaperDetails(String paperId) {
        return ResponseEntity.ok(userPaperMapper.getPaperDetails(paperId));
    }

    public ResponseEntity getWord(String word) {
        AuthEntity authEntity = ContextUtils.getCurAuth();
        List<Words> wordsList = wordMapper.findTakeWordByWord(word,authEntity.getUserId());
        if (wordsList != null && wordsList.size() > 0) {
            return ResponseEntity.ok(wordsList.get(0));
        } else {
            return ResponseEntity.ok(null);
        }
    }
}
