package com.decoverri.treasureGenerator.simulators;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.logic.generator.SpecificArmorGenerator;

public class ArmorTest {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public static void main(String[] args) {
		Transaction transaction = session.beginTransaction();
		SpecificArmorGenerator generator = new SpecificArmorGenerator(session);
		List<Treasure> armors = new ArrayList<Treasure>();
		
		for (int i = 0; i < 100; i++) {
			armors.add(generator.generate(MagicItemStrength.GREATER_MINOR));
		}

		transaction.commit();
		for (Treasure armor : armors) {
			System.out.println(armor);
		}
	}

}
