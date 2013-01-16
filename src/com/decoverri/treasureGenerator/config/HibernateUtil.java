package com.decoverri.treasureGenerator.config;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory configureSessionFactory() throws HibernateException {
		Configuration cfg = new Configuration();

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.reward.ATreasureReward.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.reward.BTreasureReward.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.reward.CTreasureReward.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.reward.DTreasureReward.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.reward.ETreasureReward.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.reward.FTreasureReward.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.reward.GTreasureReward.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.reward.HTreasureReward.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.reward.ITreasureReward.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.generator.CoinGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.Dice.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.generator.GemstoneGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Gemstone.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.GemGrade.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.generator.ArtObjectGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.ArtObject.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.generator.PotionGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.PotionLevel.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Potion.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.generator.ScrollGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.ScrollLevel.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Scroll.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.generator.WandGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.WandLevel.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Wand.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.generator.ArmorGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Armor.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.SpecificArmor.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.generator.MagicArmorGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.MagicArmorStats.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.MagicArmorAbility.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Weapon.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.SpecificWeapon.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.generator.MagicWeaponGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.MagicWeaponAbility.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.MagicWeaponStats.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.WondrousItemBodySlot.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.WondrousItem.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.generator.WondrousItemGeneratorData.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Ring.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.generator.RingGeneratorData.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Rod.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.generator.RodGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.MetamagicRod.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Staff.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.generator.StaffGeneratorData.class);

		cfg.configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return configureSessionFactory();
	}

}
