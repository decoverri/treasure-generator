package br.com.generator.test;

import br.com.generator.model.Dice;
import br.com.generator.model.DiceRoller;

public class RollerTest {

	public static void main(String[] args) {

		Dice d4 = new Dice(4);
		Dice d6 = new Dice(6);
		Dice d8 = new Dice(8);
		Dice d10 = new Dice(10);
		Dice d12 = new Dice(12);
		Dice d20 = new Dice(20);
		Dice d100 = new Dice(100);

		DiceRoller diceRoller = new DiceRoller();

		int total4 = diceRoller.roll(5, d4, 5);
		System.out.println("Total: " + total4);
		int total6 = diceRoller.roll(10, d6);
		System.out.println("Total: " + total6);
		int total8 = diceRoller.roll(2, d8, 10);
		System.out.println("Total: " + total8);
		int total10 = diceRoller.roll(1, d10, 3);
		System.out.println("Total: " + total10);
		int total12 = diceRoller.roll(1, d12, 10);
		System.out.println("Total: " + total12);
		int total20 = diceRoller.roll(1, d20, 16);
		System.out.println("Total: " + total20);
		int total100 = diceRoller.roll(5, d100);
		System.out.println("Total: " + total100);



	}
}
