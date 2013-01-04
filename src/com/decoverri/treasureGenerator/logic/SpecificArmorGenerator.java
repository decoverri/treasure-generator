package com.decoverri.treasureGenerator.logic;

import java.util.Random;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.SpecificArmorDao;
import com.decoverri.treasureGenerator.enums.ArmorType;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.SpecificArmor;

public class SpecificArmorGenerator {

	private Session session;

	public SpecificArmorGenerator(Session session) {
		this.session = session;
	}

	public SpecificArmor generate(MagicItemStrength strength) {

		SpecificArmorDao armorDao = new SpecificArmorDao(session);

		Dice d100 = new Dice(100);
		DiceRoller roller = new DiceRoller();

		System.out.println("Generating armor");
		int i = new Random().nextInt(ArmorType.values().length);
		SpecificArmor armor = armorDao.getSpecificArmor(ArmorType.values()[i], strength, roller.roll(d100));
		System.out.println("Result: " + armor.getName() + "\n");

		return armor;
	}

}
