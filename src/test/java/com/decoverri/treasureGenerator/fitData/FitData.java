package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.dao.TreasureTypeDao;
import com.decoverri.treasureGenerator.dao.TreasureTypeValueDao;
import com.decoverri.treasureGenerator.model.TreasureType;
import com.decoverri.treasureGenerator.model.TreasureTypeValue;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitData {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	private Transaction transaction;
	
	private XStream xstream = new XStream(new JettisonMappedXmlDriver());

	@Before
	public void before() {
		transaction = session.beginTransaction();
	}

	@After
	public void after() {
		transaction.commit();
	}
	
	@Test
	public void fitTreasureTypes() throws Exception {
		TreasureTypeDao treasureTypesDao = new TreasureTypeDao(session);
		TreasureTypeValueDao treasureTypeValueDao = new TreasureTypeValueDao(session);

		xstream.alias("type", TreasureType.class);
		xstream.alias("value", TreasureTypeValue.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/treasureTypes.json"));
		while (scanner.hasNextLine()) {
			TreasureType type = (TreasureType) xstream.fromXML(scanner.nextLine());
			treasureTypeValueDao.saveOrLoad(type.getValues());
			treasureTypesDao.saveOrUpdate(type);
		}
		scanner.close();

	}
	
//		new FitGems(session).fit();
//
//		new FitArtObjects(session).fit();
//
//		new FitPotions(session).fit();
//		new FitPotionLevel(session).fit();
//
//		new FitScrolls(session).fit();
//		new FitScrollLevel(session).fit();
//
//		new FitWand(session).fit();
//		new FitWandLevel(session).fit();
//
//		new FitArmor(session).fit();
//		new FitSpecificArmor(session).fit();
//		new FitMagicArmorAbility(session).fit();
//		new FitMagicArmorStats(session).fit();
//
//		new FitWeapon(session).fit();
//		new FitSpecificWeapon(session).fit();
//		new FitMagicWeaponAbility(session).fit();
//		new FitFoe(session).fit();
//		new FitMagicWeaponStats(session).fit();
//
//		new FitWondrousItem(session).fit();
//		new FitWondrousItemBodySlot(session).fit();
//
//		new FitRing(session).fit();
//
//		new FitRod(session).fit();
//		new FitMetamagicRod(session).fit();
//
//		new FitStaff(session).fit();
//		
//		new FitTreasure(session).fit();
//
}
