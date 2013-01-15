package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.WandDao;
import com.decoverri.treasureGenerator.model.treasure.Wand;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitWand {

	private Session session;

	public FitWand(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("wand", Wand.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/wands.txt"));
		while (scanner.hasNextLine()) {
			Wand wand = (Wand) xstream.fromXML(scanner.nextLine());
			WandDao wandDao = new WandDao(session);
			wandDao.saveOrUpdate(wand);
		}
		scanner.close();
	}

}
