package com.decoverri.treasureGenerator.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.GemstoneDao;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.Gemstone;
import com.decoverri.treasureGenerator.model.GemstoneGeneratorData;

public class GemGenerator {

	private Session session;

	public GemGenerator(Session session) {
		this.session = session;
	}

	public List<Gemstone> generate(List<GemstoneGeneratorData> gemData) {

		List<Gemstone> gems = new ArrayList<Gemstone>();
		GemstoneDao gemstoneDao = new GemstoneDao(session);
		Dice d100 = new Dice(100);
		DiceRoller roller = new DiceRoller();

		for (GemstoneGeneratorData gem : gemData) {

			Gemstone gemstone = gemstoneDao.getGem(gem.getGrade(), roller.roll(d100));
			gems.add(gemstone);
		}

		return gems;
	}

}
