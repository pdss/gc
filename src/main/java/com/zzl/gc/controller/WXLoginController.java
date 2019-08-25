package com.zzl.gc.controller;

import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.zzl.gc.DTO.WXSessionModel;
import com.zzl.gc.VO.ResultVO;
import com.zzl.gc.service.WXService;
import com.zzl.gc.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.http.HttpClient;

/**
 * @Author: luotao
 * @CreateTime: 2019-08-25 21:39
 * @Description:
 */
@RestController
public class WXLoginController {
    @Autowired
    WXService wxService;
    @GetMapping("/wxLogin")
    public ResultVO wxLogin(@RequestParam("code")String code) throws HttpProcessException {
        WXSessionModel model = wxService.getWxSession(code);
        return ResultVOUtil.success();
    }
}
