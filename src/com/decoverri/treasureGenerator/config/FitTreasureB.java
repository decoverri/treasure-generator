package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.dao.BTreasureRewardDao;
import com.decoverri.treasureGenerator.dao.CoinGeneratorDataDao;
import com.decoverri.treasureGenerator.model.BTreasureReward;
import com.decoverri.treasureGenerator.model.CoinGeneratorData;
import com.decoverri.treasureGenerator.model.Gemstone;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitTreasureB {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("coinreward", BTreasureReward.class);
		xstream.alias("coingenerator", CoinGeneratorData.class);
		xstream.alias("gem", Gemstone.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/BtreasureReward.txt"));
		Transaction transaction = session.beginTransaction();

		while (scanner.hasNextLine()) {
			BTreasureReward reward = (BTreasureReward) xstream.fromXML(scanner.nextLine());

			CoinGeneratorDataDao generatorDao = new CoinGeneratorDataDao(session);
			BTreasureRewardDao rewardDao = new BTreasureRewardDao(session);

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
