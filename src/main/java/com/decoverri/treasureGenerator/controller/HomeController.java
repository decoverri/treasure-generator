package com.decoverri.treasureGenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.decoverri.treasureGenerator.dao.TreasureTypeDao;

@Controller
@Scope("request")
public class HomeController {

	@Autowired
	private TreasureTypeDao treasureTypeDao;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("types", treasureTypeDao.getTreasureTypes());
		model.addAttribute("homeIsActive", "active");
		return "home";
	}

	@RequestMapping("/home")
	public String goHome() {
		return "redirect:/";
	}

}
