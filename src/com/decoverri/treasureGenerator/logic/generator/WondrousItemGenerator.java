package com.decoverri.treasureGenerator.logic.generator;

import static com.decoverri.treasureGenerator.enums.MagicItemStrength.LEAST_MINOR;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.treasure.WondrousItemDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.WondrousItemBodySlotDao;
import com.decoverri.treasureGenerator.enums.BodySlot;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;
import com.decoverri.treasureGenerator.model.data.WondrousItemGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.WondrousItem;

public class WondrousItemGenerator {

	private WondrousItemDao itemDao;
	private WondrousItemBodySlotDao bodySlotDao;

	private DiceRoller roller;
	private Dice d100;

	public WondrousItemGenerator(Session session) {
		this.itemDao = new WondrousItemDao(session);
		this.bodySlotDao = new WondrousItemBodySlotDao(session);
		this.roller = new DiceRoller();
		this.d100 = new Dice(100);
	}

	public List<WondrousItem> generate(List<WondrousItemGeneratorData> itemsData) {
		List<WondrousItem> items = new ArrayList<WondrousItem>();

		for (WondrousItemGeneratorData data : itemsData) {
			items.addAll(generate(data));
		}

		return items;
	}

	private List<WondrousItem> generate(WondrousItemGeneratorData data) {
		List<WondrousItem> items = new ArrayList<WondrousItem>();

		for (int i = 0; i < data.getQuantity(); i++) {
			items.add(generate(data.getStrength()));
		}

		return items;
	}

	private WondrousItem generate(MagicItemStrength strength) {
		System.out.println("Generating " + strength + " wondrous item");
		System.out.println("Generating wondrous item body slot");

		BodySlot slot = bodySlotDao.getWondrousItemBodySlot(roller.roll(d100));

		System.out.println("Result: " + slot);
		System.out.println("Generating " + slot + " " + strength + " wondrous item");

		WondrousItem item = itemDao.getWondrousItem(strength, slot, roller.roll(d100));

		if (item.getName().equals("Roll on the Least Minor table")) {
			System.out.println("Result: " + item.getName());
			System.out.println("Generating " + LEAST_MINOR + " " + strength + " wondrous item");
			item = itemDao.getWondrousItem(LEAST_MINOR, slot, roller.roll(d100));
		}

		System.out.println("Result: " + item.getName() + "\n");

		return item;
	}
}
