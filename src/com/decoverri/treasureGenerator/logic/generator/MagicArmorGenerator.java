package com.decoverri.treasureGenerator.logic.generator;

import static com.decoverri.treasureGenerator.enums.ArmorType.ARMOR;
import static com.decoverri.treasureGenerator.enums.ArmorType.SHIELD;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.dao.treasure.complement.MagicArmorAbilityDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.MagicArmorStatsDao;
import com.decoverri.treasureGenerator.enums.ArmorType;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.interfaces.Treasure;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.data.MagicArmorGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.MagicArmor;
import com.decoverri.treasureGenerator.model.treasure.SpecificArmor;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicArmorAbility;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicArmorStats;

@Component
public class MagicArmorGenerator {

	@Autowired
	private ArmorGenerator armorGenerator;
	@Autowired
	private SpecificArmorGenerator specificGenerator;

	@Autowired
	private MagicArmorStatsDao statsDao;
	@Autowired
	private MagicArmorAbilityDao abilityDao;
	
	private DiceRoller roller;
	private Dice d100;

	public MagicArmorGenerator() {
		this.roller = new DiceRoller();
		this.d100 = new Dice(100);
	}

	public List<Treasure> generate(List<MagicArmorGeneratorData> armorsData) {
		List<Treasure> armors = new ArrayList<Treasure>();

		for (MagicArmorGeneratorData data : armorsData) {
			armors.addAll(generate(data));
		}

		return armors;
	}

	private List<Treasure> generate(MagicArmorGeneratorData data) {
		List<Treasure> armors = new ArrayList<Treasure>();

		for (int i = 0; i < data.getQuantity(); i++) {
			armors.add(generate(data.getStrength()));
		}

		return armors;
	}

	private Treasure generate(MagicItemStrength strength) {
		Treasure armor;

		System.out.println("Generating " + strength + " armor or shield");
		int abilityRoll = roller.roll(d100);

		if (abilityRoll > 80) {
			armor = generateSpecificArmor(strength);
		} else {
			armor = generateMagicArmor(strength, abilityRoll);
		}

		return armor;

	}

	private SpecificArmor generateSpecificArmor(MagicItemStrength strength) {
		System.out.println("Result: specific armor/shield");
		return specificGenerator.generate(strength);
	}

	private MagicArmor generateMagicArmor(MagicItemStrength strength, int roll) {
		MagicArmorStats stats = statsDao.getMagicArmorStats(strength, roll);
		System.out.println("Result: magic armor or shield with " + stats);

		MagicArmor magicArmor = new MagicArmor();
		magicArmor.setBaseArmor(armorGenerator.generateBaseArmor());
		magicArmor.setBonus(stats.getBonus());
		setMagicalAbilities(magicArmor, stats);

		System.out.println("");
		return magicArmor;
	}

	private void setMagicalAbilities(MagicArmor magicArmor, MagicArmorStats stats) {
		magicArmor.setMagicalAbilities(new ArrayList<MagicArmorAbility>());

		if (stats.getAbilityBonus() > 0) {
			generateMagicAbilities(magicArmor, stats);
		}
	}

	private void generateMagicAbilities(MagicArmor magicArmor, MagicArmorStats stats) {

		ArmorType type = SHIELD;
		if (magicArmor.getBaseArmor().getType() != SHIELD) {
			type = ARMOR;
		}

		int i = 0;
		while (i < stats.getNumberOfAbilities()) {

			System.out.println("Generating " + type + " +" + stats.getAbilityBonus() + " ability");
			MagicArmorAbility magicArmorAbility = abilityDao.getMagicArmorAbility(stats.getAbilityBonus(), type, roller.roll(d100));
			System.out.println("Result: " + magicArmorAbility);

			if (i == 1 && magicArmorAbility.getName() == magicArmor.getMagicalAbilities().get(0).getName()) {
				System.out.println("Repeted ability. Will regenerate");
				continue;
			}

			magicArmor.getMagicalAbilities().add(magicArmorAbility);
			i++;
		}
	}

}
