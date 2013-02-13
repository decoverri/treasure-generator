package com.decoverri.treasureGenerator.logic.generator;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.dao.reward.TreasureRewardDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.model.reward.TreasureReward;

public class TreasureGenerator {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	TreasureRewardDao dao = new TreasureRewardDao(session);

	public List<Treasure> genarate(int value, char type) {
		List<Treasure> treasures = new ArrayList<Treasure>();
		System.out.println("Generating " + value + "gp worth of Type " + type + " treasure:\n");

		Transaction transaction = session.beginTransaction();
		TreasureReward reward = dao.findByValue(type, value);

		treasures.addAll(new CoinGenerator().generate(reward.getCoins()));
		treasures.addAll(new ArmorGenerator(session).generate(reward.getNonmagicalArmors()));
		treasures.addAll(new MagicArmorGenerator(session).generate(reward.getArmors()));
		treasures.addAll(new WeaponGenerator(session).generate(reward.getNonmagicalWeapons()));
		treasures.addAll(new MagicWeaponGenerator(session).generate(reward.getWeapons()));
		treasures.addAll(new RingGenerator(session).generate(reward.getRings()));
		treasures.addAll(new StaffGenerator(session).generate(reward.getStaves()));
		treasures.addAll(new RodGenerator(session).generate(reward.getRods()));
		treasures.addAll(new WondrousItemGenerator(session).generate(reward.getWondrousItems()));
		treasures.addAll(new PotionGenerator(session).generate(reward.getPotions()));
		treasures.addAll(new ScrollGenerator(session).generate(reward.getScrolls()));
		treasures.addAll(new WandGenerator(session).generate(reward.getWands()));
		treasures.addAll(new GemGenerator(session).generate(reward.getGems()));
		treasures.addAll(new ArtObjectGenerator(session).generate(reward.getArts()));

		transaction.commit();

		return treasures;
	}
}
