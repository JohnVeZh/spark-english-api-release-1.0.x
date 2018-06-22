package cn.sparke.user.modules.v1.favorities.service;

import cn.sparke.core.common.mybatis.bean.PagerBean;
import cn.sparke.core.common.mybatis.utils.PagerUtils;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.user.modules.v1.favorities.bean.FavoriteBean;
import cn.sparke.user.modules.v1.favorities.constants.FavoriteConstants;
import cn.sparke.user.modules.v1.favorities.mapper.FavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangbowen on 2017/7/10.
 */
@Service
public class FavoriteService {
    @Autowired
    private FavoriteMapper favoriteMapper;

    /**
     * @param favoriteBean
     */
    public void save(FavoriteBean favoriteBean) {
        favoriteBean.setUserId(ContextUtils.getCurAuth().getUserId());
        //判断是否存在该收藏，存在不收藏
        if (favoriteMapper.existFavorite(favoriteBean) != null) {
            return;
        }
        favoriteBean.preInsert();
        favoriteMapper.insert(favoriteBean);
    }

    /**
     * 取消收藏
     *
     * @param favoriteBeanList
     */
    public void delete(List<FavoriteBean> favoriteBeanList) {
        if (favoriteBeanList == null || favoriteBeanList.size() == 0) {
            return;
        }
        String userId = ContextUtils.getCurAuth().getUserId();
        favoriteMapper.cancelFavorite(userId, favoriteBeanList);
    }

    /**
     * 收藏列表
     *
     * @param favoriteBean
     * @return
     */
    public PagerBean findList(FavoriteBean favoriteBean) {
        String userId = ContextUtils.getCurAuth().getUserId();
        favoriteBean.setUserId(userId);
        switch (favoriteBean.getType()) {
            case FavoriteConstants.TYPE_NEWS:
                return PagerUtils.getPager(favoriteMapper.findListByNews(favoriteBean));
            case FavoriteConstants.TYPE_BOOK:
                return PagerUtils.getPager(favoriteMapper.findListByBook(favoriteBean));
        }
        return null;
    }
}
