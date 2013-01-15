package com.decoverri.treasureGenerator.simulators;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.logic.WondrousItemGenerator;
import com.decoverri.treasureGenerator.model.generator.WondrousItemGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.WondrousItem;

public class WondrousTest {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public static void main(String[] args) {
		Transaction transaction = session.beginTransaction();
		WondrousItemGenerator generator = new WondrousItemGenerator(session);
		WondrousItemGeneratorData data = new WondrousItemGeneratorData();
		data.setQuantity(100);
		data.setStrength(MagicItemStrength.GREATER_MEDIUM);
		List<WondrousItem> items = generator.generate(Arrays.asList(data));
		for (WondrousItem item : items) {
			System.out.println(item);
		}
		transaction.commit();
	}

}
