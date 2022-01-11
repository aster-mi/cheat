package com.local.cheat.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.cheat.form.SettingForm;
import com.local.cheat.mapper.SettingMapper;
import com.local.cheat.model.Setting;
import com.local.cheat.session.UserSession;

@Service
public class SettingService {
	
	@Autowired
	private SettingMapper mapper;
	
	@Autowired
    protected UserSession session;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public Setting formToModel(SettingForm form) {
		return modelMapper.map(form, Setting.class);
	}
	
	public SettingForm modelToForm(Setting model) {
		return modelMapper.map(model, SettingForm.class);
	}
	
	public Setting select() {
		return mapper.selectByPK(session.getUser().getUserId());
	}
	
	public void update(Setting tag) {
		tag.setUserId(session.getUser().getUserId());
		mapper.update(tag);
	}
}
