package com.local.cheat.form;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

@Data
public class SearchForm {

	private String q;

	private Integer tagId;

	private String exclusionWord;

	public String getQ() {
		return StringUtils.isEmpty(q) ? null : q;
	}

	public Integer getTagId() {
		return tagId == null || tagId.equals(0) ? null : tagId;
	}

	public void reset() {
		q = null;
		tagId = null;
		exclusionWord = null;
	}

	/**
	 * 含む検索条件
	 * 
	 * @return
	 */
	public List<String> getSearchWords() {
		return Arrays.asList(StringUtils.split(q)).stream().filter(q -> !((String) q).startsWith("-")).distinct()
				.collect(Collectors.toList());
	}

	/**
	 * 含まない検索条件
	 * 
	 * @return
	 */
	public List<String> getNotSearchWords() {
		return Arrays.asList(StringUtils.split(q)).stream().filter(q -> ((String) q).startsWith("-"))
				.map(q -> q.substring(1)).distinct().collect(Collectors.toList());
	}

	/**
	 * 検索ワードから除外
	 */
	public void exclusion() {
		StringBuilder buf = new StringBuilder();
		Arrays.asList(StringUtils.split(q)).stream().filter(q -> !q.endsWith(exclusionWord)).distinct()
				.forEach(q -> buf.append(" " + q));
		q = buf.toString();
		exclusionWord = null;
	}

}