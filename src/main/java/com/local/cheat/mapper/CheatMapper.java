package com.local.cheat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.local.cheat.model.Cheat;

@Mapper
public interface CheatMapper {

	@Insert("insert into cheat(title, code, detail) values(#{title}, #{code}, #{detail})")
	void insert(Cheat model);
	
	@Update("update cheat set title=#{title}, code=#{code}, detail=#{detail} where id=#{id}")
	void update(Cheat model);
	
	@Select("select * from cheat")
	List<Cheat> selectAll();
	
	@Select("select * from cheat where id=#{id}")
	Cheat selectById(Integer id);
	
}
