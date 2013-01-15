package com.decoverri.treasureGenerator.simulators;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.logic.StaffGenerator;
import com.decoverri.treasureGenerator.model.generator.StaffGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.Staff;

public class StaffGeneratorTest {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public static void main(String[] args) {
		Transaction transaction = session.beginTransaction();
		StaffGenerator generator = new StaffGenerator(session);
		StaffGeneratorData data = new StaffGeneratorData();
		data.setQuantity(10);
		data.setStrength(MagicItemStrength.LESSER_MEDIUM);
		List<Staff> staves = generator.generate(Arrays.asList(data));
		for (Staff staff : staves) {
			System.out.println(staff);
		}
		transaction.commit();
	}

}
