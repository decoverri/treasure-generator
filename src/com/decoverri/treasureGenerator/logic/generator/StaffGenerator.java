package com.decoverri.treasureGenerator.logic.generator;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.model.StaffGeneratorData;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.treasure.aux.model.StaffDao;
import com.decoverri.treasureGenerator.treasure.model.Staff;

public class StaffGenerator {

	private Session session;

	public StaffGenerator(Session session) {
		this.session = session;
	}

	public List<Staff> generate(List<StaffGeneratorData> stavesData) {

		List<Staff> staves = new ArrayList<Staff>();
		StaffDao staffDao = new StaffDao(session);
		Dice d100 = new Dice(100);
		DiceRoller roller = new DiceRoller();

		for (StaffGeneratorData data : stavesData) {
			for (int i = 0; i < data.getQuantity(); i++) {
				System.out.println("Generating " + data.getStrength() + " ring");
				Staff staff = staffDao.getStaff(data.getStrength(), roller.roll(d100));
				System.out.println("Result: " + staff.getName() + "\n");
				staves.add(staff);
			}
		}

		return staves;
	}

}
