package com.decoverri.treasureGenerator.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.MagicArmorAbilityDao;
import com.decoverri.treasureGenerator.dao.MagicArmorStatsDao;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.model.Armor;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.MagicArmor;
import com.decoverri.treasureGenerator.model.MagicArmorAbility;
import com.decoverri.treasureGenerator.model.MagicArmorGeneratorData;
import com.decoverri.treasureGenerator.model.MagicArmorStats;

public class MagicArmorGenerator {

	private Session session;

	public MagicArmorGenerator(Session session) {
		this.session = session;
	}

	public List<Treasure> generate(MagicArmorGeneratorData data) {

		List<Treasure> armors = new ArrayList<Treasure>();

		ArmorGenerator armorGenerator = new ArmorGenerator(session);
		MagicArmorStatsDao statsDao = new MagicArmorStatsDao(session);
		SpecificArmorGenerator specificGenerator = new SpecificArmorGenerator(session);
		MagicArmorAbilityDao abilityDao = new MagicArmorAbilityDao(session);

		Dice d100 = new Dice(100);
		DiceRoller roller = new DiceRoller();
		
		Treasure finalArmor;

		for (int i = 0; i < data.getQuantity(); i++) {
			System.out.println("Generating magic armor");
			int roll = roller.roll(d100);
			if (roll > 80) {
				System.out.println("Result: specific armor/shield");
				finalArmor = specificGenerator.generate(data.getStrength());
			} else {
				System.out.println("Result: non-specific armor/shield");
				MagicArmor magicArmor = new MagicArmor();
				Armor armor = armorGenerator.generate();
				magicArmor.setBaseArmor(armor);
				System.out.println("Generating " + data.getStrength() + " magic " + magicArmor.getBaseArmor().getType() + " properties");
				MagicArmorStats stats = statsDao.getMagicArmorStats(data.getStrength(), roll);
				System.out.println("Result: " + stats);
				magicArmor.setBonus(stats.getBonus());
				magicArmor.setMagicalAbilities(new ArrayList<MagicArmorAbility>());
				if (stats.getAbilityBonus() > 0) {
					for (int j = 0; j < stats.getNumberOfAbilities(); j++) {
						//TODO: don't let generate two identical abilities
						System.out.println("Generating " + magicArmor.getBaseArmor().getType() + " +" + stats.getAbilityBonus() + " ability");
						MagicArmorAbility magicArmorAbility = abilityDao.getMagicArmorAbility(stats.getAbilityBonus(), armor.getType(), roller.roll(d100));
						System.out.println("Result: " + magicArmorAbility);
						if (j == 1 && magicArmorAbility.getName() == magicArmor.getMagicalAbilities().get(0).getName()) {
							System.out.println("Repeted ability. Will regenerate");
							j--;
							continue;
						}
						magicArmor.getMagicalAbilities().add(magicArmorAbility);
					}
				}
				finalArmor = magicArmor;
				System.out.println("");
			}
			armors.add(finalArmor);
		}
		return armors;
	}

}
