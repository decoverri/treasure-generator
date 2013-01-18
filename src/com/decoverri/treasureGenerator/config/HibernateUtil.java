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

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.reward.model.ATreasureReward.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.reward.model.BTreasureReward.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.reward.model.CTreasureReward.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.reward.model.DTreasureReward.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.reward.model.ETreasureReward.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.reward.model.FTreasureReward.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.reward.model.GTreasureReward.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.reward.model.HTreasureReward.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.reward.model.ITreasureReward.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.data.model.CoinGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.Dice.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.data.model.GemstoneGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.model.Gemstone.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.aux.model.GemGrade.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.data.model.ArtObjectGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.model.ArtObject.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.data.model.PotionGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.aux.model.PotionLevel.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.model.Potion.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.data.model.ScrollGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.aux.model.ScrollLevel.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.model.Scroll.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.data.model.WandGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.aux.model.WandLevel.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.model.Wand.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.data.model.ArmorGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.model.Armor.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.model.SpecificArmor.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.data.model.MagicArmorGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.aux.model.MagicArmorStats.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.aux.model.MagicArmorAbility.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.model.Weapon.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.model.SpecificWeapon.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.data.model.MagicWeaponGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.aux.model.MagicWeaponAbility.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.aux.model.MagicWeaponStats.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.aux.model.WondrousItemBodySlot.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.model.WondrousItem.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.data.model.WondrousItemGeneratorData.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.model.Ring.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.data.model.RingGeneratorData.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.model.Rod.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.data.model.RodGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.aux.model.MetamagicRod.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.treasure.model.Staff.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.data.model.StaffGeneratorData.class);

		cfg.configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return configureSessionFactory();
	}

}
