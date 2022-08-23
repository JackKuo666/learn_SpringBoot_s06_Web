package com.example.s06_springbootweb.mapper;

import com.example.s06_springbootweb.entity.UserData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MainMapper {
    @Select("select * from users where name = #{username}")
    UserData findUserByName(String username);
}