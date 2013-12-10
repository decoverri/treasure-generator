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
import com.decoverri.treasureGenerator.dao.treasure.GemstoneDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.GemGradeDao;
import com.decoverri.treasureGenerator.model.TreasureType;
import com.decoverri.treasureGenerator.model.TreasureTypeValue;
import com.decoverri.treasureGenerator.model.treasure.Gemstone;
import com.decoverri.treasureGenerator.model.treasure.complement.GemGrade;
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
	
	@Test
	public void fitGems() throws Exception {
		GemstoneDao gemDao = new GemstoneDao(session);
		GemGradeDao gradeDao = new GemGradeDao(session);

		xstream.alias("gem", Gemstone.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/gems.json"));
		while (scanner.hasNextLine()) {
			Gemstone gem = (Gemstone) xstream.fromXML(scanner.nextLine());
			if (!gemDao.exists(gem.getName())) {
				GemGrade gradeSearch = gradeDao.searchByGradeNumber(gem.getGrade());
				if (gradeSearch == null) {
					gradeDao.save(gem.getGrade());
				} else {
					gem.setGrade(gradeSearch);
				}
				gemDao.saveOrUpdate(gem);
			}
		}
		scanner.close();
	}
	
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
