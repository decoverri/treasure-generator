package com.decoverri.treasureGenerator.logic.treasure;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.dao.reward.HTreasureRewardDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.interfaces.TreasureType;
import com.decoverri.treasureGenerator.logic.generator.ArmorGenerator;
import com.decoverri.treasureGenerator.logic.generator.CoinGenerator;
import com.decoverri.treasureGenerator.logic.generator.GemGenerator;
import com.decoverri.treasureGenerator.logic.generator.MagicArmorGenerator;
import com.decoverri.treasureGenerator.logic.generator.MagicWeaponGenerator;
import com.decoverri.treasureGenerator.logic.generator.PotionGenerator;
import com.decoverri.treasureGenerator.logic.generator.RingGenerator;
import com.decoverri.treasureGenerator.logic.generator.RodGenerator;
import com.decoverri.treasureGenerator.logic.generator.ScrollGenerator;
import com.decoverri.treasureGenerator.logic.generator.StaffGenerator;
import com.decoverri.treasureGenerator.logic.generator.WandGenerator;
import com.decoverri.treasureGenerator.logic.generator.WeaponGenerator;
import com.decoverri.treasureGenerator.logic.generator.WondrousItemGenerator;
import com.decoverri.treasureGenerator.model.data.ArmorGeneratorData;
import com.decoverri.treasureGenerator.model.data.MagicArmorGeneratorData;
import com.decoverri.treasureGenerator.model.data.MagicWeaponGeneratorData;
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
