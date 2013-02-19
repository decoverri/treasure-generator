package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.decoverri.treasureGenerator.dao.treasure.WondrousItemDao;
import com.decoverri.treasureGenerator.model.treasure.WondrousItem;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitWondrousItem {

	@Autowired
	private WondrousItemDao itemDao;

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("item", WondrousItem.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/wondrousItems.txt"));
		while (scanner.hasNextLine()) {
			WondrousItem item = (WondrousItem) xstream.fromXML(scanner.nextLine());
			itemDao.saveOrUpdate(item);
		}
		scanner.close();
	}

}
