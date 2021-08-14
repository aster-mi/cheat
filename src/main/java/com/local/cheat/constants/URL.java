package com.local.cheat.constants;

import org.springframework.stereotype.Component;

@Component
public class URL {
	
	public static final String TEMPLATE_HOME = "home";
	public static final String TEMPLATE_ADD = "add";
	public static final String TEMPLATE_EDIT = "edit";

	// redirect
	public static final String REDIRECT_HOME = "redirect:/";
	public static final String REDIRECT_ADD = "redirect:/add";
	public static final String REDIRECT_EDIT = "redirect:/edit";
	
	// url
	public static final String HOME = "/";
	public static final String SEARCH = HOME+"search";
	
	public static final String LINK_REGEX = "(http://|https://){1}[\\w\\.\\-/:]+";
	

}
