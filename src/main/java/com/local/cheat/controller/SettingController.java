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
import com.local.cheat.form.SettingForm;
import com.local.cheat.service.SettingService;
import com.local.cheat.session.UserSession;
import com.local.cheat.util.CheatMAV;

@RequestMapping("setting")
@Controller
public class SettingController {
	
	@Autowired
    protected UserSession session;
	
	@Autowired
	protected SettingService service;

	@GetMapping
	public CheatMAV index(CheatMAV mav) {
		mav.addObject("form", service.modelToForm(service.select()));
		mav.setViewName(URL.SETTING);
		return mav;
	}
	
	@PostMapping
	public CheatMAV save(CheatMAV mav, @ModelAttribute @Validated SettingForm form, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			mav.addObject("form",form);
			mav.addObject("errors",bindingResult.getFieldErrors());
			mav.setViewName(URL.SETTING);
		} else {
			service.update(service.formToModel(form));
			mav.setViewName(URL.REDIRECT_HOME);
		}
		return mav;
	}
	
}
