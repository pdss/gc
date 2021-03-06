package com.zzl.gc.controller;

import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.zzl.gc.DTO.WXSessionModel;
import com.zzl.gc.VO.ResultVO;
import com.zzl.gc.service.WXService;
import com.zzl.gc.util.ResultVOUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luotao
 * @Package com.zzl.gc.controller
 * @date 2019/8/26 10:02
 * @describe 微信相关接口
 */
@RestController
public class WXController {
    @Autowired
    WXService wxService;
    @ApiOperation(value = "传入code获取openid",notes = "小程序用户允许登录后，使用code 换取 session_key api，将 code 换成 openid 和 session_key")
    @ApiImplicitParam(name = "code", value = "用户授权登录后回调内容时带上 ", required = true, dataType = "String")
    @GetMapping("/wxlogin")
    public ResultVO wxLogin(@RequestParam("code")String code) throws HttpProcessException {
        /**
         * @author luotao
         * @date 2019/8/26 9:47
         * @param code 前端传入的code
         * @describe 通过code获取openid和session_key
         */
        WXSessionModel model = wxService.getWxSession(code);
        return ResultVOUtil.success();
    }
}
