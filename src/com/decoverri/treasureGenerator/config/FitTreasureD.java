package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.CoinGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.DTreasureRewardDao;
import com.decoverri.treasureGenerator.dao.PotionGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.ScrollGeneratorDataDao;
import com.decoverri.treasureGenerator.model.CoinGeneratorData;
import com.decoverri.treasureGenerator.model.DTreasureReward;
import com.decoverri.treasureGenerator.model.PotionGeneratorData;
import com.decoverri.treasureGenerator.model.ScrollGeneratorData;
import com.decoverri.treasureGenerator.model.WandGeneratorData;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitTreasureD {

	private Session session;

	public FitTreasureD(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("reward", DTreasureReward.class);
		xstream.alias("coingenerator", CoinGeneratorData.class);
		xstream.alias("potiongenerator", PotionGeneratorData.class);
		xstream.alias("scrollgenerator", ScrollGeneratorData.class);
		xstream.alias("wandgenerator", WandGeneratorData.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/DTreasureReward.txt"));
		while (scanner.hasNextLine()) {
			DTreasureReward reward = (DTreasureReward) xstream.fromXML(scanner.nextLine());

			CoinGeneratorDataDao coinGenDao = new CoinGeneratorDataDao(session);
			PotionGeneratorDataDao potionGenDao = new PotionGeneratorDataDao(session);
			ScrollGeneratorDataDao scrollGenDao = new ScrollGeneratorDataDao(session);
			WandGeneratorDataDao wandGenDao = new WandGeneratorDataDao(session);
			DTreasureRewardDao rewardDao = new DTreasureRewardDao(session);

			for (CoinGeneratorData coinGen : reward.getCoins()) {
				coinGenDao.save(coinGen);
			}
			rewardDao.save(reward);
			for (PotionGeneratorData potionGen : reward.getPotions()) {
				potionGenDao.save(potionGen);
			}
			rewardDao.save(reward);
			for (ScrollGeneratorData scrollGen : reward.getScrolls()) {
				scrollGenDao.save(scrollGen);
			}
			rewardDao.save(reward);
			for (WandGeneratorData wandGen : reward.getWands()) {
				wandGenDao.save(wandGen);
			}
			rewardDao.save(reward);

		}
		scanner.close();
	}
}
