package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.RodDao;
import com.decoverri.treasureGenerator.model.treasure.Rod;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitRod {

	private Session session;

	public FitRod(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("rod", Rod.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/rods.txt"));
		while (scanner.hasNextLine()) {
			Rod rod = (Rod) xstream.fromXML(scanner.nextLine());
			RodDao rodDao = new RodDao(session);
			rodDao.saveOrUpdate(rod);
		}
		scanner.close();
	}

}
