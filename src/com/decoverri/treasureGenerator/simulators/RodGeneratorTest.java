package com.decoverri.treasureGenerator.simulators;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.data.model.RodGeneratorData;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.logic.generator.RodGenerator;
import com.decoverri.treasureGenerator.treasure.model.Rod;

public class RodGeneratorTest {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public static void main(String[] args) {
		Transaction transaction = session.beginTransaction();
		RodGenerator generator = new RodGenerator(session);
		RodGeneratorData data = new RodGeneratorData();
		data.setQuantity(100);
		data.setStrength(MagicItemStrength.GREATER_MAJOR);
		List<Rod> rods = generator.generate(Arrays.asList(data));
		for (Rod rod : rods) {
			System.out.println(rod);
		}
		transaction.commit();
	}

}
