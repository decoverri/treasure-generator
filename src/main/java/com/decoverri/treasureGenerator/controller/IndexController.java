package com.decoverri.treasureGenerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.decoverri.treasureGenerator.dao.TreasureTypeDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.logic.generator.TreasureGenerator;
import com.decoverri.treasureGenerator.model.TreasureTypes;

@Controller
@Scope("request")
public class IndexController {

	@Autowired
	private TreasureGenerator generator;

	@Autowired
	private TreasureTypeDao treasureTypeDao;

	@RequestMapping("/")
	public String execute(Model model) {
		model.addAttribute("treasureTypes", treasureTypeDao.getTreasureTypes());
		return "index";
	}

	@RequestMapping("/generate")
	public String generate(TreasureTypes treasureTypes, Model model) {
		List<Treasure> treasures = generator.generate(treasureTypes);
		double totalPrice = 0;
		for (Treasure treasure : treasures) {
			totalPrice += treasure.getTreasureValue();
		}
		model.addAttribute("treasures", treasures);
		model.addAttribute("totalPrice", totalPrice);
		return "forward:/";
	}
}
