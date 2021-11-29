package com.local.cheat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.local.cheat.model.User;

@Mapper
public interface UserMapper {

    //select文。codeuserテーブルから、usernameが一致しているものを検索
    @Select("select * from codeuser where username = #{username}")
    public User findByUsername(String username);//識別する
    
    // 全ユーザー取得
    @Select("select * from codeuser")
    public List<User> selectAll();
    
    @Insert("insert into codeuser(username, password) values (#{username}, #{password})")
    public void insert(User user);

    @Update("update codeuser set password=#{password} where user_id=#{userId}")
	public void updatePassword(User user);
	

}