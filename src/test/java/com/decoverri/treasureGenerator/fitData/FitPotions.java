package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.decoverri.treasureGenerator.dao.treasure.PotionDao;
import com.decoverri.treasureGenerator.model.treasure.Potion;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitPotions {

	@Autowired
	private PotionDao potionDao;

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("potion", Potion.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/potions.json"));
		while (scanner.hasNextLine()) {
			Potion potion = (Potion) xstream.fromXML(scanner.nextLine());
			potionDao.saveOrUpdate(potion);
		}
		scanner.close();
	}

}
