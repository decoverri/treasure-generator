package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.CoinRewardDao;
import com.decoverri.treasureGenerator.model.CoinReward;

public class FitCoinReward {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public void fitCoinReward() throws IOException {

		Scanner scanner = new Scanner(new FileInputStream("build/fitTxt/coinReward.txt"));

		while (scanner.hasNextLine()) {
			CoinReward coinReward = new CoinReward();

			coinReward.setValue(scanner.nextInt());

			coinReward.setCpNumberOfDice(scanner.nextInt());
			coinReward.setCpBaseDiceSize(scanner.nextInt());
			coinReward.setCpMultiplier(scanner.nextInt());

			coinReward.setSpNumberOfDice(scanner.nextInt());
			coinReward.setSpBaseDiceSize(scanner.nextInt());
			coinReward.setSpMultiplier(scanner.nextInt());

			coinReward.setGpNumberOfDice(scanner.nextInt());
			coinReward.setGpBaseDiceSize(scanner.nextInt());
			coinReward.setGpMultiplier(scanner.nextInt());

			coinReward.setPpNumberOfDice(scanner.nextInt());
			coinReward.setPpBaseDiceSize(scanner.nextInt());
			coinReward.setPpMultiplier(scanner.nextInt());

			CoinRewardDao dao = new CoinRewardDao(session);
			dao.save(coinReward);

		}

		scanner.close();
	}
}
