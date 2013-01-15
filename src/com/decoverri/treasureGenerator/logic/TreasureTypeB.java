package com.decoverri.treasureGenerator.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.dao.BTreasureRewardDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.interfaces.TreasureType;
import com.decoverri.treasureGenerator.model.reward.BTreasureReward;
import com.decoverri.treasureGenerator.model.treasure.Coins;
import com.decoverri.treasureGenerator.model.treasure.Gemstone;

public class TreasureTypeB implements TreasureType {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	@Override
	public List<Treasure> reward(int value) {
		List<Treasure> treasures = new ArrayList<Treasure>();

		BTreasureRewardDao dao = new BTreasureRewardDao(session);
		Transaction transaction = session.beginTransaction();
		BTreasureReward treasureB = dao.findByValue(value);

		CoinGenerator coinGenerator = new CoinGenerator();
		List<Coins> coins = coinGenerator.generate(treasureB.getCoins());
		treasures.addAll(coins);

		GemGenerator gemGenerator = new GemGenerator(session);
		List<Gemstone> gems = gemGenerator.generate(treasureB.getGems());
		treasures.addAll(gems);
		
		transaction.commit();
		return treasures;

	}

	@Override
	public String toString() {
		return "type B";
	}

}
