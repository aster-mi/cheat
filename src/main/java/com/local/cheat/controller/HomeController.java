package com.local.cheat.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.local.cheat.constants.URL;
import com.local.cheat.form.CheatForm;
import com.local.cheat.mapper.CheatMapper;
import com.local.cheat.model.Cheat;
import com.local.cheat.service.CheatService;
import com.local.cheat.util.CheatMAV;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private CheatMapper mapper;

	@Autowired
	private CheatService service;

	@GetMapping
	public CheatMAV home(CheatMAV mav) {
		mav.addObject("cheats", mapper.selectAll());
		mav.setViewName(URL.HOME);
		return mav;
	}

	@GetMapping("search")
	public CheatMAV search(CheatMAV mav, @RequestParam("q") String q) {
		mav.addObject("cheats", mapper.search(q));
		mav.setViewName(URL.HOME);
		return mav;
	}

	@PostMapping("delete")
	public CheatMAV delete(CheatMAV mav, @RequestParam("id") Integer id) {
		var form = new CheatForm();
		form.setId(id);
		mapper.delete(service.formToModel(form));
		mav.setViewName(URL.REDIRECT_HOME);
		return mav;
	}

}
