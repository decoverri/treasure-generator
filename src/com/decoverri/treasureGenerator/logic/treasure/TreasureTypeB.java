package com.decoverri.treasureGenerator.logic.treasure;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.dao.reward.BTreasureRewardDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.interfaces.TreasureType;
import com.decoverri.treasureGenerator.logic.generator.CoinGenerator;
import com.decoverri.treasureGenerator.logic.generator.GemGenerator;
import com.decoverri.treasureGenerator.model.reward.BTreasureReward;

public class TreasureTypeB implements TreasureType {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	BTreasureRewardDao dao = new BTreasureRewardDao(session);

	@Override
	public List<Treasure> reward(int value) {
		List<Treasure> treasures = new ArrayList<Treasure>();

		Transaction transaction = session.beginTransaction();
		BTreasureReward treasure = dao.findByValue(value);

		treasures.addAll(new CoinGenerator().generate(treasure.getCoins()));
		treasures.addAll(new GemGenerator(session).generate(treasure.getGems()));

		transaction.commit();
		return treasures;

	}

	@Override
	public String toString() {
		return "type B";
	}

}
