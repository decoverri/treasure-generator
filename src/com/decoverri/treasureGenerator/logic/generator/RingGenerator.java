package com.decoverri.treasureGenerator.logic.generator;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.treasure.RingDao;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.data.RingGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.Ring;

public class RingGenerator {

	private Session session;

	public RingGenerator(Session session) {
		this.session = session;
	}

	public List<Ring> generate(List<RingGeneratorData> ringsData) {

		List<Ring> rings = new ArrayList<Ring>();
		RingDao ringDao = new RingDao(session);
		Dice d100 = new Dice(100);
		DiceRoller roller = new DiceRoller();

		for (RingGeneratorData data : ringsData) {
			for (int i = 0; i < data.getQuantity(); i++) {
				System.out.println("Generating " + data.getStrength() + " ring");
				Ring ring = ringDao.getRing(data.getStrength(), roller.roll(d100));
				System.out.println("Result: " + ring.getName() + "\n");
				rings.add(ring);
			}
		}

		return rings;
	}

}
