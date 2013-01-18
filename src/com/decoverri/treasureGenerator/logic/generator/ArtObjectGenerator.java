package com.decoverri.treasureGenerator.logic.generator;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.model.ArtObjectGeneratorData;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.treasure.dao.ArtObjectDao;
import com.decoverri.treasureGenerator.treasure.model.ArtObject;

public class ArtObjectGenerator {

	private Session session;

	public ArtObjectGenerator(Session session) {
		this.session = session;
	}

	public List<ArtObject> generate(List<ArtObjectGeneratorData> artData) {

		List<ArtObject> arts = new ArrayList<ArtObject>();
		ArtObjectDao artDao = new ArtObjectDao(session);
		Dice d100 = new Dice(100);
		DiceRoller roller = new DiceRoller();

		for (ArtObjectGeneratorData art : artData) {
			for (int i = 0; i < art.getQuantity(); i++) {
				System.out.println("Generating grade " + art.getGrade() + " art object");
				ArtObject artObject = artDao.getArt(art.getGrade(), roller.roll(d100));
				System.out.println("Result: " + artObject.getName() + "\n");
				arts.add(artObject);
			}
		}

		return arts;
	}


}
