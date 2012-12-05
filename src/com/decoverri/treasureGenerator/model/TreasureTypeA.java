package com.decoverri.treasureGenerator.model;

import static com.decoverri.treasureGenerator.enums.Currency.CP;
import static com.decoverri.treasureGenerator.enums.Currency.GP;
import static com.decoverri.treasureGenerator.enums.Currency.PP;
import static com.decoverri.treasureGenerator.enums.Currency.SP;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.dao.CoinRewardDao;
import com.decoverri.treasureGenerator.enums.Currency;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.interfaces.TreasureType;
import com.decoverri.treasureGenerator.logic.DiceRoller;



public class TreasureTypeA implements TreasureType {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
	DiceRoller roller = new DiceRoller();

	@Override
	public List<Treasure> reward(int value) {

		List<Treasure> treasures = new ArrayList<Treasure>();

		CoinRewardDao dao = new CoinRewardDao(session);
		Transaction transaction = session.beginTransaction();
		CoinReward coinReward = dao.findByValue(value);
		
		for (CoinGenerator coinGenerator : coinReward.getCoins()) {
			Coins coins = generatePieces(coinGenerator.getCurrency(), coinGenerator.getNumberOfDice(), coinGenerator.getDice(), coinGenerator.getMultiplier());
			treasures.add(coins);
		}

		transaction.commit();
		return treasures;
	}

	private Coins generatePieces(Currency currency, int numberOfDice, Dice baseDice, int multiplier) {
		System.out.println("Generating " + currency);
		int result = roller.roll(numberOfDice, baseDice) * multiplier;
		System.out.println("result: " + result + "\n");
		return new Coins(result, currency);
	}

	@Override
	public String toString() {
		return "type A";
	}
}
