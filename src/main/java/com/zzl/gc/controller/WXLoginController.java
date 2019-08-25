package com.zzl.gc.controller;

import com.zzl.gc.VO.ResultVO;
import com.zzl.gc.util.ResultVOUtil;
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
    @GetMapping("/wxLogin")
    public ResultVO wxLogin(@RequestParam("code")String code){

        return ResultVOUtil.success();
    }
}
