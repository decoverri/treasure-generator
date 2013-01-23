package com.decoverri.treasureGenerator.logic.treasure;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.dao.reward.GTreasureRewardDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.interfaces.TreasureType;
import com.decoverri.treasureGenerator.logic.generator.CoinGenerator;
import com.decoverri.treasureGenerator.logic.generator.MagicWeaponGenerator;
import com.decoverri.treasureGenerator.logic.generator.PotionGenerator;
import com.decoverri.treasureGenerator.logic.generator.RingGenerator;
import com.decoverri.treasureGenerator.logic.generator.RodGenerator;
import com.decoverri.treasureGenerator.logic.generator.ScrollGenerator;
import com.decoverri.treasureGenerator.logic.generator.StaffGenerator;
import com.decoverri.treasureGenerator.logic.generator.WandGenerator;
import com.decoverri.treasureGenerator.logic.generator.WeaponGenerator;
import com.decoverri.treasureGenerator.logic.generator.WondrousItemGenerator;
import com.decoverri.treasureGenerator.model.reward.GTreasureReward;

public class TreasureTypeG implements TreasureType {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	GTreasureRewardDao dao = new GTreasureRewardDao(session);

	@Override
	public List<Treasure> reward(int value) {

		List<Treasure> treasures = new ArrayList<Treasure>();

		Transaction transaction = session.beginTransaction();
		GTreasureReward reward = dao.findByValue(value);

		treasures.addAll(new CoinGenerator().generate(reward.getCoins()));
		treasures.addAll(new WeaponGenerator(session).generate(reward.getNonmagicalWeapons()));
		treasures.addAll(new MagicWeaponGenerator(session).generate(reward.getWeapons()));
		treasures.addAll(new RingGenerator(session).generate(reward.getRings()));
		treasures.addAll(new StaffGenerator(session).generate(reward.getStaves()));
		treasures.addAll(new RodGenerator(session).generate(reward.getRods()));
		treasures.addAll(new WondrousItemGenerator(session).generate(reward.getWondrousItems()));
		treasures.addAll(new PotionGenerator(session).generate(reward.getPotions()));
		treasures.addAll(new ScrollGenerator(session).generate(reward.getScrolls()));
		treasures.addAll(new WandGenerator(session).generate(reward.getWands()));

		transaction.commit();
		return treasures;

	}

	@Override
	public String toString() {
		return "type G";
	}

}
