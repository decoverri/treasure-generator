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
import com.decoverri.treasureGenerator.dao.treasure.ArmorDao;
import com.decoverri.treasureGenerator.dao.treasure.ArtObjectDao;
import com.decoverri.treasureGenerator.dao.treasure.GemstoneDao;
import com.decoverri.treasureGenerator.dao.treasure.PotionDao;
import com.decoverri.treasureGenerator.dao.treasure.ScrollDao;
import com.decoverri.treasureGenerator.dao.treasure.SpecificArmorDao;
import com.decoverri.treasureGenerator.dao.treasure.SpecificWeaponDao;
import com.decoverri.treasureGenerator.dao.treasure.WandDao;
import com.decoverri.treasureGenerator.dao.treasure.WeaponDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.FoeDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.GemGradeDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.MagicArmorAbilityDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.MagicArmorStatsDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.MagicWeaponAbilityDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.MagicWeaponStatsDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.PotionLevelDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.ScrollLevelDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.WandLevelDao;
import com.decoverri.treasureGenerator.model.TreasureType;
import com.decoverri.treasureGenerator.model.TreasureTypeValue;
import com.decoverri.treasureGenerator.model.treasure.Armor;
import com.decoverri.treasureGenerator.model.treasure.ArtObject;
import com.decoverri.treasureGenerator.model.treasure.Gemstone;
import com.decoverri.treasureGenerator.model.treasure.Potion;
import com.decoverri.treasureGenerator.model.treasure.Scroll;
import com.decoverri.treasureGenerator.model.treasure.SpecificArmor;
import com.decoverri.treasureGenerator.model.treasure.SpecificWeapon;
import com.decoverri.treasureGenerator.model.treasure.Wand;
import com.decoverri.treasureGenerator.model.treasure.Weapon;
import com.decoverri.treasureGenerator.model.treasure.complement.Foe;
import com.decoverri.treasureGenerator.model.treasure.complement.GemGrade;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicArmorAbility;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicArmorStats;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicWeaponAbility;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicWeaponStats;
import com.decoverri.treasureGenerator.model.treasure.complement.PotionLevel;
import com.decoverri.treasureGenerator.model.treasure.complement.ScrollLevel;
import com.decoverri.treasureGenerator.model.treasure.complement.WandLevel;
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
	
	@Test
	public void fitWands() throws Exception {
		WandDao wandDao = new WandDao(session);
		
		xstream.alias("wand", Wand.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/wands.json"));
		while (scanner.hasNextLine()) {
			Wand wand = (Wand) xstream.fromXML(scanner.nextLine());
			wandDao.saveOrUpdate(wand);
		}
		scanner.close();
	}
	
	@Test
	public void fitWandLevel() throws Exception {
		WandLevelDao wandDao = new WandLevelDao(session);
		
		xstream.alias("wandlevel", WandLevel.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/wandLevel.json"));
		while (scanner.hasNextLine()) {
			WandLevel wandLevel = (WandLevel) xstream.fromXML(scanner.nextLine());
			wandDao.saveOrUpdate(wandLevel);
		}
		scanner.close();
	}
	
	@Test
	public void fitArmor() throws Exception {
		ArmorDao armorDao = new ArmorDao(session);
		
		xstream.alias("armor", Armor.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/armors.json"));
		while (scanner.hasNextLine()) {
			Armor armor = (Armor) xstream.fromXML(scanner.nextLine());
			armorDao.saveOrUpdate(armor);
		}
		scanner.close();
	}
	
	@Test
	public void fitSpecficArmor() throws Exception {
		SpecificArmorDao armorDao = new SpecificArmorDao(session);
		
		xstream.alias("armor", SpecificArmor.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/specificArmors.json"));
		while (scanner.hasNextLine()) {
			SpecificArmor armor = (SpecificArmor) xstream.fromXML(scanner.nextLine());
			armorDao.saveOrUpdate(armor);
		}
		scanner.close();
	}
	
	@Test
	public void fitMagicArmorAbilities() throws Exception {
		MagicArmorAbilityDao abilityDao = new MagicArmorAbilityDao(session);
		
		xstream.alias("ability", MagicArmorAbility.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/magicArmorAbilities.json"));
		while (scanner.hasNextLine()) {
			MagicArmorAbility ability = (MagicArmorAbility) xstream.fromXML(scanner.nextLine());
			abilityDao.saveOrUpdate(ability);
		}
		scanner.close();
	}
	
	@Test
	public void fitMagicArmorStats() throws Exception {
		MagicArmorStatsDao statsDao = new MagicArmorStatsDao(session);
		
		xstream.alias("stats", MagicArmorStats.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/magicArmorStats.json"));
		while (scanner.hasNextLine()) {
			MagicArmorStats stats = (MagicArmorStats) xstream.fromXML(scanner.nextLine());
			statsDao.saveOrUpdate(stats);
		}
		scanner.close();
	}
	
	@Test
	public void fitWeapons() throws Exception {
		WeaponDao weaponDao = new WeaponDao(session);
		
		xstream.alias("weapon", Weapon.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/weapons.json"));
		while (scanner.hasNextLine()) {
			Weapon weapon = (Weapon) xstream.fromXML(scanner.nextLine());
			weaponDao.saveOrUpdate(weapon);
		}
		scanner.close();
	}
	
	@Test
	public void fitSpecificWeapons() throws Exception {
		SpecificWeaponDao weaponDao = new SpecificWeaponDao(session);
		
		xstream.alias("weapon", SpecificWeapon.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/specificWeapons.json"));
		while (scanner.hasNextLine()) {
			SpecificWeapon weapon = (SpecificWeapon) xstream.fromXML(scanner.nextLine());
			weaponDao.saveOrUpdate(weapon);
		}
		scanner.close();
	}
	
	@Test
	public void fitMagicWeaponAbilities() throws Exception {
		MagicWeaponAbilityDao abilityDao = new MagicWeaponAbilityDao(session);
		
		xstream.alias("ability", MagicWeaponAbility.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/magicWeaponAbilities.json"));
		while (scanner.hasNextLine()) {
			MagicWeaponAbility ability = (MagicWeaponAbility) xstream.fromXML(scanner.nextLine());
			abilityDao.saveOrUpdate(ability);
		}
		scanner.close();
	}
	
	@Test
	public void fitFoes() throws Exception {
		FoeDao foeDao = new FoeDao(session);
		
		xstream.alias("foe", Foe.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/foes.json"));
		while (scanner.hasNextLine()) {
			Foe foe = (Foe) xstream.fromXML(scanner.nextLine());
			foeDao.saveOrUpdate(foe);
		}
		scanner.close();
	}
	
	@Test
	public void fitMagicWeaponStats() throws Exception {
		MagicWeaponStatsDao statsDao = new MagicWeaponStatsDao(session);
		
		xstream.alias("stats", MagicWeaponStats.class);
		xstream.alias("int", Integer.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/magicWeaponStats.json"));
		while (scanner.hasNextLine()) {
			MagicWeaponStats stats = (MagicWeaponStats) xstream.fromXML(scanner.nextLine());
			statsDao.saveOrUpdate(stats);
		}
		scanner.close();
	}

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
