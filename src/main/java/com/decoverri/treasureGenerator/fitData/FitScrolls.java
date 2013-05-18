package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.decoverri.treasureGenerator.dao.treasure.ScrollDao;
import com.decoverri.treasureGenerator.model.treasure.Scroll;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitScrolls {

	@Autowired
	private ScrollDao scrollDao;

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("scroll", Scroll.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/scrolls.json"));
		while (scanner.hasNextLine()) {
			Scroll scroll = (Scroll) xstream.fromXML(scanner.nextLine());
			scrollDao.saveOrUpdate(scroll);
		}
		scanner.close();
	}

}
