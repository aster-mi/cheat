package com.local.cheat.form;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

@Data
public class SearchForm {
	
	private String q;
	
	private Integer tagId;
	
	public String getQ() {
		return StringUtils.isEmpty(q)?null:q;
	}
	
	public void reset() {
		q=null;
		tagId=null;
	}
}
