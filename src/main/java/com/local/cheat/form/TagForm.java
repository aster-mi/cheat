package com.local.cheat.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TagForm {
	
	private Integer id;
	
	@NotEmpty(message = "タグ名を入力してください。")
	@Size(max=10,message="タグ名は10文字以内に設定してください。")
	private String name;
	
	@Pattern(regexp="^#([0-9a-fA-F]{3}|[0-9a-fA-F]{6})$",message="正しい色を選択してください。")
	private String color;
	
}
