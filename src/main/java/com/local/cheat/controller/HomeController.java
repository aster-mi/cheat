package com.local.cheat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.local.cheat.constants.URL;
import com.local.cheat.mapper.CheatMapper;
import com.local.cheat.util.CheatMAV;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private CheatMapper mapper;
	
	@GetMapping
	public CheatMAV home(CheatMAV mav) {
		mav.addObject("cheats",mapper.selectAll());
        mav.setViewName(URL.HOME);
        return mav;
	}
	
}
