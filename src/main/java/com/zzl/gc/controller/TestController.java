package com.zzl.gc.controller;

import com.zzl.gc.VO.ResultVO;
import com.zzl.gc.entity.Person;
import com.zzl.gc.mapper.PersonMapper;
import com.zzl.gc.util.RedisUtil;
import com.zzl.gc.util.ResultVOUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author luotao
 * @Package com.zzl.gc.controller
 * @date 2019/8/26 10:02
 * @describe 测试案例
 */
@RestController
public class TestController {
    @Autowired
    PersonMapper personMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @GetMapping("/")
    @ApiOperation(value = "测试案例",notes = "得到一些数据...")
    public ResultVO test(){
        /**
         * @author luotao
         * @date 2019/8/26 11:31
         * @describe 测试案例
         */
        return  ResultVOUtil.success(personMapper.getAll());
    }
}
