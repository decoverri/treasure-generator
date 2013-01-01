package com.decoverri.treasureGenerator.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.dao.DTreasureRewardDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.interfaces.TreasureType;
import com.decoverri.treasureGenerator.model.Coins;
import com.decoverri.treasureGenerator.model.DTreasureReward;
import com.decoverri.treasureGenerator.model.Potion;
import com.decoverri.treasureGenerator.model.Scroll;
import com.decoverri.treasureGenerator.model.Wand;

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
		List<Potion> potions = potionGenerator.generate(treasureD.getPotions());
		treasures.addAll(potions);

		ScrollGenerator scrollGenerator = new ScrollGenerator(session);
		List<Scroll> scrolls = scrollGenerator.generate(treasureD.getScrolls());
		treasures.addAll(scrolls);

		WandGenerator wandGenerator = new WandGenerator(session);
		List<Wand> wands = wandGenerator.generate(treasureD.getWands());
		treasures.addAll(wands);

		transaction.commit();
		return treasures;

	}

	@Override
	public String toString() {
		return "type D";
	}

}
