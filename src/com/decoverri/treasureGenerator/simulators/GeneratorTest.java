package com.decoverri.treasureGenerator.simulators;

import java.util.List;

import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.logic.generator.TreasureGenerator;

public class GeneratorTest {


	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		long inicio = System.currentTimeMillis();

		int worth = 100000;
		char type = 'I';

		TreasureGenerator generator = new TreasureGenerator();
		List<Treasure> treasures = generator.genarate(worth, type);

		System.out.println("Treasure List:");
		double totalPrice = 0;
		for (Treasure treasure : treasures) {
			totalPrice += treasure.getTreasureValue();
			System.out.println(treasure);
		}
		System.out.println("\nGenerated value: " + totalPrice + "gp");

		long fim = System.currentTimeMillis();
		System.out.println("Total time: " + (fim - inicio)/1000.0 + "s");
	}
}