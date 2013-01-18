package com.decoverri.treasureGenerator.aux.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.treasure.aux.dao.MagicArmorStatsDao;
import com.decoverri.treasureGenerator.treasure.aux.model.MagicArmorStats;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitMagicArmorStats {

	private Session session;

	public FitMagicArmorStats(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("stats", MagicArmorStats.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/magicArmorStats.txt"));
		while (scanner.hasNextLine()) {
			MagicArmorStats stats = (MagicArmorStats) xstream.fromXML(scanner.nextLine());
			MagicArmorStatsDao statsDao = new MagicArmorStatsDao(session);
			statsDao.saveOrUpdate(stats);
		}
		scanner.close();
	}

}
