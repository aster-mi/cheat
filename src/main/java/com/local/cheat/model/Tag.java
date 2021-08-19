package com.local.cheat.model;


import org.apache.commons.lang3.StringUtils;

import lombok.Data;

@Data
public class Tag {
	
	private Integer id;
	private Integer userId;
	private String name;
	private String color;
	
	/**
	 * 背景色から適した文字色を取得
	 * @return
	 */
	public String getFontColor(){
		if(StringUtils.isEmpty(color)) return "";
		var r = Integer.parseInt(color.substring(1, 2), 16);
		var g = Integer.parseInt(color.substring(3, 5), 16);
		var b = Integer.parseInt(color.substring(5, 7), 16);
		return ((((r * 299) + (g * 587) + (b * 114)) / 1000) < 170) ? "" : "text-dark";
	}
	
}
