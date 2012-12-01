package br.com.metalgames.treasureGenerator.logic;


import java.util.List;

import br.com.metalgames.treasureGenerator.interfaces.Treasure;
import br.com.metalgames.treasureGenerator.interfaces.TreasureType;

public class TreasureGenerator {

	public List<Treasure> genarate(int value, TreasureType type) {

		System.out.println("Generating " + value + "gp worth of " + type + " treasure:\n");
		return type.reward(value);
	}
}
