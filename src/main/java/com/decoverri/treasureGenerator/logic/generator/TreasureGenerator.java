package com.decoverri.treasureGenerator.logic.generator;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.controller.TreasureTypes;
import com.decoverri.treasureGenerator.dao.TreasureRewardDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.model.TreasureReward;
import com.decoverri.treasureGenerator.model.TreasureType;
import com.decoverri.treasureGenerator.model.TreasureTypeValue;

@Component
public class TreasureGenerator {

	@Autowired
	private Session session;

	@Autowired
	CoinGenerator coinGenerator;

	@Autowired
	private ArmorGenerator armorGenerator;

	@Autowired
	private MagicArmorGenerator magicArmorGenerator;

	@Autowired
	private WeaponGenerator weaponGenerator;

	@Autowired
	private MagicWeaponGenerator magicWeaponGenerator;

	@Autowired
	private RingGenerator ringGenerator;

	@Autowired
	private StaffGenerator staffGenerator;

	@Autowired
	private RodGenerator rodGenerator;

	@Autowired
	private WondrousItemGenerator wondrousItemGenerator;

	@Autowired
	private PotionGenerator potionGenerator;

	@Autowired
	private ScrollGenerator scrollGenerator;

	@Autowired
	private WandGenerator wandGenerator;

	@Autowired
	private GemGenerator gemGenerator;

	@Autowired
	private ArtObjectGenerator artObjectGenerator;

	@Autowired
	private TreasureRewardDao dao;

	public List<Treasure> generate(TreasureTypes types) {
		List<Treasure> treasures = new ArrayList<Treasure>();
		for (TreasureType treasureType : types.getTreasureTypes()) {
			if (treasureType.getValues() != null) {
				treasures.addAll(generate(treasureType));
			}
		}
		return treasures;
	}

	private List<Treasure> generate(TreasureType treasureType) {
		List<Treasure> treasures = new ArrayList<Treasure>();
		for (TreasureTypeValue treasureTypeValue : treasureType.getValues()) {
			if (treasureTypeValue != null) {
				treasures.addAll(generate(treasureTypeValue.getValue(), treasureType.getLetter()));
			}
		}
		return treasures;
	}

	public List<Treasure> generate(int value, char type) {
		List<Treasure> treasures = new ArrayList<Treasure>();
		System.out.println("Generating " + value + "gp worth of Type " + type + " treasure:\n");

		Transaction transaction = session.beginTransaction();
		TreasureReward reward = dao.findByValue(type, value);

		treasures.addAll(coinGenerator.generate(reward.getCoins()));
		treasures.addAll(armorGenerator.generate(reward.getNonmagicalArmors()));
		treasures.addAll(magicArmorGenerator.generate(reward.getArmors()));
		treasures.addAll(weaponGenerator.generate(reward.getNonmagicalWeapons()));
		treasures.addAll(magicWeaponGenerator.generate(reward.getWeapons()));
		treasures.addAll(ringGenerator.generate(reward.getRings()));
		treasures.addAll(staffGenerator.generate(reward.getStaves()));
		treasures.addAll(rodGenerator.generate(reward.getRods()));
		treasures.addAll(wondrousItemGenerator.generate(reward.getWondrousItems()));
		treasures.addAll(potionGenerator.generate(reward.getPotions()));
		treasures.addAll(scrollGenerator.generate(reward.getScrolls()));
		treasures.addAll(wandGenerator.generate(reward.getWands()));
		treasures.addAll(gemGenerator.generate(reward.getGems()));
		treasures.addAll(artObjectGenerator.generate(reward.getArts()));

		transaction.commit();

		System.out.println("Finished!\n");
		return treasures;
	}

}
