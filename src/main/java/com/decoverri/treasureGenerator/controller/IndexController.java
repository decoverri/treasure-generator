package com.decoverri.treasureGenerator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.decoverri.treasureGenerator.dao.TreasureRewardDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.logic.generator.TreasureGenerator;
import com.decoverri.treasureGenerator.model.view.TreasureType;

@Controller
@Scope("request")
public class IndexController {

	@Autowired
	private TreasureRewardDao rewardDao;
	@Autowired
	private TreasureGenerator generator;

	@RequestMapping("/")
	public String execute(Model model) {
		List<TreasureType> treasureTypes = new ArrayList<TreasureType>();
		TreasureType treasureType;

		List<Character> types = rewardDao.getTypes();
		for (Character character : types) {
			treasureType = new TreasureType();
			treasureType.setLetter(character);
			treasureType.setValues(rewardDao.getValuesOfType(character));
			treasureTypes.add(treasureType);
		}
		
//TODO: fazer TreasureType virar uma Entity, criar um dao para ele e substituir gtodas as linhas de cima pela de baixo :D		
//		List<TreasureType> types = treasureTypeDao.getTreasureTypes();

		model.addAttribute("treasureTypes", treasureTypes);
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
