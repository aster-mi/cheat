package com.local.cheat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.local.cheat.constants.URL;
import com.local.cheat.service.CheatService;
import com.local.cheat.session.UserSession;
import com.local.cheat.util.CheatMAV;

@RequestMapping("share")
@Controller
public class ShareController {
	
	@Autowired
    protected UserSession session;
	
	@Autowired
	protected CheatService service;

	@PostMapping
	public CheatMAV create(CheatMAV mav, @RequestParam Integer id) {
		var user = session.getUser();
		var key = service.share(user.getUsername(), id, user.getUserId());
		mav.setViewName(URL.REDIRECT_SHARE_LINK_BASE+"?key="+key);
		return mav;
	}
	
	@GetMapping("link")
	public CheatMAV view(CheatMAV mav, @RequestParam String key) {
		var cheat = service.selectByShareKey(key);
		if(cheat==null) {
			mav.setViewName(URL.REDIRECT_HOME);
		}else {
			mav.addObject("cheat",cheat);
			mav.setViewName(URL.TEMPLATE_SHARE_LINK);
		}
		return mav;
	}
	
}
