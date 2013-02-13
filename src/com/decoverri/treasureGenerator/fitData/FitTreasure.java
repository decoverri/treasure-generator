package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.data.ArmorGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.data.ArtObjectGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.data.CoinGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.data.GemstoneGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.data.MagicArmorGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.data.MagicWeaponGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.data.PotionGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.data.RingGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.data.RodGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.data.ScrollGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.data.StaffGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.data.WandGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.data.WondrousItemGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.reward.TreasureRewardDao;
import com.decoverri.treasureGenerator.model.data.ArmorGeneratorData;
import com.decoverri.treasureGenerator.model.data.ArtObjectGeneratorData;
import com.decoverri.treasureGenerator.model.data.CoinGeneratorData;
import com.decoverri.treasureGenerator.model.data.GemstoneGeneratorData;
import com.decoverri.treasureGenerator.model.data.MagicArmorGeneratorData;
import com.decoverri.treasureGenerator.model.data.MagicWeaponGeneratorData;
import com.decoverri.treasureGenerator.model.data.PotionGeneratorData;
import com.decoverri.treasureGenerator.model.data.RingGeneratorData;
import com.decoverri.treasureGenerator.model.data.RodGeneratorData;
import com.decoverri.treasureGenerator.model.data.ScrollGeneratorData;
import com.decoverri.treasureGenerator.model.data.StaffGeneratorData;
import com.decoverri.treasureGenerator.model.data.WandGeneratorData;
import com.decoverri.treasureGenerator.model.data.WondrousItemGeneratorData;
import com.decoverri.treasureGenerator.model.reward.TreasureReward;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitTreasure {

	private CoinGeneratorDataDao coinGenDao;
	private ArmorGeneratorDataDao armorGenDao;
	private MagicArmorGeneratorDataDao magicArmorGenDao;
	private MagicWeaponGeneratorDataDao magicWeaponGenDao;
	private RingGeneratorDataDao ringGenDao;
	private StaffGeneratorDataDao staffGenDao;
	private RodGeneratorDataDao rodGenDao;
	private WondrousItemGeneratorDataDao wondrousGenDao;
	private PotionGeneratorDataDao potionGenDao;
	private ScrollGeneratorDataDao scrollGenDao;
	private WandGeneratorDataDao wandGenDao;
	private GemstoneGeneratorDataDao gemGenDao;
	private ArtObjectGeneratorDataDao artGenDao;

	private TreasureRewardDao rewardDao;

	public FitTreasure(Session session) {
		this.coinGenDao = new CoinGeneratorDataDao(session);
		this.armorGenDao = new ArmorGeneratorDataDao(session);
		this.magicArmorGenDao = new MagicArmorGeneratorDataDao(session);
		this.magicWeaponGenDao = new MagicWeaponGeneratorDataDao(session);
		this.ringGenDao = new RingGeneratorDataDao(session);
		this.staffGenDao = new StaffGeneratorDataDao(session);
		this.rodGenDao = new RodGeneratorDataDao(session);
		this.wondrousGenDao = new WondrousItemGeneratorDataDao(session);
		this.potionGenDao = new PotionGeneratorDataDao(session);
		this.scrollGenDao = new ScrollGeneratorDataDao(session);
		this.wandGenDao = new WandGeneratorDataDao(session);
		this.gemGenDao = new GemstoneGeneratorDataDao(session);
		this.artGenDao = new ArtObjectGeneratorDataDao(session);
		this.rewardDao = new TreasureRewardDao(session);
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("reward", TreasureReward.class);
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
		xstream.alias("artgenerator", ArtObjectGeneratorData.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/treasureReward.txt"));
		while (scanner.hasNextLine()) {
			TreasureReward reward = (TreasureReward) xstream.fromXML(scanner.nextLine());

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
			for (ArtObjectGeneratorData artGen : reward.getArts()) {
				artGenDao.save(artGen);
			}
			rewardDao.save(reward);

		}
		scanner.close();
	}

}
