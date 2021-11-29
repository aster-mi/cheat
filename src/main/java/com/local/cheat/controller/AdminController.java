package com.local.cheat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.local.cheat.constants.URL;
import com.local.cheat.service.AdminService;
import com.local.cheat.util.CheatMAV;

@RequestMapping("admin")
@Controller
public class AdminController {
	
	@Autowired
	protected AdminService service;

	@GetMapping
	public CheatMAV top(CheatMAV mav) {
		mav.setViewName(URL.TEMPLATE_ADMIN_TOP);
		return mav;
	}
	
	@GetMapping("userlist")
	public CheatMAV userlist(CheatMAV mav) {
		mav.addObject("users", service.selectAllUsers());
		mav.setViewName(URL.TEMPLATE_ADMIN_USERLIST);
		return mav;
	}
	
	
}
