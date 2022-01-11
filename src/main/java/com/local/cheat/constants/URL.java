package com.local.cheat.constants;

import org.springframework.stereotype.Component;

@Component
public class URL {
	
	// user
	public static final String SIGNUP = "signup";
	public static final String CHANGE_PASSWORD = "changepassword";
	public static final String SETTING = "setting";
	
	// template
	public static final String TEMPLATE_HOME = "home";
	public static final String TEMPLATE_ADD_CHEAT = "add";
	public static final String TEMPLATE_EDIT_CHEAT = "edit";
	public static final String TEMPLATE_ADD_TAG = "tag/add";
	public static final String TEMPLATE_EDIT_TAG = "tag/edit";
	public static final String TEMPLATE_LIST_TAG = "tag/list";
	public static final String TEMPLATE_SHARE_LINK = "share";
	
	// admin template
	public static final String TEMPLATE_ADMIN_TOP = "admin/top";
	public static final String TEMPLATE_ADMIN_USERLIST = "admin/userlist";

	// redirect
	public static final String REDIRECT_HOME = "redirect:/";
	public static final String REDIRECT_ADD_CHEAT = "redirect:/add";
	public static final String REDIRECT_EDIT_CHEAT = "redirect:/edit";
	public static final String REDIRECT_ADD_TAG = "redirect:/tag/add";
	public static final String REDIRECT_EDIT_TAG = "redirect:/tag/edit";
	public static final String REDIRECT_LIST_TAG = "redirect:/tag/list";
	public static final String REDIRECT_SHARE_LINK_BASE = "redirect:/share/link/";
	
	// url
	public static final String HOME = "/";
	public static final String SEARCH_CHEAT = HOME+"search";
	public static final String ADD_TAG = "tag/add";
	public static final String EDIT_TAG = "tag/edit";
	public static final String LIST_TAG = "tag/list";
	
	public static final String LINK_REGEX = "(http://|https://){1}[\\w\\;\\&\\=\\%\\?\\.\\-/:]+";
	

}
