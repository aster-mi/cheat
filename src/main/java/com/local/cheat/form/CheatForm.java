package com.local.cheat.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CheatForm {
	
	private Integer id;
	
	@NotEmpty
	@Size(max=50)
	private String title;
	
	@NotEmpty
	@Size(max=3000)
	private String code;
	
	@Size(max=3000)
	private String detail;
	
}
