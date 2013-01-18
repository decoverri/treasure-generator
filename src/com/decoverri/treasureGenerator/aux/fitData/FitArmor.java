package com.decoverri.treasureGenerator.aux.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.treasure.dao.ArmorDao;
import com.decoverri.treasureGenerator.treasure.model.Armor;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitArmor {

	private Session session;

	public FitArmor(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("armor", Armor.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/armors.txt"));
		while (scanner.hasNextLine()) {
			Armor armor = (Armor) xstream.fromXML(scanner.nextLine());
			ArmorDao armorDao = new ArmorDao(session);
			armorDao.saveOrUpdate(armor);
		}
		scanner.close();
	}

}