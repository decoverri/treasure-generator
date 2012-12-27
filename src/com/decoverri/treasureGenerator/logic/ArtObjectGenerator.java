package com.decoverri.treasureGenerator.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.ArtObjectDao;
import com.decoverri.treasureGenerator.model.ArtObject;
import com.decoverri.treasureGenerator.model.ArtObjectGeneratorData;
import com.decoverri.treasureGenerator.model.Dice;

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
