package com.local.cheat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.local.cheat.model.Tag;

@Mapper
public interface TagMapper {

	@Insert("insert into tag(user_id, name, color) values(#{userId}, #{name}, #{color})")
	void insert(Tag tag);
	
	@Update("update tag set user_id=#{userId} name=#{name}, color=#{color} where id=#{id}")
	void update(Tag tag);
	
	// TODO CheatレコードのcolorIdを外す必要がある。
	@Delete("delete from tag where user_id=#{userId} id=#{id}")
	int delete(Integer id, Integer userId);
	
	@Select("select * from tag where user_id=#{userId}")
	List<Tag> selectByUserId(Integer userId);
	
	@Select("select * from tag where id=#{id} and user_id=#{userId}")
	Tag selectById(Integer id, Integer userId);
}
