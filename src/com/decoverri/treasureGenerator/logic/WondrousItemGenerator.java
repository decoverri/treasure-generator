package com.decoverri.treasureGenerator.logic;

import static com.decoverri.treasureGenerator.enums.MagicItemStrength.LEAST_MINOR;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.WondrousItemBodySlotDao;
import com.decoverri.treasureGenerator.dao.WondrousItemDao;
import com.decoverri.treasureGenerator.enums.BodySlot;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.generator.WondrousItemGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.WondrousItem;

public class WondrousItemGenerator {

	private Session session;

	public WondrousItemGenerator(Session session) {
		this.session = session;
	}

	public List<WondrousItem> generate(List<WondrousItemGeneratorData> itemsData) {

		List<WondrousItem> items = new ArrayList<WondrousItem>();
		WondrousItemDao itemDao = new WondrousItemDao(session);
		WondrousItemBodySlotDao bodySlotDao = new WondrousItemBodySlotDao(session);
		Dice d100 = new Dice(100);
		DiceRoller roller = new DiceRoller();

		for (WondrousItemGeneratorData data : itemsData) {
			for (int i = 0; i < data.getQuantity(); i++) {
				System.out.println("Generating " + data.getStrength() + " wondrous item");
				System.out.println("Generating wondrous item body slot");
				BodySlot slot = bodySlotDao.getWondrousItemBodySlot(roller.roll(d100));
				System.out.println("Result: " + slot);
				System.out.println("Generating " + slot + " " + data.getStrength() + " wondrous item");
				WondrousItem item = itemDao.getWondrousItem(data.getStrength(), slot, roller.roll(d100));
				if (item.getName().equals("Roll on the Least Minor table")) {
					System.out.println("Result: " + item.getName());
					System.out.println("Generating " + LEAST_MINOR + " " + data.getStrength() + " wondrous item");
					item = itemDao.getWondrousItem(LEAST_MINOR, slot, roller.roll(d100));
				}
				System.out.println("Result: " + item.getName() + "\n");
				items.add(item);
			}
		}

		return items;
	}

}
