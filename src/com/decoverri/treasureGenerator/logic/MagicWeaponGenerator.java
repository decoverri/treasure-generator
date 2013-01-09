package com.decoverri.treasureGenerator.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.MagicWeaponAbilityDao;
import com.decoverri.treasureGenerator.dao.MagicWeaponStatsDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.MagicWeapon;
import com.decoverri.treasureGenerator.model.MagicWeaponAbility;
import com.decoverri.treasureGenerator.model.MagicWeaponGeneratorData;
import com.decoverri.treasureGenerator.model.MagicWeaponStats;
import com.decoverri.treasureGenerator.model.Weapon;

public class MagicWeaponGenerator {

	private Session session;

	private DiceRoller roller = new DiceRoller();
	private Dice d100 = new Dice(100);

	public MagicWeaponGenerator(Session session) {
		this.session = session;
	}

	public List<Treasure> generate(MagicWeaponGeneratorData data) {

		List<Treasure> weapons = new ArrayList<Treasure>();

		Treasure finalWeapon;
		for (int i = 0; i < data.getQuantity(); i++) {
			System.out.println("Generating magic weapon");
			int abilityRoll = roller.roll(d100);

			if (abilityRoll > 80) {
				finalWeapon = generateSpecificWeapon(data);
			} else {
				finalWeapon = generateMagicWeapon(data, abilityRoll);
			}

			weapons.add(finalWeapon);
		}
		return weapons;
	}

	private Treasure generateSpecificWeapon(MagicWeaponGeneratorData data) {
		SpecificWeaponGenerator specificGenerator = new SpecificWeaponGenerator(session);

		System.out.println("Result: specific weapon");

		return specificGenerator.generate(data.getStrength());
	}

	private Treasure generateMagicWeapon(MagicWeaponGeneratorData data, int roll) {
		WeaponGenerator weaponGenerator = new WeaponGenerator(session);
		MagicWeaponStatsDao statsDao = new MagicWeaponStatsDao(session);
		Treasure finalWeapon;

		System.out.println("Result: non-specific weapon");

		MagicWeapon magicWeapon = new MagicWeapon();
		Weapon weapon = weaponGenerator.generate();
		magicWeapon.setBaseWeapon(weapon);

		System.out.println("Generating " + data.getStrength() + " magic " + magicWeapon.getBaseWeapon().getType() + " properties");
		MagicWeaponStats stats = statsDao.getMagicWeaponStats(data.getStrength(), roll);
		System.out.println("Result: " + stats);

		magicWeapon.setBonus(stats.getBonus());
		magicWeapon.setMagicalAbilities(new ArrayList<MagicWeaponAbility>());

		if (stats.getAbilityBonus() > 0) {
			generateMagicAbilities(magicWeapon, stats);
		}

		finalWeapon = magicWeapon;
		System.out.println("");
		return finalWeapon;
	}

	private void generateMagicAbilities(MagicWeapon magicWeapon, MagicWeaponStats stats) {
		MagicWeaponAbilityDao abilityDao = new MagicWeaponAbilityDao(session);

		for (int i = 0; i < stats.getNumberOfAbilities(); i++) {
			System.out.println("Generating " + magicWeapon.getBaseWeapon().getType() + " +" + stats.getAbilityBonus() + " ability");
			MagicWeaponAbility magicWeaponAbility = abilityDao.getMagicWeaponAbility(stats.getAbilityBonus(), magicWeapon.getBaseWeapon().getType(), roller.roll(d100));
			System.out.println("Result: " + magicWeaponAbility);

			if (i == 1 && magicWeaponAbility.getName() == magicWeapon.getMagicalAbilities().get(0).getName()) {
				System.out.println("Repeted ability. Will regenerate");
				i--;
				continue;
			}

			magicWeapon.getMagicalAbilities().add(magicWeaponAbility);
		}
	}


}
