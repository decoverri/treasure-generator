package com.decoverri.treasureGenerator.logic.generator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.dao.treasure.complement.FoeDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.MagicWeaponAbilityDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.MagicWeaponStatsDao;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.treasure.MagicWeapon;
import com.decoverri.treasureGenerator.model.treasure.SpecificWeapon;
import com.decoverri.treasureGenerator.model.treasure.complement.Foe;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicWeaponAbility;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicWeaponStats;
import com.decoverri.treasureGenerator.model.treasure.data.MagicWeaponGeneratorData;

@Component
public class MagicWeaponGenerator {

	@Autowired
	private WeaponGenerator weaponGenerator;
	@Autowired
	private SpecificWeaponGenerator specificGenerator;

	@Autowired
	private MagicWeaponStatsDao statsDao;
	@Autowired
	private MagicWeaponAbilityDao abilityDao;
	@Autowired
	private FoeDao foeDao;

	private DiceRoller roller;
	private Dice d100;

	public MagicWeaponGenerator() {
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

		System.out.println("Generating " + strength + " weapon");
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
			
			if (magicWeaponAbility.getName().equals("Bane")) {
				magicWeaponAbility = setBaneFoe(magicWeaponAbility);
			}

			magicWeapon.getMagicalAbilities().add(magicWeaponAbility);
			i++;
		}
	}

	private MagicWeaponAbility setBaneFoe(MagicWeaponAbility magicWeaponAbility) {
		System.out.println("Generating bane foe");
		Foe foe = foeDao.getFoe(roller.roll(d100));
		System.out.println("Result: " + foe);
		MagicWeaponAbility ability = magicWeaponAbility.clone();
		ability.setName(foe + " " + ability.getName().toLowerCase());
		return ability;
	}

}
