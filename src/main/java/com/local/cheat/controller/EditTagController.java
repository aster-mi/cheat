package com.local.cheat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.local.cheat.constants.URL;
import com.local.cheat.form.TagForm;
import com.local.cheat.service.TagService;
import com.local.cheat.util.CheatMAV;

@RequestMapping(URL.EDIT_TAG)
@Controller
public class EditTagController {

	@Autowired
	private TagService service;
	
	@Autowired
	private TagService tagService;
	
	@PostMapping
	public CheatMAV index(CheatMAV mav, @RequestParam("id") Integer id) {
		var model = service.select(id);
		mav.addObject("form", service.modelToForm(model));
		mav.addObject("tags",tagService.selectAll());
		mav.setViewName(URL.TEMPLATE_EDIT_TAG);
		return mav;
	}

	@PostMapping("submit")
	public CheatMAV submit(CheatMAV mav, @ModelAttribute @Validated TagForm form, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			mav.addObject("form",form);
			mav.addObject("tags",tagService.selectAll());
			mav.addObject("errors",bindingResult.getFieldErrors());
			mav.setViewName(URL.TEMPLATE_EDIT_TAG);
		} else {
			service.update(service.formToModel(form));
			mav.setViewName(URL.REDIRECT_HOME);
		}
		return mav;
	}

	@PostMapping("delete")
	public CheatMAV delete(CheatMAV mav, @ModelAttribute TagForm form) {
		service.delete(form.getId());
		mav.setViewName(URL.REDIRECT_HOME);
		return mav;
	}

}
