package cn.sparke.special.modules.v1.collection.service;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.special.modules.v1.collection.bean.QuestionCollectionBean;
import cn.sparke.special.modules.v1.collection.bean.QuestionCollectionDetailBean;
import cn.sparke.special.modules.v1.collection.mapper.QuestionCollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/7/16.
 */
@Service
public class QuestionCollectionService {
    @Autowired
    QuestionCollectionMapper mapper;

    @Transactional
    public void insert(QuestionCollectionBean collectionBean){

        AuthEntity entity = ContextUtils.getCurAuth();
        collectionBean.setType(4);
        collectionBean.setUserId(entity.getUserId());
        collectionBean.setSectionCode(entity.getSectionCode());
        QuestionCollectionBean collBean = mapper.getCollectionInfo(entity.getUserId(),collectionBean.getQuestionId());
        QuestionCollectionDetailBean detailBean = mapper.getCollectionDetailInfo(entity.getUserId(),collectionBean.getQuestionItemId());
        if(collBean == null){
            collectionBean.preInsert();
            mapper.insert(collectionBean);
            if(detailBean == null){
                detailBean = new QuestionCollectionDetailBean();
                detailBean.setCollectionId(collectionBean.getId());
                detailBean.setContentType(collectionBean.getContentType());
                detailBean.setQuestionId(collectionBean.getQuestionId());
                detailBean.setQuestionItemId(collectionBean.getQuestionItemId());
                detailBean.setStructureId(collectionBean.getStructureId());
                detailBean.setType(collectionBean.getType());
                detailBean.setUserId(collectionBean.getUserId());
                detailBean.preInsert();
                mapper.insertDetail(detailBean);
            }
        }
        if(collBean != null && detailBean == null){
            collectionBean.setId(collBean.getId());
            collectionBean.preUpdate();
            mapper.update(collectionBean);
            detailBean = new QuestionCollectionDetailBean();
            detailBean.setCollectionId(collectionBean.getId());
            detailBean.setContentType(collectionBean.getContentType());
            detailBean.setQuestionId(collectionBean.getQuestionId());
            detailBean.setQuestionItemId(collectionBean.getQuestionItemId());
            detailBean.setStructureId(collectionBean.getStructureId());
            detailBean.setType(collectionBean.getType());
            detailBean.setUserId(collectionBean.getUserId());
            detailBean.preInsert();
            mapper.insertDetail(detailBean);
        }
    }
}
