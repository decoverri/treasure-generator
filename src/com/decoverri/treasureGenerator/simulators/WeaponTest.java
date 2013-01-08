package com.decoverri.treasureGenerator.simulators;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.logic.SpecificWeaponGenerator;
import com.decoverri.treasureGenerator.model.SpecificWeapon;

public class WeaponTest {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public static void main(String[] args) {
		Transaction transaction = session.beginTransaction();
		SpecificWeaponGenerator generator = new SpecificWeaponGenerator(session);
		List<SpecificWeapon> weapons = new ArrayList<SpecificWeapon>();

		for (int i = 0; i < 10; i++) {
			weapons.add(generator.generate(MagicItemStrength.LESSER_MINOR));
		}

		transaction.commit();

		for (SpecificWeapon weapon : weapons) {
			System.out.println(weapon);
		}
	}

}
