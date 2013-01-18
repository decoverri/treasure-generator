package com.decoverri.treasureGenerator.aux.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.treasure.aux.dao.WondrousItemBodySlotDao;
import com.decoverri.treasureGenerator.treasure.aux.model.WondrousItemBodySlot;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitWondrousItemBodySlot {

	private Session session;

	public FitWondrousItemBodySlot(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("wondrousitemslot", WondrousItemBodySlot.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/wondrousItemBodySlots.txt"));
		while (scanner.hasNextLine()) {
			WondrousItemBodySlot wondrousItemSlot = (WondrousItemBodySlot) xstream.fromXML(scanner.nextLine());
			WondrousItemBodySlotDao slotDao = new WondrousItemBodySlotDao(session);
			slotDao.saveOrUpdate(wondrousItemSlot);
		}
		scanner.close();
	}

}
