package com.decoverri.treasureGenerator.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.dao.DTreasureRewardDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.interfaces.TreasureType;
import com.decoverri.treasureGenerator.model.reward.DTreasureReward;
import com.decoverri.treasureGenerator.model.treasure.Coins;

public class TreasureTypeD implements TreasureType {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	@Override
	public List<Treasure> reward(int value) {
		List<Treasure> treasures = new ArrayList<Treasure>();

		DTreasureRewardDao dao = new DTreasureRewardDao(session);
		Transaction transaction = session.beginTransaction();
		DTreasureReward treasureD = dao.findByValue(value);

		CoinGenerator coinGenerator = new CoinGenerator();
		List<Coins> coins = coinGenerator.generate(treasureD.getCoins());
		treasures.addAll(coins);

		PotionGenerator potionGenerator = new PotionGenerator(session);
		treasures.addAll(potionGenerator.generate(treasureD.getPotions()));

		ScrollGenerator scrollGenerator = new ScrollGenerator(session);
		treasures.addAll(scrollGenerator.generate(treasureD.getScrolls()));

		WandGenerator wandGenerator = new WandGenerator(session);
		treasures.addAll(wandGenerator.generate(treasureD.getWands()));

		transaction.commit();
		return treasures;

	}

	@Override
	public String toString() {
		return "type D";
	}

}
