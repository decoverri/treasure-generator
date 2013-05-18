package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.decoverri.treasureGenerator.dao.treasure.complement.MagicWeaponStatsDao;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicWeaponStats;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitMagicWeaponStats {

	@Autowired
	private MagicWeaponStatsDao statsDao;

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("stats", MagicWeaponStats.class);
		xstream.alias("int", Integer.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/magicWeaponStats.json"));
		while (scanner.hasNextLine()) {
			MagicWeaponStats stats = (MagicWeaponStats) xstream.fromXML(scanner.nextLine());
			statsDao.saveOrUpdate(stats);
		}
		scanner.close();
	}

}
