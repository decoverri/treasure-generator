package com.decoverri.treasureGenerator.logic.generator;

import static com.decoverri.treasureGenerator.enums.MagicItemRarity.COMMON;
import static com.decoverri.treasureGenerator.enums.MagicItemRarity.UNCOMMON;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.model.WandGeneratorData;
import com.decoverri.treasureGenerator.enums.MagicItemRarity;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.treasure.aux.dao.WandLevelDao;
import com.decoverri.treasureGenerator.treasure.dao.WandDao;
import com.decoverri.treasureGenerator.treasure.model.Wand;

public class WandGenerator {

	private WandDao wandDao;
	private WandLevelDao wandLevelDao;
	private Dice d100;
	private DiceRoller roller;

	public WandGenerator(Session session) {
		this.wandDao = new WandDao(session);
		this.wandLevelDao = new WandLevelDao(session);
		this.d100 = new Dice(100);
		this.roller = new DiceRoller();
	}

	public List<Wand> generate(List<WandGeneratorData> wandsData) {
		List<Wand> wands = new ArrayList<Wand>();

		for (WandGeneratorData data : wandsData) {
			wands.addAll(generate(data));
		}

		return wands;
	}

	private List<Wand> generate(WandGeneratorData data) {
		List<Wand> wands = new ArrayList<Wand>();

		for (int i = 0; i < data.getQuantity(); i++) {
			wands.add(generate(data.getStrength()));
		}

		return wands;
	}

	private Wand generate(MagicItemStrength strength) {

		System.out.println("Generating " + strength + " wand");
		System.out.println("Generating spell level");

		int level = wandLevelDao.getWandLevel(strength, roller.roll(d100));

		System.out.println("Result: level " + level);
		System.out.println("Generating rarity");

		MagicItemRarity rarity = setPotionRarity(roller.roll(d100));

		System.out.println("Result: " + rarity);
		System.out.println("Generating " + rarity + " level " + level + " wand");

		Wand wand = wandDao.getWand(level, rarity, roller.roll(d100));

		System.out.println("Result: " + wand.getSpell() + "\n");

		return wand;
	}

	private MagicItemRarity setPotionRarity(int roll) {
		return (roll > 75 ? UNCOMMON : COMMON);
	}

}
