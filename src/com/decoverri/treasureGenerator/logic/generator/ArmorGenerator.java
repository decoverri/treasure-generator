package com.decoverri.treasureGenerator.logic.generator;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.treasure.ArmorDao;
import com.decoverri.treasureGenerator.enums.ArmorType;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.data.ArmorGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.Armor;

public class ArmorGenerator {

	private ArmorDao armorDao;

	private DiceRoller roller;
	private Dice d100;

	public ArmorGenerator(Session session) {
		this.armorDao = new ArmorDao(session);
		this.roller = new DiceRoller();
		this.d100 = new Dice(100);
	}

	public Armor generateBaseArmor() {
		System.out.println("Generating armor or shield");

		Armor armor = armorDao.getArmor(roller.roll(d100));

		System.out.println("Result: " + armor.getName());

		return armor;
	}

	public ArrayList<Armor> generate(List<ArmorGeneratorData> armorsData) {
		ArrayList<Armor> armors = new ArrayList<Armor>();

		for (ArmorGeneratorData data : armorsData) {
			armors.add(generate(data));
		}

		return armors;
	}

	private Armor generate(ArmorGeneratorData data) {
		return generate(data.getType());
	}

	private Armor generate(ArmorType type) {

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
