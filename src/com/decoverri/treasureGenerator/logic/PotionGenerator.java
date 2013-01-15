package com.decoverri.treasureGenerator.logic;

import static com.decoverri.treasureGenerator.enums.MagicItemRarity.COMMON;
import static com.decoverri.treasureGenerator.enums.MagicItemRarity.UNCOMMON;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.PotionDao;
import com.decoverri.treasureGenerator.dao.PotionLevelDao;
import com.decoverri.treasureGenerator.enums.MagicItemRarity;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.generator.PotionGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.Potion;

public class PotionGenerator {

	private Session session;

	public PotionGenerator(Session session) {
		this.session = session;
	}

	public List<Potion> generate(List<PotionGeneratorData> potionsData) {

		List<Potion> potions = new ArrayList<Potion>();
		PotionDao potionDao = new PotionDao(session);
		PotionLevelDao potionLevelDao = new PotionLevelDao(session);
		Dice d100 = new Dice(100);
		DiceRoller roller = new DiceRoller();

		for (PotionGeneratorData potionData : potionsData) {
			for (int i = 0; i < potionData.getQuantity(); i++) {
				System.out.println("Generating " + potionData.getStrength() + " potion");
				System.out.println("Generating spell level");
				int level = potionLevelDao.getPotionLevel(potionData.getStrength(), roller.roll(d100));
				System.out.println("Result: level " + level);
				MagicItemRarity rarity = MagicItemRarity.COMMON;
				if (level > 0) {
					System.out.println("Generating rarity");
					rarity = setPotionRarity(roller.roll(d100));
					System.out.println("Result: " + rarity);
				}
				System.out.println("Generating " + rarity + " level " + level + " potion");
				Potion potion = potionDao.getPotion(level, rarity, roller.roll(d100));
				System.out.println("Result: " + potion.getSpell() + "\n");
				potions.add(potion);
			}
		}

		return potions;
	}

	private MagicItemRarity setPotionRarity(int roll) {
		return (roll > 75 ? UNCOMMON : COMMON);
	}

}
