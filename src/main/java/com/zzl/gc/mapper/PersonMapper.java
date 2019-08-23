package com.zzl.gc.mapper;

import com.zzl.gc.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author luotao
 * @Package com.zzl.gc.mapper
 * @date 2019/8/23 11:22
 */
@Mapper
public interface PersonMapper {
    @Select("select * from person")
    List<Person> getAll();
}
