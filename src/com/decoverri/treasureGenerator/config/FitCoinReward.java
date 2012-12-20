package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.dao.CoinGeneratorDao;
import com.decoverri.treasureGenerator.dao.CoinRewardDao;
import com.decoverri.treasureGenerator.model.CoinGenerator;
import com.decoverri.treasureGenerator.model.CoinReward;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitCoinReward {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public void fitCoinReward() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("coinreward", CoinReward.class);
		xstream.alias("coingenerator", CoinGenerator.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/coinRewardJson.txt"));
		Transaction transaction = session.beginTransaction();

		while (scanner.hasNextLine()) {
			CoinReward coinReward = (CoinReward) xstream.fromXML(scanner.nextLine());

			CoinGeneratorDao generatorDao = new CoinGeneratorDao(session);
			CoinRewardDao rewardDao = new CoinRewardDao(session);

			if (rewardDao.findByValue(coinReward.getValue()) == null) {
				for (CoinGenerator coinGen : coinReward.getCoins()) {
					generatorDao.save(coinGen);
				}
				rewardDao.save(coinReward);
			}

		}

		transaction.commit();
		scanner.close();
	}
}
