package com.decoverri.treasureGenerator.aux.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.dao.ArmorGeneratorDataDao;
import com.decoverri.treasureGenerator.data.dao.CoinGeneratorDataDao;
import com.decoverri.treasureGenerator.data.dao.MagicArmorGeneratorDataDao;
import com.decoverri.treasureGenerator.data.dao.MagicWeaponGeneratorDataDao;
import com.decoverri.treasureGenerator.data.dao.PotionGeneratorDataDao;
import com.decoverri.treasureGenerator.data.dao.RingGeneratorDataDao;
import com.decoverri.treasureGenerator.data.dao.WondrousItemGeneratorDataDao;
import com.decoverri.treasureGenerator.data.model.ArmorGeneratorData;
import com.decoverri.treasureGenerator.data.model.CoinGeneratorData;
import com.decoverri.treasureGenerator.data.model.MagicArmorGeneratorData;
import com.decoverri.treasureGenerator.data.model.MagicWeaponGeneratorData;
import com.decoverri.treasureGenerator.data.model.PotionGeneratorData;
import com.decoverri.treasureGenerator.data.model.RingGeneratorData;
import com.decoverri.treasureGenerator.data.model.WondrousItemGeneratorData;
import com.decoverri.treasureGenerator.reward.dao.FTreasureRewardDao;
import com.decoverri.treasureGenerator.reward.model.FTreasureReward;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitTreasureF {

	private Session session;

	public FitTreasureF(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("reward", FTreasureReward.class);
		xstream.alias("coingenerator", CoinGeneratorData.class);
		xstream.alias("mundanearmorgen", ArmorGeneratorData.class);
		xstream.alias("armorgenerator", MagicArmorGeneratorData.class);
		xstream.alias("weapongenerator", MagicWeaponGeneratorData.class);
		xstream.alias("ringgenerator", RingGeneratorData.class);
		xstream.alias("wondrousgenerator", WondrousItemGeneratorData.class);
		xstream.alias("potiongenerator", PotionGeneratorData.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/FTreasureReward.txt"));
		while (scanner.hasNextLine()) {
			FTreasureReward reward = (FTreasureReward) xstream.fromXML(scanner.nextLine());

			CoinGeneratorDataDao coinGenDao = new CoinGeneratorDataDao(session);
			ArmorGeneratorDataDao armorGenDao = new ArmorGeneratorDataDao(session);
			MagicArmorGeneratorDataDao magicArmorGenDao = new MagicArmorGeneratorDataDao(session);
			MagicWeaponGeneratorDataDao magicWeaponGenDao = new MagicWeaponGeneratorDataDao(session);
			RingGeneratorDataDao ringGenDao = new RingGeneratorDataDao(session);
			WondrousItemGeneratorDataDao wondrousGenDao = new WondrousItemGeneratorDataDao(session);
			PotionGeneratorDataDao potionGenDao = new PotionGeneratorDataDao(session);

			FTreasureRewardDao rewardDao = new FTreasureRewardDao(session);
			
			for (CoinGeneratorData coinGen : reward.getCoins()) {
				coinGenDao.save(coinGen);
			}
			for (ArmorGeneratorData armorGen : reward.getNonmagicalArmors()) {
				armorGenDao.save(armorGen);
			}
			for (MagicArmorGeneratorData magicArmorGen : reward.getArmors()) {
				magicArmorGenDao.save(magicArmorGen);
			}
			for (MagicWeaponGeneratorData magicWeaponGen : reward.getWeapons()) {
				magicWeaponGenDao.save(magicWeaponGen);
			}
			for (RingGeneratorData ringGen : reward.getRings()) {
				ringGenDao.save(ringGen);
			}
			for (WondrousItemGeneratorData wondrousGen : reward.getWondrousItems()) {
				wondrousGenDao.save(wondrousGen);
			}
			for (PotionGeneratorData potionGen : reward.getPotions()) {
				potionGenDao.save(potionGen);
			}
			rewardDao.save(reward);

		}
		scanner.close();
	}

}