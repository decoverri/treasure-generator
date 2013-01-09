package com.decoverri.treasureGenerator.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.dao.ETreasureRewardDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.interfaces.TreasureType;
import com.decoverri.treasureGenerator.model.ArmorGeneratorData;
import com.decoverri.treasureGenerator.model.ETreasureReward;
import com.decoverri.treasureGenerator.model.MagicArmorGeneratorData;
import com.decoverri.treasureGenerator.model.MagicWeaponGeneratorData;

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

		WeaponGenerator weaponGenerator = new WeaponGenerator(session);
		for (int i = 0; i < treasureE.getNonmagicalWeapons(); i++) {
			treasures.add(weaponGenerator.generate());
		}

		MagicArmorGenerator magicArmorGenerator = new MagicArmorGenerator(session);
		for (MagicArmorGeneratorData magicArmorGenData : treasureE.getArmors()) {
			treasures.addAll(magicArmorGenerator.generate(magicArmorGenData));
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
