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
import com.decoverri.treasureGenerator.dao.treasure.ArtObjectDao;
import com.decoverri.treasureGenerator.dao.treasure.GemstoneDao;
import com.decoverri.treasureGenerator.dao.treasure.PotionDao;
import com.decoverri.treasureGenerator.dao.treasure.ScrollDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.GemGradeDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.PotionLevelDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.ScrollLevelDao;
import com.decoverri.treasureGenerator.model.TreasureType;
import com.decoverri.treasureGenerator.model.TreasureTypeValue;
import com.decoverri.treasureGenerator.model.treasure.ArtObject;
import com.decoverri.treasureGenerator.model.treasure.Gemstone;
import com.decoverri.treasureGenerator.model.treasure.Potion;
import com.decoverri.treasureGenerator.model.treasure.Scroll;
import com.decoverri.treasureGenerator.model.treasure.complement.GemGrade;
import com.decoverri.treasureGenerator.model.treasure.complement.PotionLevel;
import com.decoverri.treasureGenerator.model.treasure.complement.ScrollLevel;
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
	
	@Test
	public void fitArtObjects() throws Exception {
		ArtObjectDao artDao = new ArtObjectDao(session);
		
		xstream.alias("art", ArtObject.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/artObjects.json"));
		while (scanner.hasNextLine()) {
			ArtObject art = (ArtObject) xstream.fromXML(scanner.nextLine());
			if (!artDao.exists(art.getName())) {
				artDao.saveOrUpdate(art);
			}
		}
		scanner.close();
	}
	
	@Test
	public void fitPotions() throws Exception {
		PotionDao potionDao = new PotionDao(session);

		xstream.alias("potion", Potion.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/potions.json"));
		while (scanner.hasNextLine()) {
			Potion potion = (Potion) xstream.fromXML(scanner.nextLine());
			potionDao.saveOrUpdate(potion);
		}
		scanner.close();
	}
	
	@Test
	public void fitPotionLevel() throws Exception {
		PotionLevelDao potionDao = new PotionLevelDao(session);

		xstream.alias("potionlevel", PotionLevel.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/potionLevel.json"));
		while (scanner.hasNextLine()) {
			PotionLevel potionLevel = (PotionLevel) xstream.fromXML(scanner.nextLine());
			potionDao.saveOrUpdate(potionLevel);
		}
		scanner.close();
	}
	
	@Test
	public void fitScrolls() throws Exception {
		ScrollDao scrollDao = new ScrollDao(session);

		xstream.alias("scroll", Scroll.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/scrolls.json"));
		while (scanner.hasNextLine()) {
			Scroll scroll = (Scroll) xstream.fromXML(scanner.nextLine());
			scrollDao.saveOrUpdate(scroll);
		}
		scanner.close();
	}
	
	@Test
	public void fitScrollLevel() throws Exception {
		ScrollLevelDao scrollDao = new ScrollLevelDao(session);

		xstream.alias("scrolllevel", ScrollLevel.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/scrollLevel.json"));
		while (scanner.hasNextLine()) {
			ScrollLevel scrollLevel = (ScrollLevel) xstream.fromXML(scanner.nextLine());
			scrollDao.saveOrUpdate(scrollLevel);
		}
		scanner.close();
	}
	
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
