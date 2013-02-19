package com.decoverri.treasureGenerator.logic.generator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.dao.treasure.RodDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.MetamagicRodDao;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.data.RodGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.Rod;
import com.decoverri.treasureGenerator.model.treasure.complement.MetamagicRod;

@Component
public class RodGenerator {

	@Autowired
	private RodDao rodDao;

	@Autowired
	private MetamagicRodDao metamagicDao;

	private DiceRoller roller;
	private Dice d100;

	public RodGenerator() {
		this.roller = new DiceRoller();
		this.d100 = new Dice(100);
	}

	public List<Rod> generate(List<RodGeneratorData> rodsData) {
		List<Rod> rods = new ArrayList<Rod>();

		for (RodGeneratorData data : rodsData) {
			rods.addAll(generate(data));
		}

		return rods;
	}

	private List<Rod> generate(RodGeneratorData data) {
		List<Rod> rods = new ArrayList<Rod>();

		for (int i = 0; i < data.getQuantity(); i++) {
			rods.add(generate(data.getStrength()));
		}

		return rods;
	}

	private Rod generate(MagicItemStrength strength) {
		System.out.println("Generating " + strength + " rod");

		Rod result = rodDao.getRod(strength, roller.roll(d100));
		Rod rod = result.clone();

		if (rod.getMetamagicSpellLevelIncrement() > 0) {
			getMetamagicRod(rod);
		}

		System.out.println("Result: " + rod.getName() + "\n");
		return rod;
	}

	private void getMetamagicRod(Rod rod) {
		System.out.println("Result: " + rod.getName().toLowerCase() + "metamagic rod");
		System.out.println("Generating " + rod.getName().toLowerCase() + "metamagic rod");

		MetamagicRod metamagicRod = metamagicDao.getMetamagicRod(rod.getMetamagicSpellLevelIncrement(),roller.roll(d100));

		System.out.println("Result: " + metamagicRod);
		
		String name = rod.getName() + metamagicRod + " metamagic rod";
		rod.setName(name.toUpperCase().substring(0, 1) + name.toLowerCase().substring(1));
	}

}
