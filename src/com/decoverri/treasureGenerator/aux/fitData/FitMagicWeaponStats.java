package com.decoverri.treasureGenerator.aux.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.treasure.aux.dao.MagicWeaponStatsDao;
import com.decoverri.treasureGenerator.treasure.aux.model.MagicWeaponStats;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitMagicWeaponStats {

	private Session session;

	public FitMagicWeaponStats(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("stats", MagicWeaponStats.class);
		xstream.alias("int", Integer.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/magicWeaponStats.txt"));
		while (scanner.hasNextLine()) {
			MagicWeaponStats stats = (MagicWeaponStats) xstream.fromXML(scanner.nextLine());
			MagicWeaponStatsDao statsDao = new MagicWeaponStatsDao(session);
			statsDao.saveOrUpdate(stats);
		}
		scanner.close();
	}

}
