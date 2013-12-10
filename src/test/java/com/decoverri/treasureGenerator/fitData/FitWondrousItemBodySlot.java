package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.decoverri.treasureGenerator.dao.treasure.complement.WondrousItemBodySlotDao;
import com.decoverri.treasureGenerator.model.treasure.complement.WondrousItemBodySlot;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitWondrousItemBodySlot {

	@Autowired
	private WondrousItemBodySlotDao slotDao;

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("wondrousitemslot", WondrousItemBodySlot.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/wondrousItemBodySlots.json"));
		while (scanner.hasNextLine()) {
			WondrousItemBodySlot wondrousItemSlot = (WondrousItemBodySlot) xstream.fromXML(scanner.nextLine());
			slotDao.saveOrUpdate(wondrousItemSlot);
		}
		scanner.close();
	}

}
