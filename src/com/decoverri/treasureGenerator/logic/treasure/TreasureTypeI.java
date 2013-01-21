package com.decoverri.treasureGenerator.logic.treasure;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.dao.reward.ITreasureRewardDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.interfaces.TreasureType;
import com.decoverri.treasureGenerator.logic.generator.ArtObjectGenerator;
import com.decoverri.treasureGenerator.logic.generator.CoinGenerator;
import com.decoverri.treasureGenerator.logic.generator.GemGenerator;
import com.decoverri.treasureGenerator.logic.generator.MagicArmorGenerator;
import com.decoverri.treasureGenerator.logic.generator.MagicWeaponGenerator;
import com.decoverri.treasureGenerator.logic.generator.PotionGenerator;
import com.decoverri.treasureGenerator.logic.generator.RingGenerator;
import com.decoverri.treasureGenerator.logic.generator.RodGenerator;
import com.decoverri.treasureGenerator.logic.generator.ScrollGenerator;
import com.decoverri.treasureGenerator.logic.generator.StaffGenerator;
import com.decoverri.treasureGenerator.logic.generator.WandGenerator;
import com.decoverri.treasureGenerator.logic.generator.WondrousItemGenerator;
import com.decoverri.treasureGenerator.model.data.MagicArmorGeneratorData;
import com.decoverri.treasureGenerator.model.data.MagicWeaponGeneratorData;
import com.decoverri.treasureGenerator.model.reward.ITreasureReward;

public class TreasureTypeI implements TreasureType {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	@Override
	public List<Treasure> reward(int value) {

		List<Treasure> treasures = new ArrayList<Treasure>();

		ITreasureRewardDao dao = new ITreasureRewardDao(session);
		Transaction transaction = session.beginTransaction();
		ITreasureReward treasureI = dao.findByValue(value);

		CoinGenerator coinGenerator = new CoinGenerator();
		treasures.addAll(coinGenerator.generate(treasureI.getCoins()));
		
		MagicArmorGenerator magicArmorGenerator = new MagicArmorGenerator(session);
		for (MagicArmorGeneratorData magicArmorGenData : treasureI.getArmors()) {
			treasures.addAll(magicArmorGenerator.generate(magicArmorGenData));
		}

		MagicWeaponGenerator magicWeaponGenerator = new MagicWeaponGenerator(session);
		for (MagicWeaponGeneratorData magicWeaponGenData : treasureI.getWeapons()) {
			treasures.addAll(magicWeaponGenerator.generate(magicWeaponGenData));
		}

		RingGenerator ringGenerator = new RingGenerator(session);
		treasures.addAll(ringGenerator.generate(treasureI.getRings()));

		StaffGenerator staffGenerator = new StaffGenerator(session);
		treasures.addAll(staffGenerator.generate(treasureI.getStaves()));

		RodGenerator rodGenerator = new RodGenerator(session);
		treasures.addAll(rodGenerator.generate(treasureI.getRods()));

		WondrousItemGenerator wondrousGenerator = new WondrousItemGenerator(session);
		treasures.addAll(wondrousGenerator.generate(treasureI.getWondrousItems()));

		PotionGenerator potionGenerator = new PotionGenerator(session);
		treasures.addAll(potionGenerator.generate(treasureI.getPotions()));

		ScrollGenerator scrollGenerator = new ScrollGenerator(session);
		treasures.addAll(scrollGenerator.generate(treasureI.getScrolls()));

		WandGenerator wandGenerator = new WandGenerator(session);
		treasures.addAll(wandGenerator.generate(treasureI.getWands()));

		GemGenerator gemGenerator = new GemGenerator(session);
		treasures.addAll(gemGenerator.generate(treasureI.getGems()));

		ArtObjectGenerator artGenerator = new ArtObjectGenerator(session);
		treasures.addAll(artGenerator.generate(treasureI.getArts()));

		transaction.commit();
		return treasures;

	}

	@Override
	public String toString() {
		return "type H";
	}

}
