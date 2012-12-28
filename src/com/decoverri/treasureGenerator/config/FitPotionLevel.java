package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.PotionLevelDao;
import com.decoverri.treasureGenerator.model.PotionLevel;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitPotionLevel {

	private Session session;

	public FitPotionLevel(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("potionlevel", PotionLevel.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/potionLevel.txt"));
		while (scanner.hasNextLine()) {
			PotionLevel potionLevel = (PotionLevel) xstream.fromXML(scanner.nextLine());
			PotionLevelDao potionDao = new PotionLevelDao(session);
			potionDao.saveOrUpdate(potionLevel);
		}
		scanner.close();
	}

}
