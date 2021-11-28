package com.local.cheat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.local.cheat.constants.URL;
import com.local.cheat.form.ChangePasswordForm;
import com.local.cheat.form.UserForm;
import com.local.cheat.service.UserDetailsServiceImpl;
import com.local.cheat.session.UserSession;
import com.local.cheat.util.CheatMAV;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	UserDetailsServiceImpl service;
	
	@Autowired
    protected UserSession session;
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@GetMapping("signup")
	public CheatMAV signupPage(CheatMAV mav) {
		mav.addObject("form", new UserForm());
		mav.setViewName(URL.SIGNUP);
		return mav;
	}
	
	@PostMapping("signup")
	public CheatMAV signup(CheatMAV mav, @ModelAttribute @Validated UserForm form, BindingResult bindingResult) {
		
		if(service.userExist(form.getUsername())) {
			bindingResult.addError(new FieldError(bindingResult.getObjectName(), "username", "そのユーザー名は既に登録されています。"));
		}
		
		if (bindingResult.hasErrors()) {
			// エラーの場合パスワードを空に設定
			form.setPassword("");
			form.setCheckPassword("");
			mav.addObject("form",form);
			mav.addObject("errors",bindingResult.getFieldErrors());
			mav.setViewName(URL.SIGNUP);
		}else {
			service.registUser(form);
			mav.setViewName(URL.REDIRECT_HOME);
		}
		return mav;
	}
	
	@GetMapping("changepassword")
	public CheatMAV changepasswordPage(CheatMAV mav) {
		mav.addObject("form", new ChangePasswordForm());
		mav.setViewName(URL.CHANGE_PASSWORD);
		return mav;
	}
	
	@PostMapping("changepassword")
	public CheatMAV changepassword(CheatMAV mav, @ModelAttribute @Validated ChangePasswordForm form, BindingResult bindingResult) {
		
		if(!service.passwordMatch(form.getOldPassword(),session.getUser().getUsername())) {
			bindingResult.addError(new FieldError(bindingResult.getObjectName(), "oldPassword", "現パスワードが一致しません。"));
		}
		
		if (bindingResult.hasErrors()) {
			mav.addObject("form",new ChangePasswordForm());
			mav.addObject("errors",bindingResult.getFieldErrors());
			mav.setViewName(URL.CHANGE_PASSWORD);
		}else {
			service.updatePassword(form,session.getUser());
			mav.setViewName(URL.REDIRECT_HOME);
		}
		return mav;
	}
}
