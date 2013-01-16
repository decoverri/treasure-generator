package com.decoverri.treasureGenerator.logic.generator;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.treasure.ArmorDao;
import com.decoverri.treasureGenerator.enums.ArmorType;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.treasure.Armor;

public class ArmorGenerator {

	private Session session;

	public ArmorGenerator(Session session) {
		this.session = session;
	}

	public Armor generateBaseArmor() {

		ArmorDao armorDao = new ArmorDao(session);

		Dice d100 = new Dice(100);
		DiceRoller roller = new DiceRoller();

		System.out.println("Generating armor or shield");
		Armor armor = armorDao.getArmor(roller.roll(d100));
		System.out.println("Result: " + armor.getName());

		return armor;
	}

	public Armor generate(ArmorType type) {

		ArmorDao armorDao = new ArmorDao(session);

		Dice d100 = new Dice(100);
		DiceRoller roller = new DiceRoller();

		System.out.println("Generating " + type);
		Armor armor = new Armor();

		boolean matchType = false;
		while (!matchType) {
			armor = armorDao.getArmor(roller.roll(d100));
			System.out.println("Result: " + armor.getName());
			matchType = armor.getType().equals(type);
			if (!matchType) {
				System.out.println("Result doesn't match armor type. Will regenerate");
			}
			
		}

		System.out.println("");
		return armor;
	}

}
