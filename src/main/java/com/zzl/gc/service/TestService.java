package com.zzl.gc.service;

import com.zzl.gc.entity.Person;
import com.zzl.gc.mapper.PersonMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;

import java.util.List;

/**
 * @author luotao
 * @Package com.zzl.gc.service
 * @date 2019/8/26 14:36
 */
@Service
public class TestService {
    @Autowired
    PersonMapper personMapper;

    @Cacheable(value = "Person")
    public List<Person> getAll(){
        return personMapper.getAll();
    }
}
