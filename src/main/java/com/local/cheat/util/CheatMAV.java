package com.local.cheat.util;

import java.util.Arrays;

import org.springframework.web.servlet.ModelAndView;

public class CheatMAV extends ModelAndView  {
	public CheatMAV() {
		// TODO タグ
		this.addObject("tags",Arrays.asList("Java","HTML","CSS","SQL","Bootstrap","Bash","Shell"));
	}
}
