package com.decoverri.treasureGenerator.logic.generator;


import java.util.List;

import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.interfaces.TreasureType;

public class TreasureGenerator {

	public List<Treasure> genarate(int value, TreasureType type) {

		System.out.println("Generating " + value + "gp worth of " + type + " treasure:\n");
		return type.reward(value);
	}
}
