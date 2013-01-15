package com.decoverri.treasureGenerator.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.dao.HTreasureRewardDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.interfaces.TreasureType;
import com.decoverri.treasureGenerator.model.generator.ArmorGeneratorData;
import com.decoverri.treasureGenerator.model.generator.MagicArmorGeneratorData;
import com.decoverri.treasureGenerator.model.generator.MagicWeaponGeneratorData;
import com.decoverri.treasureGenerator.model.reward.HTreasureReward;

public class TreasureTypeH implements TreasureType {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	@Override
	public List<Treasure> reward(int value) {

		List<Treasure> treasures = new ArrayList<Treasure>();

		HTreasureRewardDao dao = new HTreasureRewardDao(session);
		Transaction transaction = session.beginTransaction();
		HTreasureReward treasureH = dao.findByValue(value);

		CoinGenerator coinGenerator = new CoinGenerator();
		treasures.addAll(coinGenerator.generate(treasureH.getCoins()));

		ArmorGenerator armorGenerator = new ArmorGenerator(session);
		for (ArmorGeneratorData data : treasureH.getNonmagicalArmors()) {
			treasures.add(armorGenerator.generate(data.getType()));
		}
		
		MagicArmorGenerator magicArmorGenerator = new MagicArmorGenerator(session);
		for (MagicArmorGeneratorData magicArmorGenData : treasureH.getArmors()) {
			treasures.addAll(magicArmorGenerator.generate(magicArmorGenData));
		}

		WeaponGenerator weaponGenerator = new WeaponGenerator(session);
		for (int i = 0; i < treasureH.getNonmagicalWeapons(); i++) {
			treasures.add(weaponGenerator.generate());
		}

		MagicWeaponGenerator magicWeaponGenerator = new MagicWeaponGenerator(session);
		for (MagicWeaponGeneratorData magicWeaponGenData : treasureH.getWeapons()) {
			treasures.addAll(magicWeaponGenerator.generate(magicWeaponGenData));
		}

		RingGenerator ringGenerator = new RingGenerator(session);
		treasures.addAll(ringGenerator.generate(treasureH.getRings()));

		StaffGenerator staffGenerator = new StaffGenerator(session);
		treasures.addAll(staffGenerator.generate(treasureH.getStaves()));

		RodGenerator rodGenerator = new RodGenerator(session);
		treasures.addAll(rodGenerator.generate(treasureH.getRods()));

		WondrousItemGenerator wondrousGenerator = new WondrousItemGenerator(session);
		treasures.addAll(wondrousGenerator.generate(treasureH.getWondrousItems()));

		PotionGenerator potionGenerator = new PotionGenerator(session);
		treasures.addAll(potionGenerator.generate(treasureH.getPotions()));

		ScrollGenerator scrollGenerator = new ScrollGenerator(session);
		treasures.addAll(scrollGenerator.generate(treasureH.getScrolls()));

		WandGenerator wandGenerator = new WandGenerator(session);
		treasures.addAll(wandGenerator.generate(treasureH.getWands()));

		GemGenerator gemGenerator = new GemGenerator(session);
		treasures.addAll(gemGenerator.generate(treasureH.getGems()));

		transaction.commit();
		return treasures;

	}

	@Override
	public String toString() {
		return "type H";
	}

}
