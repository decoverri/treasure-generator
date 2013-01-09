package com.decoverri.treasureGenerator.simulators;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.logic.MagicWeaponGenerator;
import com.decoverri.treasureGenerator.model.MagicWeaponGeneratorData;

public class WeaponTest {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public static void main(String[] args) {
		Transaction transaction = session.beginTransaction();
		MagicWeaponGenerator generator = new MagicWeaponGenerator(session);
		List<Treasure> weapons = new ArrayList<Treasure>();

		MagicWeaponGeneratorData data = new MagicWeaponGeneratorData();
		data.setQuantity(1000);
		data.setStrength(MagicItemStrength.GREATER_MAJOR);
		weapons.addAll(generator.generate(data));

		transaction.commit();

		for (Treasure weapon : weapons) {
			System.out.println(weapon);
		}
	}

}
