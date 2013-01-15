package com.decoverri.treasureGenerator.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.dao.ITreasureRewardDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.interfaces.TreasureType;
import com.decoverri.treasureGenerator.model.ITreasureReward;
import com.decoverri.treasureGenerator.model.MagicArmorGeneratorData;
import com.decoverri.treasureGenerator.model.MagicWeaponGeneratorData;

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
