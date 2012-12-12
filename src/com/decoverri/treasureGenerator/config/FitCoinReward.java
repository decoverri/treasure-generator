package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.dao.CoinRewardDao;
import com.decoverri.treasureGenerator.model.CoinGenerator;
import com.decoverri.treasureGenerator.model.CoinReward;
import com.decoverri.treasureGenerator.model.Dice;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitCoinReward {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public void fitCoinReward() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("CoinReward", CoinReward.class);
		xstream.alias("coins", CoinGenerator.class);
		xstream.alias("dice", Dice.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/coinRewardJson.txt"));
		CoinReward coinReward = (CoinReward) xstream.fromXML(scanner.nextLine());

		CoinRewardDao dao = new CoinRewardDao(session);
		Transaction transaction = session.beginTransaction();

		dao.save(coinReward);

		transaction.commit();
		scanner.close();
	}
}
