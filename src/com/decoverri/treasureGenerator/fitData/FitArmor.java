package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.decoverri.treasureGenerator.dao.treasure.ArmorDao;
import com.decoverri.treasureGenerator.model.treasure.Armor;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitArmor {

	@Autowired
	private ArmorDao armorDao;

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("armor", Armor.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/armors.txt"));
		while (scanner.hasNextLine()) {
			Armor armor = (Armor) xstream.fromXML(scanner.nextLine());
			armorDao.saveOrUpdate(armor);
		}
		scanner.close();
	}

}
