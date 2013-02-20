package com.decoverri.treasureGenerator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import com.decoverri.treasureGenerator.dao.TreasureRewardDao;
import com.decoverri.treasureGenerator.model.view.TreasureTypeInfo;

@Controller
@Scope("request")
public class IndexController {
	
	@Autowired
	private TreasureRewardDao rewardDao;

	@RequestMapping("/")
	public ModelAndView execute() {

		ArrayList<TreasureTypeInfo> treasuresInfo = new ArrayList<TreasureTypeInfo>();
		TreasureTypeInfo info;
		
		List<Character> types = rewardDao.getTypes();
		
		for (Character character : types) {
			info = new TreasureTypeInfo();
			info.setName(character.toString());
			info.setValues(rewardDao.getValuesOfType(character));
			treasuresInfo.add(info);
		}
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("treasureTypesInfo", treasuresInfo);
		
		return mv;
	}

	@RequestMapping("/generate")
	public String generate(@ModelAttribute("information") TreasureTypeInfos information) {
		return "forward:/";
	}
}
