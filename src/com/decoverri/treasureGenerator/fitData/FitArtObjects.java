package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.treasure.ArtObjectDao;
import com.decoverri.treasureGenerator.model.treasure.ArtObject;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitArtObjects {

	private Session session;

	public FitArtObjects(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("art", ArtObject.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/artObjects.txt"));
		while (scanner.hasNextLine()) {
			ArtObject art = (ArtObject) xstream.fromXML(scanner.nextLine());
			ArtObjectDao artDao = new ArtObjectDao(session);
			if (!artDao.exists(art.getName())) {
				artDao.saveOrUpdate(art);
			}
		}
		scanner.close();
	}

}
