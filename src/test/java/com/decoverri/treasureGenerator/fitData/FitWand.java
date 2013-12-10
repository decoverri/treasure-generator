package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.decoverri.treasureGenerator.dao.treasure.WandDao;
import com.decoverri.treasureGenerator.model.treasure.Wand;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitWand {

	@Autowired
	private WandDao wandDao;

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("wand", Wand.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/wands.json"));
		while (scanner.hasNextLine()) {
			Wand wand = (Wand) xstream.fromXML(scanner.nextLine());
			wandDao.saveOrUpdate(wand);
		}
		scanner.close();
	}

}
