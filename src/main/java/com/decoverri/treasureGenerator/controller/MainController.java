package com.decoverri.treasureGenerator.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.decoverri.treasureGenerator.dao.TreasureTypeDao;
import com.decoverri.treasureGenerator.dao.TreasureTypeValueDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.logic.GeneratorCalculator;
import com.decoverri.treasureGenerator.logic.generator.TreasureGenerator;

@Controller
@Scope("request")
public class MainController {

	@Autowired
	private TreasureTypeDao treasureTypeDao;

	@Autowired
	private TreasureTypeValueDao treasureTypeValueDao;
	
	@Autowired
	private TreasureGenerator generator;
	
	@Autowired
	GeneratorCalculator generatorCalculator;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("types", treasureTypeDao.getTreasureTypes());
		return "index";
	}

	@RequestMapping("/home")
	public String goHome() {
		return "redirect:/";
	}

	@RequestMapping("/generate")
	public String generate(int value, char letter, Model model, HttpSession session){
		List<Treasure> treasures = generator.generate(value, letter);
		double totalPrice = generatorCalculator.calculateTotalValue(treasures);

		model.addAttribute("treasures", treasures);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("selectedLetter", letter);
		model.addAttribute("selectedValue", value);

		return "generate";
	}
}
