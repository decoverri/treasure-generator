package com.decoverri.treasureGenerator.logic.generator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.dao.treasure.RingDao;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.treasure.Ring;
import com.decoverri.treasureGenerator.model.treasure.data.RingGeneratorData;

@Component
public class RingGenerator {

	@Autowired
	private RingDao ringDao;

	private DiceRoller roller;
	private Dice d100;

	public RingGenerator() {
		this.roller = new DiceRoller();
		this.d100 = new Dice(100);
	}

	public List<Ring> generate(List<RingGeneratorData> ringsData) {
		List<Ring> rings = new ArrayList<Ring>();

		for (RingGeneratorData data : ringsData) {
			rings.addAll(generate(data));
		}

		return rings;
	}

	private List<Ring> generate(RingGeneratorData data) {
		List<Ring> rings = new ArrayList<Ring>();

		for (int i = 0; i < data.getQuantity(); i++) {
			rings.add(generate(data.getStrength()));
		}

		return rings;
	}

	private Ring generate(MagicItemStrength strength) {
		System.out.println("Generating " + strength + " ring");

		Ring ring = ringDao.getRing(strength, roller.roll(d100));

		System.out.println("Result: " + ring.getName() + "\n");

		return ring;
	}
}
