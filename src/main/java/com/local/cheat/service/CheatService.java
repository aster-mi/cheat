package com.local.cheat.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.local.cheat.form.CheatForm;
import com.local.cheat.model.Cheat;

@Service
public class CheatService {

	
	private ModelMapper modelMapper = new ModelMapper();
	
	public Cheat formToModel(CheatForm form) {
		return modelMapper.map(form, Cheat.class);
	}
	
	public CheatForm modelToForm(Cheat model) {
		return modelMapper.map(model, CheatForm.class);
	}
	
}
