package com.decoverri.treasureGenerator.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.ArmorDao;
import com.decoverri.treasureGenerator.model.Armor;
import com.decoverri.treasureGenerator.model.Dice;

public class ArmorGenerator {

	private Session session;

	public ArmorGenerator(Session session) {
		this.session = session;
	}

	public List<Armor> generate(int quantity) {

		List<Armor> armors = new ArrayList<Armor>();
		ArmorDao armorDao = new ArmorDao(session);

		Dice d100 = new Dice(100);
		DiceRoller roller = new DiceRoller();

		for (int i = 0; i < quantity; i++) {
			System.out.println("Generating armor");
			Armor armor = armorDao.getArmor(roller.roll(d100));
			System.out.println("Result: " + armor.getName() + "\n");
			armors.add(armor);
		}

		return armors;
	}

}
