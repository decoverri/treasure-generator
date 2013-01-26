package com.decoverri.treasureGenerator.logic.generator;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.treasure.complement.MagicWeaponAbilityDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.MagicWeaponStatsDao;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.data.MagicWeaponGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.MagicWeapon;
import com.decoverri.treasureGenerator.model.treasure.SpecificWeapon;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicWeaponAbility;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicWeaponStats;

public class MagicWeaponGenerator {

	private WeaponGenerator weaponGenerator;
	private SpecificWeaponGenerator specificGenerator;

	private MagicWeaponStatsDao statsDao;
	private MagicWeaponAbilityDao abilityDao;

	private DiceRoller roller;
	private Dice d100;

	public MagicWeaponGenerator(Session session) {
		this.weaponGenerator = new WeaponGenerator(session);
		this.specificGenerator = new SpecificWeaponGenerator(session);
		this.statsDao = new MagicWeaponStatsDao(session);
		this.abilityDao = new MagicWeaponAbilityDao(session);
		this.roller = new DiceRoller();
		this.d100 = new Dice(100);
	}

	public List<Treasure> generate(List<MagicWeaponGeneratorData> weaponsData) {
		List<Treasure> weapons = new ArrayList<Treasure>();

		for (MagicWeaponGeneratorData data : weaponsData) {
			weapons.addAll(generate(data));
		}

		return weapons;
	}

	private List<Treasure> generate(MagicWeaponGeneratorData data) {
		List<Treasure> weapons = new ArrayList<Treasure>();

		for (int i = 0; i < data.getQuantity(); i++) {
			weapons.add(generate(data.getStrength()));
		}

		return weapons;
	}

	private Treasure generate(MagicItemStrength strength) {
		Treasure weapon;

		System.out.println("Generating " + strength + " armor or shield");
		int abilityRoll = roller.roll(d100);

		if (abilityRoll > 80) {
			weapon = generateSpecificWeapon(strength);
		} else {
			weapon = generateMagicWeapon(strength, abilityRoll);
		}

		return weapon;

	}

	private SpecificWeapon generateSpecificWeapon(MagicItemStrength strength) {
		System.out.println("Result: specific weapon");
		return specificGenerator.generate(strength);
	}

	private MagicWeapon generateMagicWeapon(MagicItemStrength strength, int roll) {
		MagicWeaponStats stats = statsDao.getMagicWeaponStats(strength, roll);
		System.out.println("Result: magic weapon with " + stats);

		MagicWeapon magicWeapon = new MagicWeapon();
		magicWeapon.setBaseWeapon(weaponGenerator.generate());
		magicWeapon.setBonus(stats.getBonus());
		setMagicalAbilities(magicWeapon, stats);

		System.out.println("");
		return magicWeapon;
	}

	private void setMagicalAbilities(MagicWeapon magicWeapon, MagicWeaponStats stats) {
		magicWeapon.setMagicalAbilities(new ArrayList<MagicWeaponAbility>());
		
		if (stats.getAbilityBonus() > 0) {
			generateMagicAbilities(magicWeapon, stats.getNumberOfAbilities(), stats.getAbilityBonus());
		}
		if (stats.getSecondAbilityBonus() > 0) {
			generateMagicAbilities(magicWeapon, stats.getNumberOfSecondAbility(), stats.getSecondAbilityBonus());
		}
	}

	// TODO generate creature for BANE and SLAYING abilities
	private void generateMagicAbilities(MagicWeapon magicWeapon, int numberOfAbilities, int abilityBonus) {

		int i = 0;
		while (i < numberOfAbilities) {
			System.out.println("Generating " + magicWeapon.getBaseWeapon().getType() + " +" + abilityBonus + " ability");
			MagicWeaponAbility magicWeaponAbility = abilityDao.getMagicWeaponAbility(abilityBonus, magicWeapon.getBaseWeapon().getType(), roller.roll(d100));
			System.out.println("Result: " + magicWeaponAbility);
			
			boolean matchRestriction = magicWeaponAbility.getRestriction().equals(magicWeapon.getBaseWeapon().getRestriction());
			boolean secondAbilityEqualsFirst = i == 1 && magicWeaponAbility.getName() == magicWeapon.getMagicalAbilities().get(0).getName();
			if (!matchRestriction || secondAbilityEqualsFirst) {
				System.out.println("Incompatible ability. Will regenerate");
				continue;
			}
			

			magicWeapon.getMagicalAbilities().add(magicWeaponAbility);
			i++;
		}
	}

}
