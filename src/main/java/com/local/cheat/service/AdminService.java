package com.local.cheat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.cheat.mapper.UserMapper;
import com.local.cheat.model.UserSet;

@Service
public class AdminService {

	@Autowired
	protected UserMapper userMapper;
	
	public List<UserSet> selectAllUsers() {
		return userMapper.selectAll();
	}
	
}
