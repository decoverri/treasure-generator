package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.decoverri.treasureGenerator.dao.treasure.complement.MetamagicRodDao;
import com.decoverri.treasureGenerator.model.treasure.complement.MetamagicRod;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitMetamagicRod {

	@Autowired
	private MetamagicRodDao metamagicDao;

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("metamagic", MetamagicRod.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/metamagicRods.json"));
		while (scanner.hasNextLine()) {
			MetamagicRod metamagic = (MetamagicRod) xstream.fromXML(scanner.nextLine());
			metamagicDao.saveOrUpdate(metamagic);
		}
		scanner.close();
	}

}
