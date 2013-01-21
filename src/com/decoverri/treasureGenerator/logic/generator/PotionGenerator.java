package com.decoverri.treasureGenerator.logic.generator;

import static com.decoverri.treasureGenerator.enums.MagicItemRarity.COMMON;
import static com.decoverri.treasureGenerator.enums.MagicItemRarity.UNCOMMON;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.treasure.PotionDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.PotionLevelDao;
import com.decoverri.treasureGenerator.enums.MagicItemRarity;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.data.PotionGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.Potion;

public class PotionGenerator {

	private PotionDao potionDao;
	private PotionLevelDao potionLevelDao;
	private DiceRoller roller;
	private Dice d100;

	public PotionGenerator(Session session) {
		this.potionDao = new PotionDao(session);
		this.potionLevelDao = new PotionLevelDao(session);
		this.roller = new DiceRoller();
		this.d100 = new Dice(100);
	}

	public List<Potion> generate(List<PotionGeneratorData> potionsData) {
		List<Potion> potions = new ArrayList<Potion>();

		for (PotionGeneratorData data : potionsData) {
			return generate(data);
		}

		return potions;
	}

	private List<Potion> generate(PotionGeneratorData data) {

		List<Potion> potions = new ArrayList<Potion>();

		for (int i = 0; i < data.getQuantity(); i++) {
			potions.add(generate(data.getStrength()));
		}
		return potions;
	}

	private Potion generate(MagicItemStrength strength) {

		System.out.println("Generating " + strength + " potion");
		System.out.println("Generating spell level");

		int level = potionLevelDao.getPotionLevel(strength, roller.roll(d100));
		System.out.println("Result: level " + level);

		MagicItemRarity rarity = COMMON;
		if (level > 0) {
			System.out.println("Generating rarity");
			rarity = setPotionRarity(roller.roll(d100));
			System.out.println("Result: " + rarity);
		}

		System.out.println("Generating " + rarity + " level " + level + " potion");

		Potion potion = potionDao.getPotion(level, rarity, roller.roll(d100));

		System.out.println("Result: " + potion.getSpell() + "\n");

		return potion;
	}

	private MagicItemRarity setPotionRarity(int roll) {
		return (roll > 75 ? UNCOMMON : COMMON);
	}

}
