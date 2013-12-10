package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.dao.GeneratorDataDao;
import com.decoverri.treasureGenerator.dao.TreasureRewardDao;
import com.decoverri.treasureGenerator.dao.TreasureTypeDao;
import com.decoverri.treasureGenerator.dao.TreasureTypeValueDao;
import com.decoverri.treasureGenerator.dao.treasure.ArmorDao;
import com.decoverri.treasureGenerator.dao.treasure.ArtObjectDao;
import com.decoverri.treasureGenerator.dao.treasure.GemstoneDao;
import com.decoverri.treasureGenerator.dao.treasure.PotionDao;
import com.decoverri.treasureGenerator.dao.treasure.RingDao;
import com.decoverri.treasureGenerator.dao.treasure.RodDao;
import com.decoverri.treasureGenerator.dao.treasure.ScrollDao;
import com.decoverri.treasureGenerator.dao.treasure.SpecificArmorDao;
import com.decoverri.treasureGenerator.dao.treasure.SpecificWeaponDao;
import com.decoverri.treasureGenerator.dao.treasure.StaffDao;
import com.decoverri.treasureGenerator.dao.treasure.WandDao;
import com.decoverri.treasureGenerator.dao.treasure.WeaponDao;
import com.decoverri.treasureGenerator.dao.treasure.WondrousItemDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.FoeDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.GemGradeDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.MagicArmorAbilityDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.MagicArmorStatsDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.MagicWeaponAbilityDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.MagicWeaponStatsDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.MetamagicRodDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.PotionLevelDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.ScrollLevelDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.WandLevelDao;
import com.decoverri.treasureGenerator.dao.treasure.complement.WondrousItemBodySlotDao;
import com.decoverri.treasureGenerator.model.TreasureReward;
import com.decoverri.treasureGenerator.model.TreasureType;
import com.decoverri.treasureGenerator.model.TreasureTypeValue;
import com.decoverri.treasureGenerator.model.treasure.Armor;
import com.decoverri.treasureGenerator.model.treasure.ArtObject;
import com.decoverri.treasureGenerator.model.treasure.Gemstone;
import com.decoverri.treasureGenerator.model.treasure.Potion;
import com.decoverri.treasureGenerator.model.treasure.Ring;
import com.decoverri.treasureGenerator.model.treasure.Rod;
import com.decoverri.treasureGenerator.model.treasure.Scroll;
import com.decoverri.treasureGenerator.model.treasure.SpecificArmor;
import com.decoverri.treasureGenerator.model.treasure.SpecificWeapon;
import com.decoverri.treasureGenerator.model.treasure.Staff;
import com.decoverri.treasureGenerator.model.treasure.Wand;
import com.decoverri.treasureGenerator.model.treasure.Weapon;
import com.decoverri.treasureGenerator.model.treasure.WondrousItem;
import com.decoverri.treasureGenerator.model.treasure.complement.Foe;
import com.decoverri.treasureGenerator.model.treasure.complement.GemGrade;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicArmorAbility;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicArmorStats;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicWeaponAbility;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicWeaponStats;
import com.decoverri.treasureGenerator.model.treasure.complement.MetamagicRod;
import com.decoverri.treasureGenerator.model.treasure.complement.PotionLevel;
import com.decoverri.treasureGenerator.model.treasure.complement.ScrollLevel;
import com.decoverri.treasureGenerator.model.treasure.complement.WandLevel;
import com.decoverri.treasureGenerator.model.treasure.complement.WondrousItemBodySlot;
import com.decoverri.treasureGenerator.model.treasure.data.ArmorGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.data.ArtObjectGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.data.CoinGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.data.GemstoneGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.data.MagicArmorGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.data.MagicWeaponGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.data.PotionGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.data.RingGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.data.RodGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.data.ScrollGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.data.StaffGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.data.WandGeneratorData;
import com.decoverri.treasureGenerator.model.treasure.data.WondrousItemGeneratorData;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitData {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	private static Transaction transaction;
	
	private XStream xstream = new XStream(new JettisonMappedXmlDriver());

	@BeforeClass
	public static void before() {
		transaction = session.beginTransaction();
	}

	@AfterClass
	public static void after() {
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
	
	@Test
	public void fitWondrousItems() throws Exception {
		WondrousItemDao itemDao = new WondrousItemDao(session);
		
		xstream.alias("item", WondrousItem.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/wondrousItems.json"));
		while (scanner.hasNextLine()) {
			WondrousItem item = (WondrousItem) xstream.fromXML(scanner.nextLine());
			itemDao.saveOrUpdate(item);
		}
		scanner.close();
	}
	
	@Test
	public void fitWondrousItemBodySlots() throws Exception {
		WondrousItemBodySlotDao slotDao = new WondrousItemBodySlotDao(session);
		
		xstream.alias("wondrousitemslot", WondrousItemBodySlot.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/wondrousItemBodySlots.json"));
		while (scanner.hasNextLine()) {
			WondrousItemBodySlot wondrousItemSlot = (WondrousItemBodySlot) xstream.fromXML(scanner.nextLine());
			slotDao.saveOrUpdate(wondrousItemSlot);
		}
		scanner.close();
	}
	
	@Test
	public void fitRings() throws Exception {
		RingDao ringDao = new RingDao(session);
		
		xstream.alias("ring", Ring.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/rings.json"));
		while (scanner.hasNextLine()) {
			Ring ring = (Ring) xstream.fromXML(scanner.nextLine());
			ringDao.saveOrUpdate(ring);
		}
		scanner.close();
	}
	
	@Test
	public void fitRods() throws Exception {
		RodDao rodDao = new RodDao(session);
		
		xstream.alias("rod", Rod.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/rods.json"));
		while (scanner.hasNextLine()) {
			Rod rod = (Rod) xstream.fromXML(scanner.nextLine());
			rodDao.saveOrUpdate(rod);
		}
		scanner.close();
	}
	
	@Test
	public void fitMetamagicRods() throws Exception {
		MetamagicRodDao metamagicDao = new MetamagicRodDao(session);
		
		xstream.alias("metamagic", MetamagicRod.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/metamagicRods.json"));
		while (scanner.hasNextLine()) {
			MetamagicRod metamagic = (MetamagicRod) xstream.fromXML(scanner.nextLine());
			metamagicDao.saveOrUpdate(metamagic);
		}
		scanner.close();
	}
	
	@Test
	public void fitStaves() throws Exception {
		StaffDao staffDao = new StaffDao(session);
		
		xstream.alias("staff", Staff.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/staves.json"));
		while (scanner.hasNextLine()) {
			Staff staff = (Staff) xstream.fromXML(scanner.nextLine());
			staffDao.saveOrUpdate(staff);
		}
		scanner.close();
	}
	
	@Test
	public void fitTreasures() throws Exception {
		TreasureRewardDao rewardDao = new TreasureRewardDao(session);
		GeneratorDataDao genDao = new GeneratorDataDao(session);
		
		
		xstream.alias("reward", TreasureReward.class);
		xstream.alias("coingenerator", CoinGeneratorData.class);
		xstream.alias("mundanearmorgen", ArmorGeneratorData.class);
		xstream.alias("armorgenerator", MagicArmorGeneratorData.class);
		xstream.alias("weapongenerator", MagicWeaponGeneratorData.class);
		xstream.alias("ringgenerator", RingGeneratorData.class);
		xstream.alias("staffgenerator", StaffGeneratorData.class);
		xstream.alias("rodgenerator", RodGeneratorData.class);
		xstream.alias("wondrousgenerator", WondrousItemGeneratorData.class);
		xstream.alias("potiongenerator", PotionGeneratorData.class);
		xstream.alias("scrollgenerator", ScrollGeneratorData.class);
		xstream.alias("wandgenerator", WandGeneratorData.class);
		xstream.alias("gemgenerator", GemstoneGeneratorData.class);
		xstream.alias("artgenerator", ArtObjectGeneratorData.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/treasureReward.json"));
		while (scanner.hasNextLine()) {
			TreasureReward reward = (TreasureReward) xstream.fromXML(scanner.nextLine());

			for (CoinGeneratorData coinGen : reward.getCoins()) {
				genDao.save(coinGen);
			}
			for (ArmorGeneratorData armorGen : reward.getNonmagicalArmors()) {
				genDao.save(armorGen);
			}
			for (MagicArmorGeneratorData magicArmorGen : reward.getArmors()) {
				genDao.save(magicArmorGen);
			}
			for (MagicWeaponGeneratorData magicWeaponGen : reward.getWeapons()) {
				genDao.save(magicWeaponGen);
			}
			for (RingGeneratorData ringGen : reward.getRings()) {
				genDao.save(ringGen);
			}
			for (StaffGeneratorData staffGen : reward.getStaves()) {
				genDao.save(staffGen);
			}
			for (RodGeneratorData rodGen : reward.getRods()) {
				genDao.save(rodGen);
			}
			for (WondrousItemGeneratorData wondrousGen : reward.getWondrousItems()) {
				genDao.save(wondrousGen);
			}
			for (PotionGeneratorData potionGen : reward.getPotions()) {
				genDao.save(potionGen);
			}
			for (ScrollGeneratorData scrollGen : reward.getScrolls()) {
				genDao.save(scrollGen);
			}
			for (WandGeneratorData wandGen : reward.getWands()) {
				genDao.save(wandGen);
			}
			for (GemstoneGeneratorData gemGen : reward.getGems()) {
				genDao.save(gemGen);
			}
			for (ArtObjectGeneratorData artGen : reward.getArts()) {
				genDao.save(artGen);
			}
			rewardDao.save(reward);

		}
		scanner.close();
	}

}
