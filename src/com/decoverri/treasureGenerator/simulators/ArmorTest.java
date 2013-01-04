package com.decoverri.treasureGenerator.simulators;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.logic.SpecificArmorGenerator;
import com.decoverri.treasureGenerator.model.SpecificArmor;

public class ArmorTest {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public static void main(String[] args) {
		Transaction transaction = session.beginTransaction();
		SpecificArmorGenerator generator = new SpecificArmorGenerator(session);
		List<SpecificArmor> armors = new ArrayList<SpecificArmor>();
		for (int i = 0; i < 10; i++) {
			armors.add(generator.generate(MagicItemStrength.GREATER_MAJOR));
			
		}
		transaction.commit();
		for (SpecificArmor armor : armors) {
			System.out.println(armor);
		}
	}

}
