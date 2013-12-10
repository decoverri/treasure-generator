package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.TreasureTypeDao;
import com.decoverri.treasureGenerator.model.TreasureType;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitTreasureTypes {

	private TreasureTypeDao treasureTypesDao;

	public FitTreasureTypes(Session session) {
		this.treasureTypesDao = new TreasureTypeDao(session);
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("type", TreasureType.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/treasureTypes.json"));
		while (scanner.hasNextLine()) {
			TreasureType type = (TreasureType) xstream.fromXML(scanner.nextLine());
			treasureTypesDao.saveOrUpdate(type);
		}
		scanner.close();
	}

}
