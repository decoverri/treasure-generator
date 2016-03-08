package com.decoverri.treasureGenerator.controller;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.decoverri.treasureGenerator.converter.JsonConverter;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.logic.generator.TreasureGenerator;

@Controller
@Scope("request")
@RequestMapping("/json")
public class JsonServiceController {
	
	@Autowired
	private TreasureGenerator generator;

	@RequestMapping(value="/ping", method=RequestMethod.POST)
	@ResponseBody
	public void ping(){
	}
	
	@RequestMapping(value="/generate", method=RequestMethod.POST)
	@ResponseBody
	public String generate(int value, char letter) throws JSONException{
		List<Treasure> treasures = generator.generate(value, letter);
		return new JsonConverter().treasureToJson(treasures);
	}

}
