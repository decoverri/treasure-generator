package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.treasure.complement.MagicWeaponAbilityDao;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicWeaponAbility;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitMagicWeaponAbility {

	private Session session;

	public FitMagicWeaponAbility(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("ability", MagicWeaponAbility.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/magicWeaponAbilities.txt"));
		while (scanner.hasNextLine()) {
			MagicWeaponAbility ability = (MagicWeaponAbility) xstream.fromXML(scanner.nextLine());
			MagicWeaponAbilityDao abilityDao = new MagicWeaponAbilityDao(session);
			abilityDao.saveOrUpdate(ability);
		}
		scanner.close();
	}

}
