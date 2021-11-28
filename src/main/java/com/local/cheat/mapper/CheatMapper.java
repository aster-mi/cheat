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

	@Insert("insert into cheat(user_id, tag_id, title, code, detail) values(#{userId},#{tagId}, #{title}, #{code}, #{detail})")
	void insert(Cheat model);
	
	@Update("update cheat set tag_id=#{tagId}, title=#{title}, code=#{code}, detail=#{detail} where id=#{id} and user_id=#{userId}")
	void update(Cheat model);
	
	@Update("update cheat set share_key=#{shareKey} where id=#{id} and user_id=#{userId}")
	void share(String shareKey, Integer id, Integer userId);
	
	@Delete("delete from cheat where id=#{id} and user_id=#{userId}")
	int delete(Integer id, Integer userId);
	
	@Select("select * from cheat where user_id=#{userId} order by updated_at desc, id desc limit #{pageable.pageSize} offset #{pageable.offset}")
	List<Cheat> selectAll(Pageable pageable,Integer userId);
	
	@Select("select count(*) from cheat where user_id=#{userId}")
	int selectAllCount(Integer userId);
	
	List<Cheat> search(Pageable pageable,SearchForm form,Integer userId);
	
	int searchCount(SearchForm form,Integer userId);
	
	@Select("select * from cheat where id=#{id} and user_id=#{userId}")
	Cheat select(Integer id, Integer userId);
	
	@Select("select * from cheat where share_key=#{shareKey}")
	Cheat selectByShareKey(String shareKey);
}
