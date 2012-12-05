package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.dao.CoinRewardDao;
import com.decoverri.treasureGenerator.model.CoinReward;

public class FitCoinReward {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public void fitCoinReward() throws IOException {

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/coinReward.txt"));
		CoinRewardDao dao = new CoinRewardDao(session);
		Transaction transaction = session.beginTransaction();

		while (scanner.hasNextLine()) {
			CoinReward coinReward = new CoinReward();

			coinReward.setValue(scanner.nextInt());
//
//			coinReward.setCpNumberOfDice(scanner.nextInt());
//			coinReward.setCpBaseDiceSize(scanner.nextInt());
//			coinReward.setCpMultiplier(scanner.nextInt());
//
//			coinReward.setSpNumberOfDice(scanner.nextInt());
//			coinReward.setSpBaseDiceSize(scanner.nextInt());
//			coinReward.setSpMultiplier(scanner.nextInt());
//
//			coinReward.setGpNumberOfDice(scanner.nextInt());
//			coinReward.setGpBaseDiceSize(scanner.nextInt());
//			coinReward.setGpMultiplier(scanner.nextInt());
//
//			coinReward.setPpNumberOfDice(scanner.nextInt());
//			coinReward.setPpBaseDiceSize(scanner.nextInt());
//			coinReward.setPpMultiplier(scanner.nextInt());

			if (dao.findByValue(coinReward.getValue()) == null) {
				dao.save(coinReward);
			}

		}

		transaction.commit();
		scanner.close();
	}
}
