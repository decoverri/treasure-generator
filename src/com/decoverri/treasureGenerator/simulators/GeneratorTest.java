package com.decoverri.treasureGenerator.simulators;

import java.util.List;

import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.interfaces.TreasureType;
import com.decoverri.treasureGenerator.logic.TreasureGenerator;

public class GeneratorTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		int worth = 50000;
		String type = "TreasureTypeC";

		String fullType = "com.decoverri.treasureGenerator.logic." + type;

		TreasureGenerator generator = new TreasureGenerator();

		List<Treasure> treasures = generator.genarate(worth, (TreasureType) Class.forName(fullType).newInstance());

		System.out.println("Finished!\n");
		System.out.println("Treasure List:");
		for (Treasure treasure : treasures) {
			System.out.println(treasure);
		}
	}
}