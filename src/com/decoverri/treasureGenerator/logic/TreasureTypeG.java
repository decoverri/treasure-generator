package com.decoverri.treasureGenerator.logic;

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
import com.decoverri.treasureGenerator.model.generator.MagicWeaponGeneratorData;
import com.decoverri.treasureGenerator.model.reward.GTreasureReward;

public class TreasureTypeG implements TreasureType {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	@Override
	public List<Treasure> reward(int value) {

		List<Treasure> treasures = new ArrayList<Treasure>();

		GTreasureRewardDao dao = new GTreasureRewardDao(session);
		Transaction transaction = session.beginTransaction();
		GTreasureReward treasureG = dao.findByValue(value);

		CoinGenerator coinGenerator = new CoinGenerator();
		treasures.addAll(coinGenerator.generate(treasureG.getCoins()));

		WeaponGenerator weaponGenerator = new WeaponGenerator(session);
		for (int i = 0; i < treasureG.getNonmagicalWeapons(); i++) {
			treasures.add(weaponGenerator.generate());
		}

		MagicWeaponGenerator magicWeaponGenerator = new MagicWeaponGenerator(session);
		for (MagicWeaponGeneratorData magicWeaponGenData : treasureG.getWeapons()) {
			treasures.addAll(magicWeaponGenerator.generate(magicWeaponGenData));
		}

		RingGenerator ringGenerator = new RingGenerator(session);
		treasures.addAll(ringGenerator.generate(treasureG.getRings()));

		StaffGenerator staffGenerator = new StaffGenerator(session);
		treasures.addAll(staffGenerator.generate(treasureG.getStaves()));

		RodGenerator rodGenerator = new RodGenerator(session);
		treasures.addAll(rodGenerator.generate(treasureG.getRods()));

		WondrousItemGenerator wondrousGenerator = new WondrousItemGenerator(session);
		treasures.addAll(wondrousGenerator.generate(treasureG.getWondrousItems()));

		PotionGenerator potionGenerator = new PotionGenerator(session);
		treasures.addAll(potionGenerator.generate(treasureG.getPotions()));

		ScrollGenerator scrollGenerator = new ScrollGenerator(session);
		treasures.addAll(scrollGenerator.generate(treasureG.getScrolls()));

		WandGenerator wandGenerator = new WandGenerator(session);
		treasures.addAll(wandGenerator.generate(treasureG.getWands()));

		transaction.commit();
		return treasures;

	}

	@Override
	public String toString() {
		return "type G";
	}

}
