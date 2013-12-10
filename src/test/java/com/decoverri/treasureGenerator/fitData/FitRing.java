package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.decoverri.treasureGenerator.dao.treasure.RingDao;
import com.decoverri.treasureGenerator.model.treasure.Ring;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitRing {

	@Autowired
	private RingDao ringDao;

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("ring", Ring.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/rings.json"));
		while (scanner.hasNextLine()) {
			Ring ring = (Ring) xstream.fromXML(scanner.nextLine());
			ringDao.saveOrUpdate(ring);
		}
		scanner.close();
	}

}