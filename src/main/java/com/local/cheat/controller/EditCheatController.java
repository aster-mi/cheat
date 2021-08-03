package com.local.cheat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.local.cheat.constants.URL;
import com.local.cheat.form.CheatForm;
import com.local.cheat.mapper.CheatMapper;
import com.local.cheat.service.CheatService;
import com.local.cheat.util.CheatMAV;

@RequestMapping("edit")
@Controller
public class EditCheatController {
	
	@Autowired
	private CheatMapper mapper;
	
	@Autowired
	private CheatService service;

	@GetMapping
	public CheatMAV index(CheatMAV mav, @RequestParam("id") Integer id) {
		var model = mapper.selectById(id);
		mav.addObject("form", service.modelToForm(model));
        mav.setViewName(URL.EDIT);
        return mav;
	}
	
	@PostMapping("submit")
	public CheatMAV submit(CheatMAV mav,@ModelAttribute CheatForm form) {
		mapper.update(service.formToModel(form));
        mav.setViewName(URL.REDIRECT_HOME);
        return mav;
	}
	
}
