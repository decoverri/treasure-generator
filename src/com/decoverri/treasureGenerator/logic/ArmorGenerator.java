package com.decoverri.treasureGenerator.logic;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.ArmorDao;
import com.decoverri.treasureGenerator.model.Armor;
import com.decoverri.treasureGenerator.model.Dice;

public class ArmorGenerator {

	private Session session;

	public ArmorGenerator(Session session) {
		this.session = session;
	}

	public Armor generate() {

		ArmorDao armorDao = new ArmorDao(session);

		Dice d100 = new Dice(100);
		DiceRoller roller = new DiceRoller();

		System.out.println("Generating armor/shield");
		Armor armor = armorDao.getArmor(roller.roll(d100));
		System.out.println("Result: " + armor.getName());

		return armor;
	}

}
