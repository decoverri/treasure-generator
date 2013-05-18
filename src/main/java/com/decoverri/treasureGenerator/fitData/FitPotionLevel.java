package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.decoverri.treasureGenerator.dao.treasure.complement.PotionLevelDao;
import com.decoverri.treasureGenerator.model.treasure.complement.PotionLevel;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitPotionLevel {

	@Autowired
	private PotionLevelDao potionDao;

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("potionlevel", PotionLevel.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/potionLevel.json"));
		while (scanner.hasNextLine()) {
			PotionLevel potionLevel = (PotionLevel) xstream.fromXML(scanner.nextLine());
			potionDao.saveOrUpdate(potionLevel);
		}
		scanner.close();
	}

}
