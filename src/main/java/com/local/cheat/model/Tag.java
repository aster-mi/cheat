package com.local.cheat.model;


import lombok.Data;

@Data
public class Tag {
	
	private Integer id;
	private Integer userId;
	private String name;
	private String color;
	
	// TODO 出力用の文字色
	private String fontColor;
	
}
