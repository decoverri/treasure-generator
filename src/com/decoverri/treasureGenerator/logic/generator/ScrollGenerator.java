package com.decoverri.treasureGenerator.logic.generator;

import static com.decoverri.treasureGenerator.enums.MagicItemRarity.COMMON;
import static com.decoverri.treasureGenerator.enums.MagicItemRarity.UNCOMMON;
import static com.decoverri.treasureGenerator.enums.MagicType.ARCANE;
import static com.decoverri.treasureGenerator.enums.MagicType.DIVINE;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.model.ScrollGeneratorData;
import com.decoverri.treasureGenerator.enums.MagicItemRarity;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.enums.MagicType;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.treasure.aux.dao.ScrollLevelDao;
import com.decoverri.treasureGenerator.treasure.dao.ScrollDao;
import com.decoverri.treasureGenerator.treasure.model.Scroll;

public class ScrollGenerator {

	private ScrollDao scrollDao;
	private ScrollLevelDao scrollLevelDao;
	private Dice d100;
	private DiceRoller roller;

	public ScrollGenerator(Session session) {
		this.scrollDao = new ScrollDao(session);
		this.scrollLevelDao = new ScrollLevelDao(session);
		this.d100 = new Dice(100);
		this.roller = new DiceRoller();
	}

	public List<Scroll> generate(List<ScrollGeneratorData> scrollsData) {
		List<Scroll> scrolls = new ArrayList<Scroll>();

		for (ScrollGeneratorData data : scrollsData) {
			scrolls.addAll(generate(data));
		}

		return scrolls;
	}

	private List<Scroll> generate(ScrollGeneratorData data) {
		List<Scroll> scrolls = new ArrayList<Scroll>();

		for (int i = 0; i < data.getQuantity(); i++) {
			scrolls.add(generate(data.getStrength()));
		}
		return scrolls;
	}

	private Scroll generate(MagicItemStrength strength) {

		System.out.println("Generating " + strength + " scroll");
		System.out.println("Generating spell level");

		int level = scrollLevelDao.getScrollLevel(strength, roller.roll(d100));

		System.out.println("Result: level " + level);
		System.out.println("Generating type and rarity");

		int typeAndRarityRoll = roller.roll(d100);
		MagicType type = setScrollType(typeAndRarityRoll);
		MagicItemRarity rarity = setScrollRarity(typeAndRarityRoll);

		System.out.println("Result: " + rarity + " " + type);
		System.out.println("Generating " + rarity + " " + type + " level " + level + " scroll");

		Scroll scroll = scrollDao.getScroll(level, rarity, type, roller.roll(d100));

		System.out.println("Result: " + scroll.getSpell() + "\n");

		return scroll;
	}

	private MagicType setScrollType(int roll) {
		return (roll < 61 ? ARCANE : DIVINE);

	}

	private MagicItemRarity setScrollRarity(int roll) {
		return (roll < 46 || (roll > 60 && roll < 91) ? COMMON : UNCOMMON);
	}

}
