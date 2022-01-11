package com.local.cheat.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.local.cheat.model.Setting;

@Mapper
public interface SettingMapper {
	
	@Select("select * from setting where user_id=#{userId}")
	Setting selectByPK(Integer userId);
	
	@Update("update setting set cheat_auto_sort=#{cheatAutoSort}, tag_auto_sort=#{tagAutoSort} where user_id=#{userId}")
	void update(Setting setting);
	
	@Insert("insert into setting(user_id) values (#{userId})")
    public void insert(Integer userId);
	
}
