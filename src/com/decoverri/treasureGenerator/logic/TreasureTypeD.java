package com.decoverri.treasureGenerator.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.interfaces.TreasureType;
import com.decoverri.treasureGenerator.logic.generator.CoinGenerator;
import com.decoverri.treasureGenerator.logic.generator.PotionGenerator;
import com.decoverri.treasureGenerator.logic.generator.ScrollGenerator;
import com.decoverri.treasureGenerator.logic.generator.WandGenerator;
import com.decoverri.treasureGenerator.reward.dao.DTreasureRewardDao;
import com.decoverri.treasureGenerator.reward.model.DTreasureReward;

public class TreasureTypeD implements TreasureType {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	DTreasureRewardDao dao = new DTreasureRewardDao(session);

	@Override
	public List<Treasure> reward(int value) {
		List<Treasure> treasures = new ArrayList<Treasure>();

		Transaction transaction = session.beginTransaction();
		DTreasureReward treasure = dao.findByValue(value);

		treasures.addAll(new CoinGenerator().generate(treasure.getCoins()));
		treasures.addAll(new PotionGenerator(session).generate(treasure.getPotions()));
		treasures.addAll(new ScrollGenerator(session).generate(treasure.getScrolls()));
		treasures.addAll(new WandGenerator(session).generate(treasure.getWands()));

		transaction.commit();
		return treasures;

	}

	@Override
	public String toString() {
		return "type D";
	}

}
