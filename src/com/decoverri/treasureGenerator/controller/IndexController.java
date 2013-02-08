package com.decoverri.treasureGenerator.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.decoverri.treasureGenerator.enums.TreasureType;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String execute() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("treasureTypes", Arrays.asList(TreasureType.values()));
		
		return "index";
	}

}
