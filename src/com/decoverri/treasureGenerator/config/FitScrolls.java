package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.ScrollDao;
import com.decoverri.treasureGenerator.model.Scroll;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitScrolls {

	private Session session;

	public FitScrolls(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("scroll", Scroll.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/scrolls.txt"));
		while (scanner.hasNextLine()) {
			Scroll scroll = (Scroll) xstream.fromXML(scanner.nextLine());
			ScrollDao scrollDao = new ScrollDao(session);
			if (!scrollDao.exists(scroll)) {
				scrollDao.saveOrUpdate(scroll);
			}
		}
		scanner.close();
	}

}
