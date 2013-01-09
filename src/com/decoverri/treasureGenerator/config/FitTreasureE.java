package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.ArmorGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.ETreasureRewardDao;
import com.decoverri.treasureGenerator.dao.MagicArmorGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.MagicWeaponGeneratorDataDao;
import com.decoverri.treasureGenerator.model.ArmorGeneratorData;
import com.decoverri.treasureGenerator.model.ETreasureReward;
import com.decoverri.treasureGenerator.model.MagicArmorGeneratorData;
import com.decoverri.treasureGenerator.model.MagicWeaponGeneratorData;
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
		xstream.alias("mundanearmorgen", ArmorGeneratorData.class);
		xstream.alias("armorgenerator", MagicArmorGeneratorData.class);
		xstream.alias("weapongenerator", MagicWeaponGeneratorData.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/ETreasureReward.txt"));
		while (scanner.hasNextLine()) {
			ETreasureReward reward = (ETreasureReward) xstream.fromXML(scanner.nextLine());

			ArmorGeneratorDataDao armorGenDao = new ArmorGeneratorDataDao(session);
			MagicArmorGeneratorDataDao magicArmorGenDao = new MagicArmorGeneratorDataDao(session);
			MagicWeaponGeneratorDataDao magicWeaponGenDao = new MagicWeaponGeneratorDataDao(session);
			ETreasureRewardDao rewardDao = new ETreasureRewardDao(session);
			
			for (ArmorGeneratorData armorGen : reward.getNonmagicalArmors()) {
				armorGenDao.save(armorGen);
			}
			for (MagicWeaponGeneratorData magicWeaponGen : reward.getWeapons()) {
				magicWeaponGenDao.save(magicWeaponGen);
			}
			for (MagicArmorGeneratorData magicArmorGen : reward.getArmors()) {
				magicArmorGenDao.save(magicArmorGen);
			}
			rewardDao.save(reward);

		}
		scanner.close();
	}

}
