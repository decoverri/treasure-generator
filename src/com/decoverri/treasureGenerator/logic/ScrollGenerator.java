package com.decoverri.treasureGenerator.logic;

import static com.decoverri.treasureGenerator.enums.MagicItemRarity.COMMON;
import static com.decoverri.treasureGenerator.enums.MagicItemRarity.UNCOMMON;
import static com.decoverri.treasureGenerator.enums.MagicType.ARCANE;
import static com.decoverri.treasureGenerator.enums.MagicType.DIVINE;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.ScrollDao;
import com.decoverri.treasureGenerator.dao.ScrollLevelDao;
import com.decoverri.treasureGenerator.enums.MagicItemRarity;
import com.decoverri.treasureGenerator.enums.MagicType;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.Scroll;
import com.decoverri.treasureGenerator.model.ScrollGeneratorData;

public class ScrollGenerator {

	private Session session;

	public ScrollGenerator(Session session) {
		this.session = session;
	}

	public List<Scroll> generate(List<ScrollGeneratorData> scrollsData) {

		List<Scroll> scrolls = new ArrayList<Scroll>();
		ScrollDao scrollDao = new ScrollDao(session);
		ScrollLevelDao scrollLevelDao = new ScrollLevelDao(session);
		Dice d100 = new Dice(100);
		DiceRoller roller = new DiceRoller();

		for (ScrollGeneratorData scrollData : scrollsData) {
			for (int i = 0; i < scrollData.getQuantity(); i++) {
				System.out.println("Generating " + scrollData.getStrength() + " scroll");
				System.out.println("Generating spell level");
				int level = scrollLevelDao.getScrollLevel(scrollData.getStrength(), roller.roll(d100));
				System.out.println("Result: level " + level);
				System.out.println("Generating type and rarity");
				int typeAndRarityRoll = roller.roll(d100);
				MagicType type = setScrollType(typeAndRarityRoll);
				MagicItemRarity rarity = setScrollRarity(typeAndRarityRoll);
				System.out.println("Result: " + rarity + " " + type);
				System.out.println("Generating " + rarity + " " + type + " level " + level + " scroll");
				Scroll scroll = scrollDao.getScroll(level, rarity, type, roller.roll(d100));
				System.out.println("Result: " + scroll.getSpell() + "\n");
				scrolls.add(scroll);
			}
		}

		return scrolls;
	}

	private MagicType setScrollType(int roll) {
		return (roll < 61 ? ARCANE : DIVINE);
		
	}

	private MagicItemRarity setScrollRarity(int roll) {
		return (roll < 46 || (roll > 60 && roll < 91) ? COMMON : UNCOMMON);
	}


}
