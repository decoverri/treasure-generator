package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.MetamagicRodDao;
import com.decoverri.treasureGenerator.model.MetamagicRod;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitMetamagicRod {

	private Session session;

	public FitMetamagicRod(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("metamagic", MetamagicRod.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/metamagicRods.txt"));
		while (scanner.hasNextLine()) {
			MetamagicRod metamagic = (MetamagicRod) xstream.fromXML(scanner.nextLine());
			MetamagicRodDao metamagicDao = new MetamagicRodDao(session);
			metamagicDao.saveOrUpdate(metamagic);
		}
		scanner.close();
	}

}
