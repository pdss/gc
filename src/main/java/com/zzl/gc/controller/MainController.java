package com.zzl.gc.controller;

import com.zzl.gc.entity.Person;
import com.zzl.gc.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author luotao
 * @Package com.zzl.gc.controller
 * @date 2019/8/23 11:21
 */
@RestController
public class MainController {
    @Autowired
    PersonMapper personMapper;
    @GetMapping("/")
    public List<Person> test(){
        return personMapper.getAll();
    }
}
