package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.dao.CoinGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.ATreasureRewardDao;
import com.decoverri.treasureGenerator.model.CoinGeneratorData;
import com.decoverri.treasureGenerator.model.ATreasureReward;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitTreasureA {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("coinreward", ATreasureReward.class);
		xstream.alias("coingenerator", CoinGeneratorData.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/ATreasureReward.txt"));
		Transaction transaction = session.beginTransaction();

		while (scanner.hasNextLine()) {
			ATreasureReward reward = (ATreasureReward) xstream.fromXML(scanner.nextLine());

			CoinGeneratorDataDao generatorDao = new CoinGeneratorDataDao(session);
			ATreasureRewardDao rewardDao = new ATreasureRewardDao(session);

			if (rewardDao.findByValue(reward.getValue()) == null) {
				for (CoinGeneratorData coinGen : reward.getCoins()) {
					generatorDao.save(coinGen);
				}
				rewardDao.save(reward);
			}

		}

		transaction.commit();
		scanner.close();
	}
}
