package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.dao.GemstoneDao;
import com.decoverri.treasureGenerator.model.Gemstone;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitGems {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("gems", Gemstone.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/gems.txt"));
		Transaction transaction = session.beginTransaction();

		while (scanner.hasNextLine()) {
			Gemstone gem = (Gemstone) xstream.fromXML(scanner.nextLine());
			GemstoneDao gemDao = new GemstoneDao(session);
			if (gemDao.exists(gem.getName())) {
				gemDao.saveOrUpdate(gem);
			}
		}

		transaction.commit();
		scanner.close();
	}

}
