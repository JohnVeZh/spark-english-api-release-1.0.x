package cn.sparke.goods.modules.v1.book.controller;

import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.goods.modules.v1.book.service.ProductBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yangye on 2017/7/11.
 */
@RestController
@RequestMapping("/${version}/books")
public class ProductBookController {

    @Autowired
    private ProductBookService bookService;

    /**
     * 获取图书分类列表
     * @param start
     * @return
     */
    @GetMapping("/types")
    public ResponseEntity getBookTypeList(@RequestParam("start") Integer start) {
        return ResponseEntity.ok(bookService.getBookTypeList(start));
    }

    /**
     * 获取热搜列表
     * @param start
     * @return
     */
    @GetMapping("/hot_search_books")
    public ResponseEntity getHotSearchBooksList(@RequestParam("start") Integer start, @RequestParam(value = "searchTitle", required = false) String searchTitle) {
        return ResponseEntity.ok(bookService.getHotSearchBooksList(start, searchTitle));
    }

    /**
     * 获取图书列表
     * @param start
     * @param typeId
     * @return
     */
    @GetMapping
    public ResponseEntity findList(@RequestParam("start") Integer start, @RequestParam("typeId") String typeId) {
        return ResponseEntity.ok(bookService.findList(start, typeId));
    }

    /**
     * 获取图书详情
     * @param bookId
     * @return
     */
    @GetMapping("/{bookId}")
    public ResponseEntity getById(@PathVariable("bookId") String bookId) {
        return ResponseEntity.ok(bookService.getById(bookId, ContextUtils.getCurAuth().getUserId()));
    }


}
