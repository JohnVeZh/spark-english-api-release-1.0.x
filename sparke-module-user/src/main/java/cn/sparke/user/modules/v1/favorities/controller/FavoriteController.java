package cn.sparke.user.modules.v1.favorities.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.user.modules.v1.favorities.bean.FavoriteBean;
import cn.sparke.user.modules.v1.favorities.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhangbowen on 2017/7/10.
 */
@RestController
@RequestMapping("/${version}/favorites")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    /**
     * 收藏
     *
     * @param favoriteBean
     * @return
     */
    @PostMapping
    @LoginAnnot
    public ResponseEntity save(@RequestBody @Validated FavoriteBean favoriteBean) {
        favoriteService.save(favoriteBean);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 取消收藏
     *
     * @param favoriteBeanList
     * @return
     */
    @DeleteMapping
    @LoginAnnot
    public ResponseEntity cancel(@RequestBody @Validated List<FavoriteBean> favoriteBeanList) {
        favoriteService.delete(favoriteBeanList);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * 收藏列表
     *
     * @param type
     * @param start
     * @return
     */
    @GetMapping("/{type}")
    @LoginAnnot
    public ResponseEntity list(@PathVariable Integer type, @RequestParam Integer start) {
        FavoriteBean favoriteBean = new FavoriteBean();
        favoriteBean.setType(type);
        favoriteBean.setStart(start);
        return ResponseEntity.ok(favoriteService.findList(favoriteBean));
    }
}