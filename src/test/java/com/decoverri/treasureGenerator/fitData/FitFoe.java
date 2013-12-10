package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.decoverri.treasureGenerator.dao.treasure.complement.FoeDao;
import com.decoverri.treasureGenerator.model.treasure.complement.Foe;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitFoe {

	@Autowired
	private FoeDao foeDao;

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("foe", Foe.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/foes.json"));
		while (scanner.hasNextLine()) {
			Foe foe = (Foe) xstream.fromXML(scanner.nextLine());
			foeDao.saveOrUpdate(foe);
		}
		scanner.close();
	}

}
