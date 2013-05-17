package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.decoverri.treasureGenerator.dao.treasure.complement.MagicArmorStatsDao;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicArmorStats;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitMagicArmorStats {

	@Autowired
	private MagicArmorStatsDao statsDao;

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("stats", MagicArmorStats.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/magicArmorStats.txt"));
		while (scanner.hasNextLine()) {
			MagicArmorStats stats = (MagicArmorStats) xstream.fromXML(scanner.nextLine());
			statsDao.saveOrUpdate(stats);
		}
		scanner.close();
	}

}
