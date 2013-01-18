package com.decoverri.treasureGenerator.aux.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.dao.ArmorGeneratorDataDao;
import com.decoverri.treasureGenerator.data.dao.CoinGeneratorDataDao;
import com.decoverri.treasureGenerator.data.dao.GemstoneGeneratorDataDao;
import com.decoverri.treasureGenerator.data.dao.MagicArmorGeneratorDataDao;
import com.decoverri.treasureGenerator.data.dao.MagicWeaponGeneratorDataDao;
import com.decoverri.treasureGenerator.data.dao.PotionGeneratorDataDao;
import com.decoverri.treasureGenerator.data.dao.RingGeneratorDataDao;
import com.decoverri.treasureGenerator.data.dao.RodGeneratorDataDao;
import com.decoverri.treasureGenerator.data.dao.ScrollGeneratorDataDao;
import com.decoverri.treasureGenerator.data.dao.StaffGeneratorDataDao;
import com.decoverri.treasureGenerator.data.dao.WandGeneratorDataDao;
import com.decoverri.treasureGenerator.data.dao.WondrousItemGeneratorDataDao;
import com.decoverri.treasureGenerator.data.model.ArmorGeneratorData;
import com.decoverri.treasureGenerator.data.model.CoinGeneratorData;
import com.decoverri.treasureGenerator.data.model.GemstoneGeneratorData;
import com.decoverri.treasureGenerator.data.model.MagicArmorGeneratorData;
import com.decoverri.treasureGenerator.data.model.MagicWeaponGeneratorData;
import com.decoverri.treasureGenerator.data.model.PotionGeneratorData;
import com.decoverri.treasureGenerator.data.model.RingGeneratorData;
import com.decoverri.treasureGenerator.data.model.RodGeneratorData;
import com.decoverri.treasureGenerator.data.model.ScrollGeneratorData;
import com.decoverri.treasureGenerator.data.model.StaffGeneratorData;
import com.decoverri.treasureGenerator.data.model.WandGeneratorData;
import com.decoverri.treasureGenerator.data.model.WondrousItemGeneratorData;
import com.decoverri.treasureGenerator.reward.dao.HTreasureRewardDao;
import com.decoverri.treasureGenerator.reward.model.HTreasureReward;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitTreasureH {

	private Session session;

	public FitTreasureH(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("reward", HTreasureReward.class);
		xstream.alias("coingenerator", CoinGeneratorData.class);
		xstream.alias("mundanearmorgen", ArmorGeneratorData.class);
		xstream.alias("armorgenerator", MagicArmorGeneratorData.class);
		xstream.alias("weapongenerator", MagicWeaponGeneratorData.class);
		xstream.alias("ringgenerator", RingGeneratorData.class);
		xstream.alias("staffgenerator", StaffGeneratorData.class);
		xstream.alias("rodgenerator", RodGeneratorData.class);
		xstream.alias("wondrousgenerator", WondrousItemGeneratorData.class);
		xstream.alias("potiongenerator", PotionGeneratorData.class);
		xstream.alias("scrollgenerator", ScrollGeneratorData.class);
		xstream.alias("wandgenerator", WandGeneratorData.class);
		xstream.alias("gemgenerator", GemstoneGeneratorData.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/HTreasureReward.txt"));
		while (scanner.hasNextLine()) {
			HTreasureReward reward = (HTreasureReward) xstream.fromXML(scanner.nextLine());

			CoinGeneratorDataDao coinGenDao = new CoinGeneratorDataDao(session);
			ArmorGeneratorDataDao armorGenDao = new ArmorGeneratorDataDao(session);
			MagicArmorGeneratorDataDao magicArmorGenDao = new MagicArmorGeneratorDataDao(session);
			MagicWeaponGeneratorDataDao magicWeaponGenDao = new MagicWeaponGeneratorDataDao(session);
			RingGeneratorDataDao ringGenDao = new RingGeneratorDataDao(session);
			StaffGeneratorDataDao staffGenDao = new StaffGeneratorDataDao(session);
			RodGeneratorDataDao rodGenDao = new RodGeneratorDataDao(session);
			WondrousItemGeneratorDataDao wondrousGenDao = new WondrousItemGeneratorDataDao(session);
			PotionGeneratorDataDao potionGenDao = new PotionGeneratorDataDao(session);
			ScrollGeneratorDataDao scrollGenDao = new ScrollGeneratorDataDao(session);
			WandGeneratorDataDao wandGenDao = new WandGeneratorDataDao(session);
			GemstoneGeneratorDataDao gemGenDao = new GemstoneGeneratorDataDao(session);

			HTreasureRewardDao rewardDao = new HTreasureRewardDao(session);
			
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
			for (StaffGeneratorData staffGen : reward.getStaves()) {
				staffGenDao.save(staffGen);
			}
			for (RodGeneratorData rodGen : reward.getRods()) {
				rodGenDao.save(rodGen);
			}
			for (WondrousItemGeneratorData wondrousGen : reward.getWondrousItems()) {
				wondrousGenDao.save(wondrousGen);
			}
			for (PotionGeneratorData potionGen : reward.getPotions()) {
				potionGenDao.save(potionGen);
			}
			for (ScrollGeneratorData scrollGen : reward.getScrolls()) {
				scrollGenDao.save(scrollGen);
			}
			for (WandGeneratorData wandGen : reward.getWands()) {
				wandGenDao.save(wandGen);
			}
			for (GemstoneGeneratorData gemGen : reward.getGems()) {
				gemGenDao.save(gemGen);
			}
			rewardDao.save(reward);

		}
		scanner.close();
	}

}