package com.zzl.gc.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonMapperTest {
    @Autowired
    private PersonMapper personMapper;
    @Test
    public void getAll() {
        assertNotNull(personMapper.getAll());
    }
}