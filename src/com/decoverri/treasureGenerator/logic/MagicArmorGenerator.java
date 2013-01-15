package com.decoverri.treasureGenerator.logic;

import static com.decoverri.treasureGenerator.enums.ArmorType.ARMOR;
import static com.decoverri.treasureGenerator.enums.ArmorType.SHIELD;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.MagicArmorAbilityDao;
import com.decoverri.treasureGenerator.dao.MagicArmorStatsDao;
import com.decoverri.treasureGenerator.enums.ArmorType;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.model.Armor;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.MagicArmor;
import com.decoverri.treasureGenerator.model.MagicArmorAbility;
import com.decoverri.treasureGenerator.model.MagicArmorGeneratorData;
import com.decoverri.treasureGenerator.model.MagicArmorStats;

//TODO Refactoring
public class MagicArmorGenerator {

	private Session session;

	private DiceRoller roller = new DiceRoller();
	private Dice d100 = new Dice(100);

	public MagicArmorGenerator(Session session) {
		this.session = session;
	}

	public List<Treasure> generate(MagicArmorGeneratorData data) {

		List<Treasure> armors = new ArrayList<Treasure>();

		Treasure finalArmor;
		for (int i = 0; i < data.getQuantity(); i++) {
			System.out.println("Generating " + data.getStrength() + " armor or shield");
			int abilityRoll = roller.roll(d100);

			if (abilityRoll > 80) {
				finalArmor = generateSpecificArmor(data);
			} else {
				finalArmor = generateMagicArmor(data, abilityRoll);
			}

			armors.add(finalArmor);
		}
		return armors;
	}

	private Treasure generateSpecificArmor(MagicArmorGeneratorData data) {
		SpecificArmorGenerator specificGenerator = new SpecificArmorGenerator(session);

		System.out.println("Result: specific armor/shield");

		return specificGenerator.generate(data.getStrength());
	}

	private Treasure generateMagicArmor(MagicArmorGeneratorData data, int roll) {
		ArmorGenerator armorGenerator = new ArmorGenerator(session);
		MagicArmorStatsDao statsDao = new MagicArmorStatsDao(session);
		Treasure finalArmor;

		MagicArmorStats stats = statsDao.getMagicArmorStats(data.getStrength(), roll);
		System.out.println("Result: magic armor or shield with " + stats);

		MagicArmor magicArmor = new MagicArmor();
		Armor armor = armorGenerator.generateBaseArmor();
		magicArmor.setBaseArmor(armor);

		magicArmor.setBonus(stats.getBonus());
		magicArmor.setMagicalAbilities(new ArrayList<MagicArmorAbility>());

		if (stats.getAbilityBonus() > 0) {
			generateMagicAbilities(magicArmor, stats);
		}

		finalArmor = magicArmor;
		System.out.println("");
		return finalArmor;
	}

	private void generateMagicAbilities(MagicArmor magicArmor, MagicArmorStats stats) {
		MagicArmorAbilityDao abilityDao = new MagicArmorAbilityDao(session);
		
		ArmorType type = SHIELD;
		if (magicArmor.getBaseArmor().getType() != SHIELD) {
			type = ARMOR;
		}

		for (int i = 0; i < stats.getNumberOfAbilities(); i++) {
			System.out.println("Generating " + type + " +" + stats.getAbilityBonus() + " ability");
			MagicArmorAbility magicArmorAbility = abilityDao.getMagicArmorAbility(stats.getAbilityBonus(), type, roller.roll(d100));
			System.out.println("Result: " + magicArmorAbility);

			if (i == 1 && magicArmorAbility.getName() == magicArmor.getMagicalAbilities().get(0).getName()) {
				System.out.println("Repeted ability. Will regenerate");
				i--;
				continue;
			}

			magicArmor.getMagicalAbilities().add(magicArmorAbility);
		}
	}

}
