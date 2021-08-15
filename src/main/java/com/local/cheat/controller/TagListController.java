package com.local.cheat.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.local.cheat.constants.URL;
import com.local.cheat.form.SearchForm;
import com.local.cheat.service.TagService;
import com.local.cheat.util.CheatMAV;

@Controller
@RequestMapping(URL.LIST_TAG)
public class TagListController {

	@Autowired
	private TagService service;

	@GetMapping
	public CheatMAV home(CheatMAV mav) {
		mav.addObject("tags", service.selectAll());
		mav.setViewName(URL.TEMPLATE_LIST_TAG);
		return mav;
	}

	@PostMapping("delete")
	public CheatMAV delete(CheatMAV mav, @RequestParam("id") Integer id) {
		service.delete(id);
		mav.setViewName(URL.REDIRECT_LIST_TAG);
		return mav;
	}

}
