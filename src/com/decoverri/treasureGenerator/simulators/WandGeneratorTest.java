package com.decoverri.treasureGenerator.simulators;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.logic.WandGenerator;
import com.decoverri.treasureGenerator.model.generator.WandGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.Wand;

public class WandGeneratorTest {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public static void main(String[] args) {
		Transaction transaction = session.beginTransaction();
		WandGenerator generator = new WandGenerator(session);
		WandGeneratorData data = new WandGeneratorData();
		data.setQuantity(10);
		data.setStrength(MagicItemStrength.GREATER_MAJOR);
		List<Wand> wands = generator.generate(Arrays.asList(data));
		for (Wand wand : wands) {
			System.out.println(wand);
		}
		transaction.commit();
	}
}
