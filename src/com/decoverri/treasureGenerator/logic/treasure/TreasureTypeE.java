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
import com.decoverri.treasureGenerator.model.data.ArmorGeneratorData;
import com.decoverri.treasureGenerator.model.data.MagicArmorGeneratorData;
import com.decoverri.treasureGenerator.model.data.MagicWeaponGeneratorData;
import com.decoverri.treasureGenerator.model.reward.ETreasureReward;

public class TreasureTypeE implements TreasureType {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	@Override
	public List<Treasure> reward(int value) {
		List<Treasure> treasures = new ArrayList<Treasure>();

		ETreasureRewardDao dao = new ETreasureRewardDao(session);
		Transaction transaction = session.beginTransaction();
		ETreasureReward treasureE = dao.findByValue(value);

		ArmorGenerator armorGenerator = new ArmorGenerator(session);
		for (ArmorGeneratorData data : treasureE.getNonmagicalArmors()) {
			treasures.add(armorGenerator.generate(data.getType()));
		}
		
		MagicArmorGenerator magicArmorGenerator = new MagicArmorGenerator(session);
		for (MagicArmorGeneratorData magicArmorGenData : treasureE.getArmors()) {
			treasures.addAll(magicArmorGenerator.generate(magicArmorGenData));
		}

		WeaponGenerator weaponGenerator = new WeaponGenerator(session);
		for (int i = 0; i < treasureE.getNonmagicalWeapons(); i++) {
			treasures.add(weaponGenerator.generate());
		}

		MagicWeaponGenerator magicWeaponGenerator = new MagicWeaponGenerator(session);
		for (MagicWeaponGeneratorData magicWeaponGenData : treasureE.getWeapons()) {
			treasures.addAll(magicWeaponGenerator.generate(magicWeaponGenData));
		}

		transaction.commit();
		return treasures;

	}

	@Override
	public String toString() {
		return "type E";
	}

}
