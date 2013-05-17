package com.decoverri.treasureGenerator.logic.generator;

import static com.decoverri.treasureGenerator.enums.ArmorType.ARMOR;
import static com.decoverri.treasureGenerator.enums.ArmorType.SHIELD;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.dao.treasure.SpecificArmorDao;
import com.decoverri.treasureGenerator.enums.ArmorType;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.treasure.SpecificArmor;

@Component
public class SpecificArmorGenerator {

	@Autowired
	private SpecificArmorDao armorDao;

	private DiceRoller roller;
	private Dice d100;

	public SpecificArmorGenerator() {
		this.roller = new DiceRoller();
		this.d100 = new Dice(100);
	}

	public SpecificArmor generate(MagicItemStrength strength) {
		System.out.println("Generating armor or shield");
		ArmorType type = selectArmorOrShield();
		System.out.println("Result: " + type);
		System.out.println("Generating " + strength + " specific " + type);
		SpecificArmor armor = armorDao.getSpecificArmor(type, strength, roller.roll(d100));
		System.out.println("Result: " + armor.getName() + "\n");

		return armor;
	}

	private ArmorType selectArmorOrShield() {
		int i = new Random().nextInt(ArmorType.values().length);
		ArmorType type = ArmorType.values()[i];

		if (type != SHIELD) {
			type = ARMOR;
		}
		return type;
	}

}
