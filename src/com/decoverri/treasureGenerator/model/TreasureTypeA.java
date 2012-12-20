package com.decoverri.treasureGenerator.model;

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

	@Override
	public List<Treasure> reward(int value) {

		List<Treasure> treasures = new ArrayList<Treasure>();

		CoinRewardDao dao = new CoinRewardDao(session);
		Transaction transaction = session.beginTransaction();
		CoinReward coinReward = dao.findByValue(value);

		for (CoinGenerator coinGenerator : coinReward.getCoins()) {
			Coins coins = generatePieces(coinGenerator.getCurrency(), coinGenerator.getDice(),coinGenerator.getMultiplier());
			treasures.add(coins);
		}

		transaction.commit();
		return treasures;
	}

	private Coins generatePieces(Currency currency, Dice dice, int multiplier) {
		
		System.out.println("Generating " + currency);
		int result = new DiceRoller().roll(dice) * multiplier;
		System.out.println("Result: " + result + "\n");
		return new Coins(result, currency);
	}

	@Override
	public String toString() {
		return "type A";
	}
}
