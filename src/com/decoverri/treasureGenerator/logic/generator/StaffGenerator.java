package com.decoverri.treasureGenerator.logic.generator;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.data.StaffGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.Staff;
import com.decoverri.treasureGenerator.model.treasure.complement.StaffDao;

public class StaffGenerator {

	private StaffDao staffDao;

	private DiceRoller roller;
	private Dice d100;

	public StaffGenerator(Session session) {
		this.staffDao = new StaffDao(session);
		this.roller = new DiceRoller();
		this.d100 = new Dice(100);
	}

	public List<Staff> generate(List<StaffGeneratorData> stavesData) {
		List<Staff> staves = new ArrayList<Staff>();

		for (StaffGeneratorData data : stavesData) {
			staves.addAll(generate(data));
		}

		return staves;
	}

	private List<Staff> generate(StaffGeneratorData data) {
		List<Staff> staves = new ArrayList<Staff>();

		for (int i = 0; i < data.getQuantity(); i++) {
			staves.add(generate(data.getStrength()));
		}

		return staves;
	}

	private Staff generate(MagicItemStrength strength) {
		System.out.println("Generating " + strength + " ring");

		Staff staff = staffDao.getStaff(strength, roller.roll(d100));

		System.out.println("Result: " + staff.getName() + "\n");

		return staff;
	}
}
