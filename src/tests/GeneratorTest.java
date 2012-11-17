package tests;

import interfaces.Treasure;

import java.util.List;

import model.Generator;
import model.TreasureTypeA;


public class GeneratorTest {

	public static void main(String[] args) {
		
		Generator generator = new Generator();
		
		List<Treasure> treasures = generator.genarate(new TreasureTypeA(), 1);
		
		System.out.println("Finished!\n");
		System.out.println("Treasure List:");
		for (Treasure treasure : treasures) {
			System.out.println(treasure);
		}
	}
}
