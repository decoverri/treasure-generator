package br.com.metalgames.treasureGenerator.simulators;

import java.util.List;

import br.com.metalgames.treasureGenerator.interfaces.Treasure;
import br.com.metalgames.treasureGenerator.logic.TreasureGenerator;
import br.com.metalgames.treasureGenerator.model.TreasureTypeA;

public class GeneratorTest {

	public static void main(String[] args) {

		TreasureGenerator generator = new TreasureGenerator();

		List<Treasure> treasures = generator.genarate(1, new TreasureTypeA());

		System.out.println("Finished!\n");
		System.out.println("Treasure List:");
		for (Treasure treasure : treasures) {
			System.out.println(treasure);
		}
	}
}
