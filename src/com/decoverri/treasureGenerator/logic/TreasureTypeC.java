package com.decoverri.treasureGenerator.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.interfaces.TreasureType;
import com.decoverri.treasureGenerator.logic.generator.ArtObjectGenerator;
import com.decoverri.treasureGenerator.reward.dao.CTreasureRewardDao;
import com.decoverri.treasureGenerator.reward.model.CTreasureReward;

public class TreasureTypeC implements TreasureType {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	CTreasureRewardDao dao = new CTreasureRewardDao(session);

	@Override
	public List<Treasure> reward(int value) {
		List<Treasure> treasures = new ArrayList<Treasure>();

		Transaction transaction = session.beginTransaction();
		CTreasureReward treasure = dao.findByValue(value);

		treasures.addAll(new ArtObjectGenerator(session).generate(treasure.getArts()));

		transaction.commit();
		return treasures;

	}

	@Override
	public String toString() {
		return "type C";
	}

}
