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
import com.decoverri.treasureGenerator.treasure.model.ArtObject;

public class TreasureTypeC implements TreasureType {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	@Override
	public List<Treasure> reward(int value) {
		List<Treasure> treasures = new ArrayList<Treasure>();

		CTreasureRewardDao dao = new CTreasureRewardDao(session);
		Transaction transaction = session.beginTransaction();
		CTreasureReward treasureC = dao.findByValue(value);

		ArtObjectGenerator artGenerator = new ArtObjectGenerator(session);
		List<ArtObject> arts = artGenerator.generate(treasureC.getArts());
		treasures.addAll(arts);

		transaction.commit();
		return treasures;

	}

	@Override
	public String toString() {
		return "type C";
	}

}
