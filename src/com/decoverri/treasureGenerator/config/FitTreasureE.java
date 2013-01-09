package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.CoinGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.DTreasureRewardDao;
import com.decoverri.treasureGenerator.dao.ETreasureRewardDao;
import com.decoverri.treasureGenerator.dao.PotionGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.ScrollGeneratorDataDao;
import com.decoverri.treasureGenerator.model.CoinGeneratorData;
import com.decoverri.treasureGenerator.model.DTreasureReward;
import com.decoverri.treasureGenerator.model.ETreasureReward;
import com.decoverri.treasureGenerator.model.MagicArmorGeneratorData;
import com.decoverri.treasureGenerator.model.MagicWeaponGeneratorData;
import com.decoverri.treasureGenerator.model.PotionGeneratorData;
import com.decoverri.treasureGenerator.model.ScrollGeneratorData;
import com.decoverri.treasureGenerator.model.WandGeneratorData;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitTreasureE {

	private Session session;

	public FitTreasureE(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("reward", ETreasureReward.class);
		xstream.alias("armorgenerator", MagicArmorGeneratorData.class);
		xstream.alias("weapongenerator", MagicWeaponGeneratorData.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/ETreasureReward.txt"));
		while (scanner.hasNextLine()) {
			ETreasureReward reward = (ETreasureReward) xstream.fromXML(scanner.nextLine());

			MagicArmorGeneratorDataDao magicArmorGenDao = new MagicArmorGeneratorDataDao(session);
			MagicWeaponGeneratorDataDao magicWeaponGenDao = new MagicWeaponGeneratorDataDao(session);
			ETreasureRewardDao rewardDao = new ETreasureRewardDao(session);

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
