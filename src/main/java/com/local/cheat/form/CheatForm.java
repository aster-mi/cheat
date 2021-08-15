package com.local.cheat.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CheatForm {
	
	private Integer id;
	
	@NotEmpty(message = "タイトルを入力してください。")
	@Size(max=50,message="タイトルは50文字以内に設定してください。")
	private String title;
	
	@Size(max=10000)
	private String code;
	
	@Size(max=10000,message="詳細は1万文字以内に設定してください。")
	private String detail;
	
}
