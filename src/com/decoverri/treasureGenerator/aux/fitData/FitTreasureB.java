package com.decoverri.treasureGenerator.aux.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.dao.CoinGeneratorDataDao;
import com.decoverri.treasureGenerator.data.dao.GemstoneGeneratorDataDao;
import com.decoverri.treasureGenerator.data.model.CoinGeneratorData;
import com.decoverri.treasureGenerator.data.model.GemstoneGeneratorData;
import com.decoverri.treasureGenerator.reward.dao.BTreasureRewardDao;
import com.decoverri.treasureGenerator.reward.model.BTreasureReward;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitTreasureB {

	private Session session;

	public FitTreasureB(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("reward", BTreasureReward.class);
		xstream.alias("coingenerator", CoinGeneratorData.class);
		xstream.alias("gemgenerator", GemstoneGeneratorData.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/BTreasureReward.txt"));
		while (scanner.hasNextLine()) {
			BTreasureReward reward = (BTreasureReward) xstream.fromXML(scanner.nextLine());

			CoinGeneratorDataDao coinGenDao = new CoinGeneratorDataDao(session);
			GemstoneGeneratorDataDao gemGenDao = new GemstoneGeneratorDataDao(session);
			BTreasureRewardDao rewardDao = new BTreasureRewardDao(session);

			for (CoinGeneratorData coinGen : reward.getCoins()) {
				coinGenDao.save(coinGen);
			}
			for (GemstoneGeneratorData gemGen : reward.getGems()) {
				gemGenDao.save(gemGen);
			}
			rewardDao.save(reward);

		}
		scanner.close();
	}
}