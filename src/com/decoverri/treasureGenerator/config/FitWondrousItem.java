package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.WondrousItemDao;
import com.decoverri.treasureGenerator.model.WondrousItem;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitWondrousItem {

	private Session session;

	public FitWondrousItem(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("item", WondrousItem.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/wondrousItems.txt"));
		while (scanner.hasNextLine()) {
			WondrousItem item = (WondrousItem) xstream.fromXML(scanner.nextLine());
			WondrousItemDao itemDao = new WondrousItemDao(session);
			itemDao.saveOrUpdate(item);
		}
		scanner.close();
	}

}
