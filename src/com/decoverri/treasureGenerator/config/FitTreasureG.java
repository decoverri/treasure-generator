package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.CoinGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.GTreasureRewardDao;
import com.decoverri.treasureGenerator.dao.MagicWeaponGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.PotionGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.RingGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.RodGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.ScrollGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.StaffGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.WondrousItemGeneratorDataDao;
import com.decoverri.treasureGenerator.model.CoinGeneratorData;
import com.decoverri.treasureGenerator.model.FTreasureReward;
import com.decoverri.treasureGenerator.model.GTreasureReward;
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

public class FitTreasureG {

	private Session session;

	public FitTreasureG(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("reward", FTreasureReward.class);
		xstream.alias("coingenerator", CoinGeneratorData.class);
		xstream.alias("weapongenerator", MagicWeaponGeneratorData.class);
		xstream.alias("ringgenerator", RingGeneratorData.class);
		xstream.alias("staffgenerator", StaffGeneratorData.class);
		xstream.alias("rodgenerator", RodGeneratorData.class);
		xstream.alias("wondrousgenerator", WondrousItemGeneratorData.class);
		xstream.alias("potiongenerator", PotionGeneratorData.class);
		xstream.alias("scrollgenerator", ScrollGeneratorData.class);
		xstream.alias("wandgenerator", WandGeneratorData.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/GTreasureReward.txt"));
		while (scanner.hasNextLine()) {
			GTreasureReward reward = (GTreasureReward) xstream.fromXML(scanner.nextLine());

			CoinGeneratorDataDao coinGenDao = new CoinGeneratorDataDao(session);
			MagicWeaponGeneratorDataDao magicWeaponGenDao = new MagicWeaponGeneratorDataDao(session);
			RingGeneratorDataDao ringGenDao = new RingGeneratorDataDao(session);
			StaffGeneratorDataDao staffGenDao = new StaffGeneratorDataDao(session);
			RodGeneratorDataDao rodGenDao = new RodGeneratorDataDao(session);
			WondrousItemGeneratorDataDao wondrousGenDao = new WondrousItemGeneratorDataDao(session);
			PotionGeneratorDataDao potionGenDao = new PotionGeneratorDataDao(session);
			ScrollGeneratorDataDao scrollGenDao = new ScrollGeneratorDataDao(session);
			WandGeneratorDataDao wandGenDao = new WandGeneratorDataDao(session);

			GTreasureRewardDao rewardDao = new GTreasureRewardDao(session);
			
			for (CoinGeneratorData coinGen : reward.getCoins()) {
				coinGenDao.save(coinGen);
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
			rewardDao.save(reward);

		}
		scanner.close();
	}

}
