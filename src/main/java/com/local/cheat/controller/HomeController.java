package com.local.cheat.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.local.cheat.constants.URL;
import com.local.cheat.form.SearchForm;
import com.local.cheat.model.Cheat;
import com.local.cheat.service.CheatService;
import com.local.cheat.util.CheatMAV;

@Controller
@SessionAttributes(types = {SearchForm.class})
@RequestMapping("/")
public class HomeController {

	@Autowired
	private CheatService service;

	@GetMapping
	public CheatMAV home(CheatMAV mav, @PageableDefault(page = 0) Pageable pageable) {
		mav.addObject("cheats", service.selectAll(pageable));
		mav.addObject("currentUrl", URL.HOME);
		mav.setViewName(URL.TEMPLATE_HOME);
		return mav;
	}

	@GetMapping("search")
	public CheatMAV search(CheatMAV mav, @PageableDefault(page = 0) Pageable pageable, @Valid SearchForm form, BindingResult result) {
		if(result.hasErrors()){
			mav.setViewName(URL.REDIRECT_HOME);
			return mav;
        }
		mav.addObject("cheats", service.search(pageable ,form));
		mav.addObject("currentUrl", URL.SEARCH_CHEAT);
		mav.setViewName(URL.TEMPLATE_HOME);
		return mav;
	}

	@PostMapping("delete")
	public CheatMAV delete(CheatMAV mav, @RequestParam("id") Integer id) {
		service.delete(id);
		mav.setViewName(URL.REDIRECT_HOME);
		return mav;
	}

}
