package com.decoverri.treasureGenerator.config.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.WandLevelDao;
import com.decoverri.treasureGenerator.model.WandLevel;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitWandLevel {

	private Session session;

	public FitWandLevel(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("wandlevel", WandLevel.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/wandLevel.txt"));
		while (scanner.hasNextLine()) {
			WandLevel wandLevel = (WandLevel) xstream.fromXML(scanner.nextLine());
			WandLevelDao wandDao = new WandLevelDao(session);
			wandDao.saveOrUpdate(wandLevel);
		}
		scanner.close();
	}

}
