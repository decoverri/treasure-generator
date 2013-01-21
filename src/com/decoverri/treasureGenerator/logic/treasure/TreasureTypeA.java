package com.decoverri.treasureGenerator.logic.treasure;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.dao.reward.ATreasureRewardDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.interfaces.TreasureType;
import com.decoverri.treasureGenerator.logic.generator.CoinGenerator;
import com.decoverri.treasureGenerator.model.reward.ATreasureReward;

public class TreasureTypeA implements TreasureType {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	ATreasureRewardDao dao = new ATreasureRewardDao(session);

	@Override
	public List<Treasure> reward(int value) {
		List<Treasure> treasures = new ArrayList<Treasure>();

		Transaction transaction = session.beginTransaction();
		ATreasureReward treasure = dao.findByValue(value);

		treasures.addAll(new CoinGenerator().generate(treasure.getCoins()));

		transaction.commit();
		return treasures;
	}

	@Override
	public String toString() {
		return "type A";
	}
}
