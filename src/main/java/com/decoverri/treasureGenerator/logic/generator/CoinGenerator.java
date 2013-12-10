package com.decoverri.treasureGenerator.logic.generator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.enums.Currency;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.treasure.Coins;
import com.decoverri.treasureGenerator.model.treasure.data.CoinGeneratorData;

@Component
public class CoinGenerator {

	private DiceRoller roller;

	public CoinGenerator() {
		this.roller = new DiceRoller();
	}

	public List<Coins> generate(List<CoinGeneratorData> datas) {
		List<Coins> coins = new ArrayList<Coins>();

		for (CoinGeneratorData data : datas) {
			coins.add(generate(data));
		}

		return coins;
	}

	private Coins generate(CoinGeneratorData data) {
		return generatePieces(data.getCurrency(), data.getDice(), data.getMultiplier());
	}

	private Coins generatePieces(Currency currency, Dice dice, int multiplier) {
		System.out.println("Generating " + currency);

		int result = roller.roll(dice) * multiplier;
		System.out.println("Result: " + result + "\n");

		return new Coins(result, currency);
	}

}
