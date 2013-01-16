package com.decoverri.treasureGenerator.simulators;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.logic.generator.ScrollGenerator;
import com.decoverri.treasureGenerator.model.generator.ScrollGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.Scroll;

public class ScrollGeneratorTest {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public static void main(String[] args) {
		Transaction transaction = session.beginTransaction();
		ScrollGenerator generator = new ScrollGenerator(session);
		ScrollGeneratorData data = new ScrollGeneratorData();
		data.setQuantity(5);
		data.setStrength(MagicItemStrength.GREATER_MEDIUM);
		List<Scroll> scrolls = generator.generate(Arrays.asList(data));
		for (Scroll scroll : scrolls) {
			System.out.println(scroll);
		}
		transaction.commit();
	}
}
