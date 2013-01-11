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

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.ATreasureReward.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.BTreasureReward.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.CTreasureReward.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.DTreasureReward.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.ETreasureReward.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.CoinGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.Dice.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.GemstoneGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.Gemstone.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.GemGrade.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.ArtObjectGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.ArtObject.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.PotionGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.PotionLevel.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.Potion.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.ScrollGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.ScrollLevel.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.Scroll.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.WandGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.WandLevel.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.Wand.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.ArmorGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.Armor.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.SpecificArmor.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.MagicArmorGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.MagicArmorStats.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.MagicArmorAbility.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.Weapon.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.SpecificWeapon.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.MagicWeaponGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.MagicWeaponAbility.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.MagicWeaponStats.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.WondrousItemBodySlot.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.WondrousItem.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.WondrousItemGeneratorData.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.Ring.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.RingGeneratorData.class);

		cfg.configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return configureSessionFactory();
	}

}
