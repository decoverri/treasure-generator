package com.decoverri.treasureGenerator.logic.treasure;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.dao.reward.ETreasureRewardDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.interfaces.TreasureType;
import com.decoverri.treasureGenerator.logic.generator.ArmorGenerator;
import com.decoverri.treasureGenerator.logic.generator.MagicArmorGenerator;
import com.decoverri.treasureGenerator.logic.generator.MagicWeaponGenerator;
import com.decoverri.treasureGenerator.logic.generator.WeaponGenerator;
import com.decoverri.treasureGenerator.model.reward.ETreasureReward;

public class TreasureTypeE implements TreasureType {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	ETreasureRewardDao dao = new ETreasureRewardDao(session);

	@Override
	public List<Treasure> reward(int value) {
		List<Treasure> treasures = new ArrayList<Treasure>();

		Transaction transaction = session.beginTransaction();
		ETreasureReward reward = dao.findByValue(value);

		treasures.addAll(new ArmorGenerator(session).generate(reward.getNonmagicalArmors()));
		treasures.addAll(new MagicArmorGenerator(session).generate(reward.getArmors()));
		treasures.addAll(new WeaponGenerator(session).generate(reward.getNonmagicalWeapons()));
		treasures.addAll(new MagicWeaponGenerator(session).generate(reward.getWeapons()));

		transaction.commit();
		return treasures;

	}

	@Override
	public String toString() {
		return "type E";
	}

}
