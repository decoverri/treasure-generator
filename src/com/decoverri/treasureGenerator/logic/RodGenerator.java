package com.decoverri.treasureGenerator.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.MetamagicRodDao;
import com.decoverri.treasureGenerator.dao.RodDao;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.MetamagicRod;
import com.decoverri.treasureGenerator.model.Rod;
import com.decoverri.treasureGenerator.model.RodGeneratorData;

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
				//TODO resolver problema de transaction
				Rod rod = rodDao.getRod(data.getStrength(), roller.roll(d100));

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
