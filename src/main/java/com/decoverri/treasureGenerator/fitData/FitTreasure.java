package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.dao.GeneratorDataDao;
import com.decoverri.treasureGenerator.dao.TreasureRewardDao;
import com.decoverri.treasureGenerator.model.TreasureReward;
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
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

@Component
public class FitTreasure {

	@Autowired
	private TreasureRewardDao rewardDao;
	@Autowired
	private GeneratorDataDao genDao;

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

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/treasureReward.json"));
		while (scanner.hasNextLine()) {
			TreasureReward reward = (TreasureReward) xstream.fromXML(scanner.nextLine());

			for (CoinGeneratorData coinGen : reward.getCoins()) {
				genDao.save(coinGen);
			}
			for (ArmorGeneratorData armorGen : reward.getNonmagicalArmors()) {
				genDao.save(armorGen);
			}
			for (MagicArmorGeneratorData magicArmorGen : reward.getArmors()) {
				genDao.save(magicArmorGen);
			}
			for (MagicWeaponGeneratorData magicWeaponGen : reward.getWeapons()) {
				genDao.save(magicWeaponGen);
			}
			for (RingGeneratorData ringGen : reward.getRings()) {
				genDao.save(ringGen);
			}
			for (StaffGeneratorData staffGen : reward.getStaves()) {
				genDao.save(staffGen);
			}
			for (RodGeneratorData rodGen : reward.getRods()) {
				genDao.save(rodGen);
			}
			for (WondrousItemGeneratorData wondrousGen : reward.getWondrousItems()) {
				genDao.save(wondrousGen);
			}
			for (PotionGeneratorData potionGen : reward.getPotions()) {
				genDao.save(potionGen);
			}
			for (ScrollGeneratorData scrollGen : reward.getScrolls()) {
				genDao.save(scrollGen);
			}
			for (WandGeneratorData wandGen : reward.getWands()) {
				genDao.save(wandGen);
			}
			for (GemstoneGeneratorData gemGen : reward.getGems()) {
				genDao.save(gemGen);
			}
			for (ArtObjectGeneratorData artGen : reward.getArts()) {
				genDao.save(artGen);
			}
			rewardDao.save(reward);

		}
		scanner.close();
	}

}
