package com.decoverri.treasureGenerator.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.MagicWeaponAbilityDao;
import com.decoverri.treasureGenerator.dao.MagicWeaponStatsDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.MagicWeaponAbility;
import com.decoverri.treasureGenerator.model.MagicWeaponStats;
import com.decoverri.treasureGenerator.model.generator.MagicWeaponGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.MagicWeapon;
import com.decoverri.treasureGenerator.model.treasure.Weapon;

//TODO Refactoring
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
			System.out.println("Generating " + data.getStrength() + " weapon");
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

		MagicWeaponStats stats = statsDao.getMagicWeaponStats(data.getStrength(), roll);
		System.out.println("Result: magic weapon with " + stats);

		MagicWeapon magicWeapon = new MagicWeapon();
		Weapon weapon = weaponGenerator.generate();
		magicWeapon.setBaseWeapon(weapon);

		magicWeapon.setBonus(stats.getBonus());
		magicWeapon.setMagicalAbilities(new ArrayList<MagicWeaponAbility>());

		if (stats.getAbilityBonus() > 0) {
			generateMagicAbilities(magicWeapon, stats.getNumberOfAbilities(), stats.getAbilityBonus());
		}
		if (stats.getSecondAbilityBonus() > 0) {
			generateMagicAbilities(magicWeapon, stats.getNumberOfSecondAbility(), stats.getSecondAbilityBonus());
		}

		finalWeapon = magicWeapon;
		System.out.println("");
		return finalWeapon;
	}

	//TODO generate creature for BANE and SLAYING abilities
	private void generateMagicAbilities(MagicWeapon magicWeapon, int numberOfAbilities, int abilityBonus) {
		MagicWeaponAbilityDao abilityDao = new MagicWeaponAbilityDao(session);

		for (int i = 0; i < numberOfAbilities; i++) {
			System.out.println("Generating " + magicWeapon.getBaseWeapon().getType() + " +" + abilityBonus + " ability");
			MagicWeaponAbility magicWeaponAbility = abilityDao.getMagicWeaponAbility(abilityBonus, magicWeapon.getBaseWeapon().getType(), roller.roll(d100));
			System.out.println("Result: " + magicWeaponAbility);

			if (!magicWeaponAbility.getRestriction().equals(magicWeapon.getBaseWeapon().getRestriction())) {
				System.out.println("Incompability of weapon and ability. Will regenerate");
				i--;
				continue;
			}
				
			if (i == 1 && magicWeaponAbility.getName() == magicWeapon.getMagicalAbilities().get(0).getName()) {
				System.out.println("Repeted ability. Will regenerate");
				i--;
				continue;
			}

			magicWeapon.getMagicalAbilities().add(magicWeaponAbility);
		}
	}


}
