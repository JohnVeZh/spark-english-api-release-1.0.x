package cn.sparke.user.modules.v1.favorities.mapper;

import cn.sparke.core.common.mybatis.base.BaseMapper;
import cn.sparke.user.modules.v1.favorities.bean.FavoriteBean;
import cn.sparke.user.modules.v1.favorities.bean.FavoriteBookBean;
import cn.sparke.user.modules.v1.favorities.bean.FavoriteNewsBean;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangbowen on 2017/7/10.
 */
public interface FavoriteMapper extends BaseMapper<FavoriteBean> {
    String existFavorite(FavoriteBean favoriteBean);

    /**
     * 取消收藏
     *
     * @param userId
     * @param favoriteBeanList
     */
    void cancelFavorite(@Param("userId") String userId, @Param("list") List<FavoriteBean> favoriteBeanList);

    /**
     * 获取收藏的资讯列表
     *
     * @param favoriteBean
     */
    Page<FavoriteNewsBean> findListByNews(FavoriteBean favoriteBean);

    /**
     * 获取收藏的图书列表
     *
     * @param favoriteBean
     */
    Page<FavoriteBookBean> findListByBook(FavoriteBean favoriteBean);
}
