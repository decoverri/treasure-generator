package com.decoverri.treasureGenerator.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("request")
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "home";
	}

	@RequestMapping("/home")
	public String goHome() {
		return "redirect:/";
	}

}
