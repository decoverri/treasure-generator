package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.treasure.complement.FoeDao;
import com.decoverri.treasureGenerator.model.treasure.complement.Foe;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitFoe {

	private Session session;

	public FitFoe(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("foe", Foe.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/foes.txt"));
		while (scanner.hasNextLine()) {
			Foe foe = (Foe) xstream.fromXML(scanner.nextLine());
			FoeDao foeDao = new FoeDao(session);
			foeDao.saveOrUpdate(foe);
		}
		scanner.close();
	}

}
