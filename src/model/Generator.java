package model;

import interfaces.Treasure;
import interfaces.TreasureType;

import java.util.List;


public class Generator {

	public List<Treasure> genarate(TreasureType type, int value){

		System.out.println("Generating " + value + "gp worth of " + type + " treasure:\n");
		return type.reward(value);
	}
}
