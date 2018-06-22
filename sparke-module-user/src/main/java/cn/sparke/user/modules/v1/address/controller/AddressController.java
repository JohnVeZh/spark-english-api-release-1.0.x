package cn.sparke.user.modules.v1.address.controller;

import cn.sparke.core.common.bean.LoginAnnot;
import cn.sparke.core.common.utils.ContextUtils;
import cn.sparke.user.modules.v1.address.bean.AddressBean;
import cn.sparke.user.modules.v1.address.bean.UpdateAddressBean;
import cn.sparke.user.modules.v1.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhangbowen on 2017/7/11.
 */
@RestController
@RequestMapping("/${version}/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    /**
     * 列表
     *
     * @param start
     * @return
     */
    @GetMapping
    @LoginAnnot
    public ResponseEntity list(@RequestParam Integer start) {
        AddressBean addressBean = new AddressBean();
        addressBean.setStart(start);
        addressBean.setUserId(ContextUtils.getCurAuth().getUserId());
        return ResponseEntity.ok(addressService.findList(addressBean));
    }

    /**
     * 详情
     *
     * @return
     */
    @GetMapping("/{addressId}")
    @LoginAnnot
    public ResponseEntity info(@PathVariable String addressId) {
        return ResponseEntity.ok(addressService.info(addressId));
    }

    /**
     * 添加
     *
     * @param addressBean
     * @return
     */
    @PostMapping
    @LoginAnnot
    public ResponseEntity add(@RequestBody @Validated AddressBean addressBean) {
        addressBean.setUserId(ContextUtils.getCurAuth().getUserId());
        addressService.add(addressBean);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * 编辑
     *
     * @param addressBean
     * @return
     */
    @PutMapping("/{addressId}")
    @LoginAnnot
    public ResponseEntity update(@RequestBody UpdateAddressBean addressBean, @PathVariable String addressId) {
        if (addressBean != null) {
            addressBean.setId(addressId);
            addressBean.setUserId(ContextUtils.getCurAuth().getUserId());
            addressService.updateAddress(addressBean);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * 删除
     *
     * @param addressId
     * @return
     */
    @DeleteMapping("/{addressId}")
    @LoginAnnot
    public ResponseEntity delete(@PathVariable String addressId) {
        AddressBean addressBean = new AddressBean();
        addressBean.setUserId(ContextUtils.getCurAuth().getUserId());
        addressBean.setId(addressId);
        addressService.delete(addressBean);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
