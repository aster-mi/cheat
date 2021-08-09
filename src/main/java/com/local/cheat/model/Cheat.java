package com.local.cheat.model;


import com.local.cheat.constants.URL;
import com.local.cheat.util.EscapeUtil;

import lombok.Data;

@Data
public class Cheat {
	
	/** コードをデフォルトで表示する最大行数 */
	private final Integer CODE_MAX_LINE = 10;

	private Integer id;
	private String title;
	private String code;
	private String detail;
	
	public String getEscapeDetail() {
		return EscapeUtil.htmlEscape(detail).replaceAll(URL.LINK_REGEX,"<a href='$0'>$0</a>");
	}
	
	public boolean isCodeOverflow() {
		var n = System.lineSeparator();
		return code.split(n,-1).length > CODE_MAX_LINE;
	}
	
	public String getShortCode() {
		var n = System.lineSeparator();
		var lines = code.split(n,-1);
		String shortCode = "";
		for(int i=0;lines.length>i&&CODE_MAX_LINE>i;i++) {
			shortCode += lines[i]+n;
		}
		return shortCode;
	}
	
}
