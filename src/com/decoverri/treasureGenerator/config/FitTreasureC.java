package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.dao.ArtObjectGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.CTreasureRewardDao;
import com.decoverri.treasureGenerator.model.ArtObjectGeneratorData;
import com.decoverri.treasureGenerator.model.CTreasureReward;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitTreasureC {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("reward", CTreasureReward.class);
		xstream.alias("artgenerator", ArtObjectGeneratorData.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/CTreasureReward.txt"));
		Transaction transaction = session.beginTransaction();

		while (scanner.hasNextLine()) {
			CTreasureReward reward = (CTreasureReward) xstream.fromXML(scanner.nextLine());

			ArtObjectGeneratorDataDao artGenDao = new ArtObjectGeneratorDataDao(session);
			CTreasureRewardDao rewardDao = new CTreasureRewardDao(session);

			for (ArtObjectGeneratorData artGen : reward.getArts()) {
				artGenDao.save(artGen);
			}
			rewardDao.save(reward);

		}

		transaction.commit();
		scanner.close();
	}
}
