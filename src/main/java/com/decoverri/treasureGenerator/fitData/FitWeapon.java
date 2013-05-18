package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.decoverri.treasureGenerator.dao.treasure.WeaponDao;
import com.decoverri.treasureGenerator.model.treasure.Weapon;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitWeapon {

	@Autowired
	private WeaponDao weaponDao;

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("weapon", Weapon.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/weapons.json"));
		while (scanner.hasNextLine()) {
			Weapon weapon = (Weapon) xstream.fromXML(scanner.nextLine());
			weaponDao.saveOrUpdate(weapon);
		}
		scanner.close();
	}

}
