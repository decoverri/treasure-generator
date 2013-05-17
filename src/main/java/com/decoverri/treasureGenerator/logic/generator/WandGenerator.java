package com.decoverri.treasureGenerator.logic.generator;

import static com.decoverri.treasureGenerator.enums.MagicItemRarity.COMMON;
import static com.decoverri.treasureGenerator.enums.MagicItemRarity.UNCOMMON;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.dao.treasure.WandDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.WandLevelDao;
import com.decoverri.treasureGenerator.enums.MagicItemRarity;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.data.WandGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.Wand;

@Component
public class WandGenerator {

	@Autowired
	private WandDao wandDao;
	@Autowired
	private WandLevelDao wandLevelDao;

	private Dice d100;
	private DiceRoller roller;

	public WandGenerator() {
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
