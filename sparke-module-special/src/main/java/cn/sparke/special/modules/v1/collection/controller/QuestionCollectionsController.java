package cn.sparke.special.modules.v1.collection.controller;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.constants.PageConstants;
import cn.sparke.core.common.mybatis.utils.PagerUtils;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.special.modules.v1.collection.bean.QuestionCollectionBean;
import cn.sparke.special.modules.v1.collection.mapper.QuestionCollectionMapper;
import cn.sparke.special.modules.v1.collection.service.QuestionCollectionService;
import cn.sparke.special.modules.v1.question.bean.QuestionBean;
import cn.sparke.special.modules.v1.question.bean.QuestionItemBean;
import cn.sparke.special.modules.v1.question.mapper.QuestionItemMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/7/14.
 */
@RestController
@RequestMapping("/${version}/collections")
public class QuestionCollectionsController {
    @Autowired
    QuestionCollectionMapper mapper;
    @Autowired
    QuestionCollectionService service;
    @Autowired
    QuestionItemMapper itemMapper;

    @PostMapping
    @LoginAnnot
    public ResponseEntity insert(@RequestBody QuestionCollectionBean collectionsBean) {
        String userId = ContextUtils.getCurAuth().getUserId();
        collectionsBean.setUserId(userId);
        service.insert(collectionsBean);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{contentType}/{contentId}")
    @LoginAnnot
    public ResponseEntity delete(@PathVariable("contentType") int contentType, @PathVariable("contentId") String contentId) {
        String userId = ContextUtils.getCurAuth().getUserId();
        if (contentType == 1 || contentType == 2) {
            QuestionItemBean item = new QuestionItemBean();
            item.setId(contentId);
            item = itemMapper.getItem(item);
            if (item != null) {
                int count = mapper.getDetailCountByQuestionId(userId, item.getQuestionId());
                if (count > 1) {
                    mapper.deleteDetail(userId, contentId);
                } else {
                    mapper.delete(userId, item.getQuestionId());
                    mapper.deleteDetail(userId, contentId);
                }
            }
        } else if (contentType == 3 || contentType == 4) {
            mapper.delete(userId, contentId);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    @LoginAnnot
    public ResponseEntity findList(@RequestParam("start") int start, Integer rows, @RequestParam("type") int type) {
        AuthEntity entity = ContextUtils.getCurAuth();
        QuestionCollectionBean collectionBean = new QuestionCollectionBean();
        collectionBean.setStart(start);
        collectionBean.setRows(PageConstants.PAGE_NUM);
        if (rows != null) {
            collectionBean.setRows(rows);
        }
        collectionBean.setUserId(entity.getUserId());
        collectionBean.setType(4);
        collectionBean.setContentType(type);
        collectionBean.setSectionCode(entity.getSectionCode());
        Page<QuestionCollectionBean> collectionBeans = mapper.findList(collectionBean);
        return ResponseEntity.ok(PagerUtils.getPager(collectionBeans));
    }

    @GetMapping("/{collectionId}")
    @LoginAnnot
    public ResponseEntity getCollection(@PathVariable("collectionId") String collectionId, @RequestParam("type") int type) {
        String userId = ContextUtils.getCurAuth().getUserId();
        QuestionBean questionBean = mapper.getCollection(userId, collectionId, type);
        return ResponseEntity.ok(questionBean);
    }
}
