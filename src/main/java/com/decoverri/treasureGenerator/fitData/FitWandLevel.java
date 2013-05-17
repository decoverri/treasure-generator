package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.decoverri.treasureGenerator.dao.treasure.complement.WandLevelDao;
import com.decoverri.treasureGenerator.model.treasure.complement.WandLevel;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitWandLevel {

	@Autowired
	private WandLevelDao wandDao;

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("wandlevel", WandLevel.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/wandLevel.txt"));
		while (scanner.hasNextLine()) {
			WandLevel wandLevel = (WandLevel) xstream.fromXML(scanner.nextLine());
			wandDao.saveOrUpdate(wandLevel);
		}
		scanner.close();
	}

}
