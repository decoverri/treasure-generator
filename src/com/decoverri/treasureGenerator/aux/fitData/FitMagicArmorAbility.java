package com.decoverri.treasureGenerator.aux.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.treasure.aux.dao.MagicArmorAbilityDao;
import com.decoverri.treasureGenerator.treasure.aux.model.MagicArmorAbility;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitMagicArmorAbility {

	private Session session;

	public FitMagicArmorAbility(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("ability", MagicArmorAbility.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/magicArmorAbilities.txt"));
		while (scanner.hasNextLine()) {
			MagicArmorAbility ability = (MagicArmorAbility) xstream.fromXML(scanner.nextLine());
			MagicArmorAbilityDao abilityDao = new MagicArmorAbilityDao(session);
			abilityDao.saveOrUpdate(ability);
		}
		scanner.close();
	}

}
