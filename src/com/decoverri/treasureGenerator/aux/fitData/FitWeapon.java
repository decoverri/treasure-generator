package com.decoverri.treasureGenerator.aux.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.treasure.dao.WeaponDao;
import com.decoverri.treasureGenerator.treasure.model.Weapon;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitWeapon {

	private Session session;

	public FitWeapon(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("weapon", Weapon.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/weapons.txt"));
		while (scanner.hasNextLine()) {
			Weapon weapon = (Weapon) xstream.fromXML(scanner.nextLine());
			WeaponDao weaponDao = new WeaponDao(session);
			weaponDao.saveOrUpdate(weapon);
		}
		scanner.close();
	}

}
