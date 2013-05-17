package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.decoverri.treasureGenerator.dao.treasure.complement.MagicArmorAbilityDao;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicArmorAbility;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitMagicArmorAbility {

	@Autowired
	private MagicArmorAbilityDao abilityDao;

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("ability", MagicArmorAbility.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/magicArmorAbilities.txt"));
		while (scanner.hasNextLine()) {
			MagicArmorAbility ability = (MagicArmorAbility) xstream.fromXML(scanner.nextLine());
			abilityDao.saveOrUpdate(ability);
		}
		scanner.close();
	}

}
