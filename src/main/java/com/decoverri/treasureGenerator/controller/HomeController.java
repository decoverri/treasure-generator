package com.decoverri.treasureGenerator.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.decoverri.treasureGenerator.dao.TreasureTypeDao;
import com.decoverri.treasureGenerator.dao.TreasureTypeValueDao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

@Controller
@Scope("request")
public class HomeController {

	@Autowired
	private TreasureTypeDao treasureTypeDao;

	@Autowired
	private TreasureTypeValueDao treasureTypeValueDao;
	
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

	@RequestMapping("/getListOfValues")
	public @ResponseBody String getListOfValuesOfTrasureType(Model model, char letter, HttpServletResponse response){
		List<Integer> values = treasureTypeValueDao.getValuesForLetter(letter);
		XStream stream = new XStream(new JettisonMappedXmlDriver());
		response.setStatus(200);
		return stream.toXML(values);
	}
}
