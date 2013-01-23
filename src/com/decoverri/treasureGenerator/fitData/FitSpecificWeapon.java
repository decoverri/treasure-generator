package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.treasure.SpecificWeaponDao;
import com.decoverri.treasureGenerator.model.treasure.SpecificWeapon;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitSpecificWeapon {

	private Session session;

	public FitSpecificWeapon(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("weapon", SpecificWeapon.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/specificWeapons.txt"));
		while (scanner.hasNextLine()) {
			SpecificWeapon weapon = (SpecificWeapon) xstream.fromXML(scanner.nextLine());
			SpecificWeaponDao weaponDao = new SpecificWeaponDao(session);
			weaponDao.saveOrUpdate(weapon);
		}
		scanner.close();
	}

}