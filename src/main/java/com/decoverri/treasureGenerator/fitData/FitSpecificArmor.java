package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.decoverri.treasureGenerator.dao.treasure.SpecificArmorDao;
import com.decoverri.treasureGenerator.model.treasure.SpecificArmor;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitSpecificArmor {

	@Autowired
	private SpecificArmorDao armorDao;

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("armor", SpecificArmor.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/specificArmors.txt"));
		while (scanner.hasNextLine()) {
			SpecificArmor armor = (SpecificArmor) xstream.fromXML(scanner.nextLine());
			armorDao.saveOrUpdate(armor);
		}
		scanner.close();
	}

}
