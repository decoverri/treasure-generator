package com.decoverri.treasureGenerator.logic.generator;

import static com.decoverri.treasureGenerator.enums.ArmorType.ARMOR;
import static com.decoverri.treasureGenerator.enums.ArmorType.SHIELD;

import java.util.Random;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.enums.ArmorType;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.treasure.dao.SpecificArmorDao;
import com.decoverri.treasureGenerator.treasure.model.SpecificArmor;

public class SpecificArmorGenerator {

	private Session session;

	public SpecificArmorGenerator(Session session) {
		this.session = session;
	}

	public SpecificArmor generate(MagicItemStrength strength) {

		SpecificArmorDao armorDao = new SpecificArmorDao(session);

		Dice d100 = new Dice(100);
		DiceRoller roller = new DiceRoller();

		System.out.println("Generating armor or shield");
		ArmorType type = selectArmorOrShield();
		System.out.println("Result: " + type);
		System.out.println("Generating " + strength + " specific " + type);
		SpecificArmor armor = armorDao.getSpecificArmor(type, strength, roller.roll(d100));
		System.out.println("Result: " + armor.getName() + "\n");

		return armor;
	}

	private ArmorType selectArmorOrShield() {
		int i = new Random().nextInt(2);
		if (i == 0) {
			return SHIELD;
		}
		return ARMOR;
	}

}
