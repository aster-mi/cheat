package com.local.cheat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.local.cheat.model.User;
import com.local.cheat.model.UserSet;

@Mapper
public interface UserMapper {

    //select文。codeuserテーブルから、usernameが一致しているものを検索
    @Select("select * from codeuser where username = #{username}")
    public User findByUsername(String username);//識別する
    
    // 全ユーザー取得
    @Select("select a.*, COALESCE(b.cheats, 0) as cheats from codeuser as a left outer join (select user_id, COUNT(*) AS cheats from cheat group by user_id) as b ON a.user_id = b.user_id;")
    public List<UserSet> selectAll();
    
    @Insert("insert into codeuser(username, password) values (#{username}, #{password})")
    public void insert(User user);

    @Update("update codeuser set password=#{password} where user_id=#{userId}")
	public void updatePassword(User user);
	

}