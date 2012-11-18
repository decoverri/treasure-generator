package emulators;

import interfaces.Treasure;

import java.util.List;

import model.TreasureGenerator;
import model.TreasureTypeA;


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
