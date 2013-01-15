package com.decoverri.treasureGenerator.simulators;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.logic.PotionGenerator;
import com.decoverri.treasureGenerator.model.generator.PotionGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.Potion;

public class PotionGeneratorTest {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public static void main(String[] args) {
		Transaction transaction = session.beginTransaction();
		PotionGenerator generator = new PotionGenerator(session);
		PotionGeneratorData data = new PotionGeneratorData();
		data.setQuantity(3);
		data.setStrength(MagicItemStrength.GREATER_MAJOR);
		List<Potion> potions = generator.generate(Arrays.asList(data));
		for (Potion potion : potions) {
			System.out.println(potion);
		}
		transaction.commit();
	}
}
