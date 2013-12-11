package com.decoverri.treasureGenerator.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("request")
public class AboutController {
	
	@RequestMapping("/about")
	public String about() {
		return "about";
	}

}
