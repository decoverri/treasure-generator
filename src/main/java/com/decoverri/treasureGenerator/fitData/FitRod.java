package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.decoverri.treasureGenerator.dao.treasure.RodDao;
import com.decoverri.treasureGenerator.model.treasure.Rod;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitRod {

	@Autowired
	private RodDao rodDao;

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("rod", Rod.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/rods.json"));
		while (scanner.hasNextLine()) {
			Rod rod = (Rod) xstream.fromXML(scanner.nextLine());
			rodDao.saveOrUpdate(rod);
		}
		scanner.close();
	}

}
