package com.local.cheat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.local.cheat.constants.URL;
import com.local.cheat.form.CheatForm;
import com.local.cheat.mapper.CheatMapper;
import com.local.cheat.service.CheatService;
import com.local.cheat.util.CheatMAV;

@RequestMapping("add")
@Controller
public class AddCheatController {

	@Autowired
	private CheatMapper mapper;

	@Autowired
	private CheatService service;

	@GetMapping
	public CheatMAV index(CheatMAV mav) {
		var form = new CheatForm();
		mav.addObject("form", form);
		mav.setViewName(URL.TEMPLATE_ADD);
		return mav;
	}

	@PostMapping("submit")
	public CheatMAV submit(CheatMAV mav, @ModelAttribute @Validated CheatForm form, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			mav.addObject("form", form);
			mav.addObject("errors", bindingResult.getFieldErrors());
			mav.setViewName(URL.TEMPLATE_ADD);
		} else {
			mapper.insert(service.formToModel(form));
			mav.setViewName(URL.REDIRECT_HOME);
		}
		return mav;
	}

}
