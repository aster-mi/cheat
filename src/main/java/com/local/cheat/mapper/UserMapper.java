package com.local.cheat.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.local.cheat.model.User;

@Mapper
public interface UserMapper {

    //select文。codeuserテーブルから、usernameが一致しているものを検索
    @Select("select * from codeuser where username = #{username}")
    public User findByUsername(String username);//識別する

}