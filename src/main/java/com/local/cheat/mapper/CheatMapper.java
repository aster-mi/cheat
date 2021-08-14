package com.local.cheat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.domain.Pageable;

import com.local.cheat.form.SearchForm;
import com.local.cheat.model.Cheat;

@Mapper
public interface CheatMapper {

	@Insert("insert into cheat(title, code, detail) values(#{title}, #{code}, #{detail})")
	void insert(Cheat model);
	
	@Update("update cheat set title=#{title}, code=#{code}, detail=#{detail} where id=#{id}")
	void update(Cheat model);
	
	@Delete("delete from cheat where id=#{id}")
	int delete(Integer id);
	
	@Select("select * from cheat order by id desc limit #{pageSize} offset #{offset}")
	List<Cheat> selectAll(Pageable pageable);
	
	@Select("select count(*) from cheat")
	int selectAllCount();
	
	@Select("select * from cheat where title like '%'||#{form.q}||'%' or code like '%'||#{form.q}||'%' or detail like '%'||#{form.q}||'%' order by id desc limit #{pageable.pageSize} offset #{pageable.offset}")
	List<Cheat> search(Pageable pageable,SearchForm form);
	
	@Select("select count(*) from cheat where title like '%'||#{q}||'%' or code like '%'||#{q}||'%' or detail like '%'||#{q}||'%'")
	int searchCount(SearchForm form);
	
	@Select("select * from cheat where id=#{id}")
	Cheat selectById(Integer id);
}
