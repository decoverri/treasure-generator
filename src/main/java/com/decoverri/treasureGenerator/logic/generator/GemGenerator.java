package com.decoverri.treasureGenerator.logic.generator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.dao.treasure.GemstoneDao;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.treasure.Gemstone;
import com.decoverri.treasureGenerator.model.treasure.complement.GemValue;
import com.decoverri.treasureGenerator.model.treasure.data.GemstoneGeneratorData;

@Component
public class GemGenerator {

	@Autowired
	private GemstoneDao dao;

	private DiceRoller roller;
	private Dice d100;

	public GemGenerator() {
		this.roller = new DiceRoller();
		this.d100 = new Dice(100);
	}

	public List<Gemstone> generate(List<GemstoneGeneratorData> gemsData) {
		List<Gemstone> gems = new ArrayList<Gemstone>();

		for (GemstoneGeneratorData data : gemsData) {
			gems.addAll(generate(data));
		}

		return gems;
	}

	private List<Gemstone> generate(GemstoneGeneratorData data) {
		List<Gemstone> gems = new ArrayList<Gemstone>();

		for (int i = 0; i < data.getQuantity(); i++) {
			gems.add(generate(data.getGrade()));
		}

		return gems;
	}

	private Gemstone generate(int grade) {
		System.out.println("Generating grade " + grade + " gemstone");

		Gemstone gemstone = dao.getGem(grade, roller.roll(d100));

		System.out.println("Result: " + gemstone.getName());
		System.out.println("Generating gemstone value");

		GemValue gemValue = gemstone.getGrade().getValue();
		double result = gemValue.getBaseValue() + roller.roll(gemValue.getDice()) * gemValue.getMultiplier();
		gemstone.setValue(result);

		System.out.println("Gemstone value result: " + result + "\n");

		return gemstone;
	}

}
