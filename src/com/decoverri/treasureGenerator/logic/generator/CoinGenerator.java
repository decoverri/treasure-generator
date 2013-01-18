package com.decoverri.treasureGenerator.logic.generator;

import java.util.ArrayList;
import java.util.List;

import com.decoverri.treasureGenerator.data.model.CoinGeneratorData;
import com.decoverri.treasureGenerator.enums.Currency;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.treasure.model.Coins;

public class CoinGenerator {

	private DiceRoller roller = new DiceRoller();

	public Coins generate(CoinGeneratorData data) {
		return generatePieces(data.getCurrency(), data.getDice(), data.getMultiplier());
	}

	public List<Coins> generate(List<CoinGeneratorData> datas) {
		List<Coins> coins = new ArrayList<Coins>();

		for (CoinGeneratorData data : datas) {
			coins.add(generate(data));
		}

		return coins;
	}

	private Coins generatePieces(Currency currency, Dice dice, int multiplier) {
		System.out.println("Generating " + currency);

		int result = roller.roll(dice) * multiplier;
		System.out.println("Result: " + result + "\n");

		return new Coins(result, currency);
	}

}
