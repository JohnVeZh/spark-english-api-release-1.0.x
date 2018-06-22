package cn.sparke.special.modules.v1.question.controller;

import cn.sparke.core.common.bean.AuthEntity;
import cn.sparke.core.common.constants.PageConstants;
import cn.sparke.core.common.mybatis.utils.PagerUtils;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.special.modules.v1.question.bean.QuestionBean;
import cn.sparke.special.modules.v1.question.bean.WrongBookBean;
import cn.sparke.special.modules.v1.question.mapper.WrongBookMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/7/13.
 */
@RestController
@RequestMapping("/${version}/wrong_books")
public class WrongBookController {
    @Autowired
    WrongBookMapper wrongBookMapper;
    @GetMapping()
    public ResponseEntity findBookList(@RequestParam("start") int start,@RequestParam("type") int type){
        AuthEntity entity = ContextUtils.getCurAuth();
        WrongBookBean bookBean = new WrongBookBean();
        bookBean.setStart(start);
        bookBean.setRows(PageConstants.PAGE_NUM);
        bookBean.setType(type);
        bookBean.setUserId(entity.getUserId());
        bookBean.setSectionCode(entity.getSectionCode());
        Page<WrongBookBean> page = wrongBookMapper.findBookList(bookBean);
        return ResponseEntity.ok(PagerUtils.getPager(page));
    }
    @GetMapping("/{wrongBookId}")
    public ResponseEntity findBook(@PathVariable("wrongBookId")String wrongBookId,@RequestParam("type") int type){
        String userId = ContextUtils.getCurAuth().getUserId();
        QuestionBean questionBean  = wrongBookMapper.getWrongBooksDetail(wrongBookId,userId,type);
        return ResponseEntity.ok(questionBean);
    }
}
