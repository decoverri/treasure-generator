package com.decoverri.treasureGenerator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.decoverri.treasureGenerator.model.view.TreasureTypeInfo;

@Controller
public class IndexController {

	@RequestMapping("/")
	public ModelAndView execute() {

		ArrayList<TreasureTypeInfo> list = new ArrayList<TreasureTypeInfo>();
		
		List<Integer> values = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			values.add(i+1);
		}
		list.add(new TreasureTypeInfo("Type A", "Coins", values));
		
		values = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			values.add((i+1) * 10);
		}
		list.add(new TreasureTypeInfo("Type B", "Other stuff", values));

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("treasureTypesInfo", list);
		
		return mv;
	}

}
