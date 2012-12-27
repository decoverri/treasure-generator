package com.decoverri.treasureGenerator.logic;

import java.util.ArrayList;
import java.util.List;

import com.decoverri.treasureGenerator.enums.Currency;
import com.decoverri.treasureGenerator.model.CoinGeneratorData;
import com.decoverri.treasureGenerator.model.Coins;
import com.decoverri.treasureGenerator.model.Dice;

public class CoinGenerator {

	public List<Coins> generate(List<CoinGeneratorData> coinData) {

		List<Coins> coins = new ArrayList<Coins>();

		for (CoinGeneratorData coin : coinData) {
			Coins pieces = generatePieces(coin.getCurrency(), coin.getDice(), coin.getMultiplier());
			coins.add(pieces);
		}
		return coins;
	}

	private Coins generatePieces(Currency currency, Dice dice, int multiplier) {

		System.out.println("Generating " + currency);
		int result = new DiceRoller().roll(dice) * multiplier;
		System.out.println("Result: " + result + "\n");
		return new Coins(result, currency);
	}

}