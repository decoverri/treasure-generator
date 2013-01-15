package com.decoverri.treasureGenerator.simulators;

import java.util.List;

import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.interfaces.TreasureType;
import com.decoverri.treasureGenerator.logic.TreasureGenerator;

public class GeneratorTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		long inicio = System.currentTimeMillis();

		int worth = 12500;
		String type = "TreasureTypeG";

		String fullType = "com.decoverri.treasureGenerator.logic." + type;

		TreasureGenerator generator = new TreasureGenerator();

		List<Treasure> treasures = generator.genarate(worth, (TreasureType) Class.forName(fullType).newInstance());

		System.out.println("Finished!\n");
		System.out.println("Treasure List:");
		for (Treasure treasure : treasures) {
			System.out.println(treasure);
		}

		long fim = System.currentTimeMillis();
		System.out.println("\nTempo de Execução: " + (fim - inicio));
	}
}