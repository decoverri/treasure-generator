package com.decoverri.treasureGenerator.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.GemstoneDao;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.GemValue;
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
			for (int i = 0; i < gem.getQuantity(); i++) {
				System.out.println("Generating grade " + gem.getGrade() + " gemstone");
				Gemstone gemstone = gemstoneDao.getGem(gem.getGrade(), roller.roll(d100));
				System.out.println("Result: " + gemstone.getName());
				System.out.println("Generating gemstone value");
				GemValue gemValue = gemstone.getGrade().getValue();
				double result = gemValue.getBaseValue() + roller.roll(gemValue.getDice()) * gemValue.getMultiplier();
				gemstone.setValue(result);
				System.out.println("Gemstone value result: " + result + "\n");
				gems.add(gemstone);
			}
		}

		return gems;
	}

}
