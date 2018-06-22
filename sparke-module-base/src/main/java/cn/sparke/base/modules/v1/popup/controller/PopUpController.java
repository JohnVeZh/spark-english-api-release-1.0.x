package cn.sparke.base.modules.v1.popup.controller;

import cn.sparke.base.modules.v1.popup.service.PopUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ning
 *
 */
@RestController
@RequestMapping("/${version}/popup")
public class PopUpController {
    @Autowired
    private PopUpService popUpService;
    @GetMapping
    public ResponseEntity popups(@RequestParam Byte showModule){
        return ResponseEntity.ok(popUpService.selectByshowModule(showModule));
    }
}
