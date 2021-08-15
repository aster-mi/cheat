package com.local.cheat.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.cheat.form.TagForm;
import com.local.cheat.mapper.TagMapper;
import com.local.cheat.model.Tag;

@Service
public class TagService {
	
	@Autowired
	private TagMapper mapper;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public Tag formToModel(TagForm form) {
		return modelMapper.map(form, Tag.class);
	}
	
	public TagForm modelToForm(Tag model) {
		return modelMapper.map(model, TagForm.class);
	}
	
	public List<Tag> selectAll(){
		return mapper.selectByUserId(null);// TODO　userId指定
	}
	
	public int delete(Integer id) {
		return mapper.delete(id);
	}
}
