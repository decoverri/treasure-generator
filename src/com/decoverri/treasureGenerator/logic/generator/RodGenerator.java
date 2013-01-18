package com.decoverri.treasureGenerator.logic.generator;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.model.RodGeneratorData;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.treasure.aux.dao.MetamagicRodDao;
import com.decoverri.treasureGenerator.treasure.aux.model.MetamagicRod;
import com.decoverri.treasureGenerator.treasure.dao.RodDao;
import com.decoverri.treasureGenerator.treasure.model.Rod;

public class RodGenerator {

	private Session session;

	DiceRoller roller = new DiceRoller();
	Dice d100 = new Dice(100);

	public RodGenerator(Session session) {
		this.session = session;
	}

	public List<Rod> generate(List<RodGeneratorData> rodsData) {

		List<Rod> rods = new ArrayList<Rod>();
		RodDao rodDao = new RodDao(session);

		for (RodGeneratorData data : rodsData) {
			for (int i = 0; i < data.getQuantity(); i++) {
				System.out.println("Generating " + data.getStrength() + " rod");
				Rod result = rodDao.getRod(data.getStrength(), roller.roll(d100));
				Rod rod = result.clone();

				if (rod.getMetamagicSpellLevelIncrement() > 0) {
					getMetamagicRod(rod);
				}

				System.out.println("Result: " + rod.getName() + "\n");
				rods.add(rod);
			}
		}

		return rods;
	}

	private void getMetamagicRod(Rod rod) {
		MetamagicRodDao metamagicDao = new MetamagicRodDao(session);

		System.out.println("Result: " + rod.getName().toLowerCase() + "metamagic rod");
		System.out.println("Generating " + rod.getName().toLowerCase() + "metamagic rod");
		MetamagicRod metamagicRod = metamagicDao.getMetamagicRod(rod.getMetamagicSpellLevelIncrement(),roller.roll(d100));
		System.out.println("Result: " + metamagicRod);
		String name = rod.getName() + metamagicRod + " metamagic rod";
		rod.setName(name.toUpperCase().substring(0, 1) + name.toLowerCase().substring(1));
	}

}
