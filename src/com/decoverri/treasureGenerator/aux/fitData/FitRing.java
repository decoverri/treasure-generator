package com.decoverri.treasureGenerator.aux.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.treasure.dao.RingDao;
import com.decoverri.treasureGenerator.treasure.model.Ring;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitRing {

	private Session session;

	public FitRing(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("ring", Ring.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/rings.txt"));
		while (scanner.hasNextLine()) {
			Ring ring = (Ring) xstream.fromXML(scanner.nextLine());
			RingDao ringDao = new RingDao(session);
			ringDao.saveOrUpdate(ring);
		}
		scanner.close();
	}

}
