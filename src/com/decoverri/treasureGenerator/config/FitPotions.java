package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.dao.PotionDao;
import com.decoverri.treasureGenerator.model.Potion;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitPotions {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("potion", Potion.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/potions.txt"));
		Transaction transaction = session.beginTransaction();

		while (scanner.hasNextLine()) {
			Potion potion = (Potion) xstream.fromXML(scanner.nextLine());
			PotionDao potionDao = new PotionDao(session);
			if (!potionDao.exists(potion.getSpell())) {
				potionDao.saveOrUpdate(potion);
			}
		}

		transaction.commit();
		scanner.close();
	}

}
