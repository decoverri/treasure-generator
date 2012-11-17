package model;

import static enums.Currency.CP;
import static enums.Currency.GP;
import static enums.Currency.PP;
import static enums.Currency.SP;

import interfaces.Treasure;
import interfaces.TreasureType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TreasureTypeA implements TreasureType {

	DiceRoller roller = new DiceRoller();

	@Override
	public List<Treasure> reward(int value) {

		ArrayList<Treasure> treasures = new ArrayList<Treasure>();
		TreasureTypeATable tables = new TreasureTypeATable();
		HashMap<Integer, HashMap<String, Integer>> treasureTypeAMap = tables.getMap();

		HashMap<String, Integer> tableLine = treasureTypeAMap.get(value);

		int cpNumberOfDice = 0;
		if (tableLine.containsKey("CPNumberOfDice")) {
			cpNumberOfDice = tableLine.get("CPNumberOfDice");
		}
		int CPBaseDice = tableLine.get("CPBaseDice");
		int CPMultiplier = tableLine.get("CPMultiplier");

		int SPNumberOfDice = tableLine.get("SPNumberOfDice");
		int SPBaseDice = tableLine.get("SPBaseDice");
		int SPMultiplier = tableLine.get("SPMultiplier");

		int GPNumberOfDice = tableLine.get("GPNumberOfDice");
		int GPBaseDice = tableLine.get("GPBaseDice");
		int GPMultiplier = tableLine.get("GPMultiplier");

		int PPNumberOfDice = tableLine.get("PPNumberOfDice");
		int PPBaseDice = tableLine.get("PPBaseDice");
		int PPMultiplier = tableLine.get("PPMultiplier");

		if (cpNumberOfDice != 0) {
			treasures.add(generateCopperPieces(cpNumberOfDice, new Dice(
					CPBaseDice), CPMultiplier));

		}
		if (SPNumberOfDice != 0) {
			treasures.add(generateSilverPieces(SPNumberOfDice, new Dice(
					SPBaseDice), SPMultiplier));
		}
		if (GPNumberOfDice != 0) {
			treasures.add(generateGoldPieces(GPNumberOfDice, new Dice(
					GPBaseDice), GPMultiplier));
		}
		if (PPNumberOfDice != 0) {
			treasures.add(generatePlatinumPieces(PPNumberOfDice, new Dice(
					PPBaseDice), PPMultiplier));
		}

		return treasures;
	}

	private Coins generateCopperPieces(int numberOfDice, Dice baseDice, int multiplier) {
		System.out.println("-Generating copper pieces");
		int result = roller.roll(numberOfDice, baseDice) * multiplier;
		System.out.println("result: " + result + "\n");
		return new Coins(result, CP);
	}

	private Coins generateSilverPieces(int numberOfDice, Dice baseDice, int multiplier) {
		System.out.println("-Generating silver pieces");
		int result = roller.roll(numberOfDice, baseDice) * multiplier;
		System.out.println("result: " + result + "\n");
		return new Coins(result, SP);
	}

	private Coins generateGoldPieces(int numberOfDice, Dice baseDice, int multiplier) {
		System.out.println("-Generating gold pieces");
		int result = roller.roll(numberOfDice, baseDice) * multiplier;
		System.out.println("result: " + result + "\n");
		return new Coins(result, GP);
	}

	private Coins generatePlatinumPieces(int numberOfDice, Dice baseDice, int multiplier) {
		System.out.println("-Generating platinum pieces");
		int result = roller.roll(numberOfDice, baseDice) * multiplier;
		System.out.println("result: " + result + "\n");
		return new Coins(result, PP);
	}

	@Override
	public String toString() {
		return "type A";
	}
}
