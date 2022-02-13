package com.local.cheat.controller;

import java.util.Objects;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.local.cheat.constants.URL;
import com.local.cheat.form.SearchForm;
import com.local.cheat.model.User;
import com.local.cheat.service.CheatService;
import com.local.cheat.service.TagService;
import com.local.cheat.session.UserSession;
import com.local.cheat.util.CheatMAV;

@Controller
@SessionAttributes(types = {SearchForm.class})
@RequestMapping("/")
public class HomeController {

	@Autowired
	private CheatService service;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
    protected UserSession session;

	@GetMapping
	public CheatMAV home(CheatMAV mav, @PageableDefault(page = 0) Pageable pageable, @Valid SearchForm form, @AuthenticationPrincipal User user) {
		session.setUser(user);
		form.reset();
		mav.addObject("searchForm", form);
		mav.addObject("cheats", service.selectAll(pageable));
		mav.addObject("tags", tagService.selectAll());
		mav.addObject("currentUrl", URL.HOME);
		mav.setViewName(URL.TEMPLATE_HOME);
		return mav;
	}

	@GetMapping("search")
	public CheatMAV search(CheatMAV mav, @PageableDefault(page = 0) Pageable pageable, @Valid SearchForm form, BindingResult result) {
		if(Objects.isNull(form.getQ())&&Objects.isNull(form.getTagId())&&!form.isTagless()){
			mav.setViewName(URL.REDIRECT_HOME);
			return mav;
        }
		if(StringUtils.isNotEmpty(form.getExclusionWord())) {
			form.exclusion();
		}
		if(Objects.nonNull(form.getTagId())) {
			form.setTagless(false);
		}
		mav.addObject("cheats", service.search(pageable ,form));
		mav.addObject("tags", tagService.selectAll());
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
