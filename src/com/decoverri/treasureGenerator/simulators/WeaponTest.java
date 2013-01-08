package com.decoverri.treasureGenerator.simulators;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.logic.WeaponGenerator;
import com.decoverri.treasureGenerator.model.Weapon;

public class WeaponTest {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public static void main(String[] args) {
		Transaction transaction = session.beginTransaction();
		WeaponGenerator generator = new WeaponGenerator(session);
		List<Weapon> weapons = new ArrayList<Weapon>();

		for (int i = 0; i < 10; i++) {
			weapons.add(generator.generate());
		}

		transaction.commit();

		for (Weapon weapon : weapons) {
			System.out.println(weapon);
		}
	}

}
