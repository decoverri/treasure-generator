package com.decoverri.treasureGenerator.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.decoverri.treasureGenerator.dao.TreasureTypeDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.logic.GeneratorCalculator;
import com.decoverri.treasureGenerator.logic.generator.TreasureGenerator;
import com.decoverri.treasureGenerator.model.TreasureTypes;

@Controller
@Scope("request")
public class MassGeneratorController {

	@Autowired
	private TreasureGenerator generator;

	@Autowired
	private TreasureTypeDao treasureTypeDao;
	
	@Autowired
	GeneratorCalculator generatorCalculator;
	
	@RequestMapping("/massGenerator")
	public String massGenerator(Model model) {
		model.addAttribute("treasureTypes", treasureTypeDao.getTreasureTypes());
		model.addAttribute("massIsActive", "active");

		return "mass";
	}

	@RequestMapping("/massGenerate")
	public String massGenerate(TreasureTypes treasureTypes, Model model, HttpSession session) {
		List<Treasure> treasures = generator.generate(treasureTypes);
		double totalPrice = generatorCalculator.calculateTotalValue(treasures);

		model.addAttribute("treasures", treasures);
		model.addAttribute("totalPrice", totalPrice);
		session.setAttribute("massSelectedTypes", treasureTypes.getTreasureTypes());
		session.setAttribute("massSelectedTotal", treasureTypes.getFomattedSumOfValues());
		
		return "forward:/massGenerator";
	}

}
