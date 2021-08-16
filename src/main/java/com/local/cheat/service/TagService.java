package com.local.cheat.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.cheat.form.TagForm;
import com.local.cheat.mapper.TagMapper;
import com.local.cheat.model.Tag;
import com.local.cheat.session.UserSession;

@Service
public class TagService {
	
	@Autowired
	private TagMapper mapper;
	
	@Autowired
    protected UserSession session;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public Tag formToModel(TagForm form) {
		return modelMapper.map(form, Tag.class);
	}
	
	public TagForm modelToForm(Tag model) {
		return modelMapper.map(model, TagForm.class);
	}
	
	public List<Tag> selectAll(){
		return mapper.selectByUserId(session.getUser().getUserId());
	}
	
	public Tag select(Integer id) {
		return mapper.selectById(id, session.getUser().getUserId());
	}
	
	public void insert(Tag tag) {
		tag.setUserId(session.getUser().getUserId());
		mapper.insert(tag);
	}
	
	public int delete(Integer id) {
		return mapper.delete(id,session.getUser().getUserId());
	}
	
	public void update(Tag tag) {
		tag.setUserId(session.getUser().getUserId());
		mapper.update(tag);
	}
}
