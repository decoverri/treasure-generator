package com.decoverri.treasureGenerator.logic;

import static com.decoverri.treasureGenerator.enums.MagicItemRarity.COMMON;
import static com.decoverri.treasureGenerator.enums.MagicItemRarity.UNCOMMON;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.WandDao;
import com.decoverri.treasureGenerator.dao.WandLevelDao;
import com.decoverri.treasureGenerator.enums.MagicItemRarity;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.generator.WandGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.Wand;

public class WandGenerator {

	private Session session;

	public WandGenerator(Session session) {
		this.session = session;
	}

	public List<Wand> generate(List<WandGeneratorData> wandsData) {

		List<Wand> wands = new ArrayList<Wand>();
		WandDao wandDao = new WandDao(session);
		WandLevelDao wandLevelDao = new WandLevelDao(session);
		Dice d100 = new Dice(100);
		DiceRoller roller = new DiceRoller();

		for (WandGeneratorData wandData : wandsData) {
			for (int i = 0; i < wandData.getQuantity(); i++) {
				System.out.println("Generating " + wandData.getStrength() + " wand");
				System.out.println("Generating spell level");
				int level = wandLevelDao.getWandLevel(wandData.getStrength(), roller.roll(d100));
				System.out.println("Result: level " + level);
				System.out.println("Generating rarity");
				MagicItemRarity rarity = setPotionRarity(roller.roll(d100));
				System.out.println("Result: " + rarity);
				System.out.println("Generating " + rarity + " level " + level + " wand");
				Wand wand = wandDao.getWand(level, rarity, roller.roll(d100));
				System.out.println("Result: " + wand.getSpell() + "\n");
				wands.add(wand);
			}
		}

		return wands;
	}

	private MagicItemRarity setPotionRarity(int roll) {
		return (roll > 75 ? UNCOMMON : COMMON);
	}

}
