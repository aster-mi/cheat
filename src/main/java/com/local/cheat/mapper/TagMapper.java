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

	@Insert("insert into tag(name, color) values(#{name}, #{color})")
	void insert(Tag model);
	
	@Update("update tag set name=#{name}, color=#{color} where id=#{id}")
	void update(Tag model);
	
	// TODO CheatレコードのcolorIdを外す必要がある。
	@Delete("delete from tag where id=#{id}")
	int delete(Integer id);
	
	// TODO 引数の型は検索時決める
	@Select("select * from tag where user_id=#{userId}")
	List<Tag> selectByUserId(String userId);
	
	@Select("select * from tag where id=#{id}")
	Tag selectById(Integer id);
}
