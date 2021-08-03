package com.local.cheat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.local.cheat.util.CheatMAV;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private String HOME = "home";
	
	@GetMapping
	public CheatMAV home(CheatMAV mav) {
		
		mav.addObject("test","Controller ok");
	
        mav.setViewName(HOME);
	
        return mav;
	}
	
}
