package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.ATreasureRewardDao;
import com.decoverri.treasureGenerator.dao.CoinGeneratorDataDao;
import com.decoverri.treasureGenerator.model.generator.CoinGeneratorData;
import com.decoverri.treasureGenerator.model.reward.ATreasureReward;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitTreasureA {

	private Session session;

	public FitTreasureA(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("reward", ATreasureReward.class);
		xstream.alias("coingenerator", CoinGeneratorData.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/ATreasureReward.txt"));
		while (scanner.hasNextLine()) {
			ATreasureReward reward = (ATreasureReward) xstream.fromXML(scanner.nextLine());

			CoinGeneratorDataDao coinGenDao = new CoinGeneratorDataDao(session);
			ATreasureRewardDao rewardDao = new ATreasureRewardDao(session);

			if (rewardDao.findByValue(reward.getValue()) == null) {
				for (CoinGeneratorData coinGen : reward.getCoins()) {
					coinGenDao.save(coinGen);
				}
				rewardDao.save(reward);
			}

		}
		scanner.close();
	}
}
