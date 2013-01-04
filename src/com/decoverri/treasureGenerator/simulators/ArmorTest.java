package com.decoverri.treasureGenerator.simulators;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.logic.MagicArmorGenerator;
import com.decoverri.treasureGenerator.model.MagicArmorGeneratorData;

public class ArmorTest {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public static void main(String[] args) {
		Transaction transaction = session.beginTransaction();
		MagicArmorGenerator generator = new MagicArmorGenerator(session);
		List<Treasure> armors = new ArrayList<Treasure>();
		
		MagicArmorGeneratorData data = new MagicArmorGeneratorData();
		data.setQuantity(100);
		data.setStrength(MagicItemStrength.GREATER_MAJOR);
		armors.addAll(generator.generate(data));

		transaction.commit();
		for (Treasure armor : armors) {
			System.out.println(armor);
		}
	}

}
