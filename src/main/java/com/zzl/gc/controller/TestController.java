package com.zzl.gc.controller;

import com.zzl.gc.VO.ResultVO;
import com.zzl.gc.service.TestService;
import com.zzl.gc.util.RedisUtil;
import com.zzl.gc.util.ResultVOUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luotao
 * @Package com.zzl.gc.controller
 * @date 2019/8/26 10:02
 * @describe 测试案例
 */
@RestController
public class TestController {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    TestService testService;
    @GetMapping("/")
    @ApiOperation(value = "测试案例",notes = "得到一些数据...")
    public ResultVO test(){
        /**
         * @author luotao
         * @date 2019/8/26 11:31
         * @describe 测试案例
         */
        redisUtil.set("abc","1");
        return  ResultVOUtil.success(testService.getAll());
    }
}
