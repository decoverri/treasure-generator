package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.treasure.complement.ScrollLevelDao;
import com.decoverri.treasureGenerator.model.treasure.complement.ScrollLevel;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitScrollLevel {

	private Session session;

	public FitScrollLevel(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("scrolllevel", ScrollLevel.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/scrollLevel.txt"));
		while (scanner.hasNextLine()) {
			ScrollLevel scrollLevel = (ScrollLevel) xstream.fromXML(scanner.nextLine());
			ScrollLevelDao scrollDao = new ScrollLevelDao(session);
			scrollDao.saveOrUpdate(scrollLevel);
		}
		scanner.close();
	}

}
