package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.dao.ArtObjectDao;
import com.decoverri.treasureGenerator.model.ArtObject;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitArtObjects {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("art", ArtObject.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/artObjects.txt"));
		Transaction transaction = session.beginTransaction();

		while (scanner.hasNextLine()) {
			ArtObject art = (ArtObject) xstream.fromXML(scanner.nextLine());
			ArtObjectDao artDao = new ArtObjectDao(session);
			if (!artDao.exists(art.getName())) {
				artDao.saveOrUpdate(art);
			}
		}

		transaction.commit();
		scanner.close();
	}

}
