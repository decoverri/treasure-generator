package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.ArtObjectGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.CoinGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.GemstoneGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.ITreasureRewardDao;
import com.decoverri.treasureGenerator.dao.MagicArmorGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.MagicWeaponGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.PotionGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.RingGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.RodGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.ScrollGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.StaffGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.WondrousItemGeneratorDataDao;
import com.decoverri.treasureGenerator.model.ArtObjectGeneratorData;
import com.decoverri.treasureGenerator.model.CoinGeneratorData;
import com.decoverri.treasureGenerator.model.GemstoneGeneratorData;
import com.decoverri.treasureGenerator.model.ITreasureReward;
import com.decoverri.treasureGenerator.model.MagicArmorGeneratorData;
import com.decoverri.treasureGenerator.model.MagicWeaponGeneratorData;
import com.decoverri.treasureGenerator.model.PotionGeneratorData;
import com.decoverri.treasureGenerator.model.RingGeneratorData;
import com.decoverri.treasureGenerator.model.RodGeneratorData;
import com.decoverri.treasureGenerator.model.ScrollGeneratorData;
import com.decoverri.treasureGenerator.model.StaffGeneratorData;
import com.decoverri.treasureGenerator.model.WandGeneratorData;
import com.decoverri.treasureGenerator.model.WondrousItemGeneratorData;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitTreasureI {

	private Session session;

	public FitTreasureI(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("reward", ITreasureReward.class);
		xstream.alias("coingenerator", CoinGeneratorData.class);
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
		xstream.alias("artgenerator", ArtObjectGeneratorData.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/ITreasureReward.txt"));
		while (scanner.hasNextLine()) {
			ITreasureReward reward = (ITreasureReward) xstream.fromXML(scanner.nextLine());

			CoinGeneratorDataDao coinGenDao = new CoinGeneratorDataDao(session);
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
			ArtObjectGeneratorDataDao artGenDao = new ArtObjectGeneratorDataDao(session);

			ITreasureRewardDao rewardDao = new ITreasureRewardDao(session);
			
			for (CoinGeneratorData coinGen : reward.getCoins()) {
				coinGenDao.save(coinGen);
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
			for (ArtObjectGeneratorData artGen : reward.getArts()) {
				artGenDao.save(artGen);
			}
			rewardDao.save(reward);

		}
		scanner.close();
	}

}
