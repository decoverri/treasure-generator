package com.decoverri.treasureGenerator.simulators;

import java.util.List;

import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.logic.TreasureGenerator;
import com.decoverri.treasureGenerator.model.TreasureTypeA;


public class GeneratorTest {

	public static void main(String[] args) {

		TreasureGenerator generator = new TreasureGenerator();

		List<Treasure> treasures = generator.genarate(200, new TreasureTypeA());

		System.out.println("Finished!\n");
		System.out.println("Treasure List:");
		for (Treasure treasure : treasures) {
			System.out.println(treasure);
		}
	}
}
