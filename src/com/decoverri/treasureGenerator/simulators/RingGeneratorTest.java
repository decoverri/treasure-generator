package com.decoverri.treasureGenerator.simulators;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.data.model.RingGeneratorData;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.logic.generator.RingGenerator;
import com.decoverri.treasureGenerator.treasure.model.Ring;

public class RingGeneratorTest {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public static void main(String[] args) {
		Transaction transaction = session.beginTransaction();
		RingGenerator generator = new RingGenerator(session);
		RingGeneratorData data = new RingGeneratorData();
		data.setQuantity(10);
		data.setStrength(MagicItemStrength.LESSER_MINOR);
		List<Ring> rings = generator.generate(Arrays.asList(data));
		for (Ring ring : rings) {
			System.out.println(ring);
		}
		transaction.commit();
	}

}
