package com.decoverri.treasureGenerator.aux.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.treasure.dao.SpecificArmorDao;
import com.decoverri.treasureGenerator.treasure.model.SpecificArmor;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitSpecificArmor {

	private Session session;

	public FitSpecificArmor(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("armor", SpecificArmor.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/specificArmors.txt"));
		while (scanner.hasNextLine()) {
			SpecificArmor armor = (SpecificArmor) xstream.fromXML(scanner.nextLine());
			SpecificArmorDao armorDao = new SpecificArmorDao(session);
			armorDao.saveOrUpdate(armor);
		}
		scanner.close();
	}

}
