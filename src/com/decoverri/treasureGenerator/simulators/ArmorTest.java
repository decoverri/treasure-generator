package com.decoverri.treasureGenerator.simulators;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.dao.ArmorDao;
import com.decoverri.treasureGenerator.logic.ArmorGenerator;
import com.decoverri.treasureGenerator.model.Armor;

public class ArmorTest {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public static void main(String[] args) {
		Transaction transaction = session.beginTransaction();
		ArmorGenerator generator = new ArmorGenerator(session);
		List<Armor> armors = generator.generate(5);
		transaction.commit();
		for (Armor armor : armors) {
			System.out.println(armor);
		}
	}

}
