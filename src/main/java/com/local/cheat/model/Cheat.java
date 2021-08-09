package com.local.cheat.model;

import com.local.cheat.constants.URL;
import com.local.cheat.util.EscapeUtil;

import lombok.Data;

@Data
public class Cheat {

	private Integer id;
	private String title;
	private String code;
	private String detail;
	
	public String getEscapeDetail() {
		return EscapeUtil.htmlEscape(detail).replaceAll(URL.LINK_REGEX,"<a href='$0'>$0</a>");
	}
	
}
