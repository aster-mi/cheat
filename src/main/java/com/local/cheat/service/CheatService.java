package com.local.cheat.service;

import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.local.cheat.form.CheatForm;
import com.local.cheat.form.SearchForm;
import com.local.cheat.mapper.CheatMapper;
import com.local.cheat.model.Cheat;
import com.local.cheat.session.UserSession;

@Service
public class CheatService {
	
	@Autowired
	private CheatMapper mapper;
	
	@Autowired
    protected UserSession session;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public Cheat formToModel(CheatForm form) {
		return modelMapper.map(form, Cheat.class);
	}
	
	public CheatForm modelToForm(Cheat model) {
		return modelMapper.map(model, CheatForm.class);
	}
	
	public Page<Cheat> search(Pageable pageable, SearchForm form){
		List<Cheat> list = Collections.emptyList();
		var cnt = mapper.searchCount(form, session.getUser().getUserId());
		if (cnt > 0) {
			list = mapper.search(pageable, form, session.getUser().getUserId());
        }
		return new PageImpl<>(list, pageable, cnt);
	}
	
	public Page<Cheat> selectAll(Pageable pageable){
		List<Cheat> list = Collections.emptyList();
		var cnt = mapper.selectAllCount(session.getUser().getUserId());
		if (cnt > 0) {
			list = mapper.selectAll(pageable,session.getUser().getUserId());
        }
		return new PageImpl<>(list, pageable, cnt);
	}
	
	public void insert(Cheat cheat) {
		cheat.setUserId(session.getUser().getUserId());
		mapper.insert(cheat);
	}
	
	public Cheat select(Integer id) {
		return mapper.select(id, session.getUser().getUserId());
	}
	
	public void update(Cheat cheat) {
		cheat.setUserId(session.getUser().getUserId());
		mapper.update(cheat);
	}
	
	public int delete(Integer id) {
		return mapper.delete(id, session.getUser().getUserId());
	}
}
