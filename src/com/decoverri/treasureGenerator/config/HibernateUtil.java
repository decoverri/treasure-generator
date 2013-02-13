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

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.TreasureReward.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.data.CoinGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.Dice.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.data.GemstoneGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Gemstone.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.GemGrade.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.data.ArtObjectGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.ArtObject.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.data.PotionGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.PotionLevel.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Potion.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.data.ScrollGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.ScrollLevel.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Scroll.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.data.WandGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.WandLevel.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Wand.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.data.ArmorGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Armor.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.SpecificArmor.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.data.MagicArmorGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.MagicArmorStats.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.MagicArmorAbility.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Weapon.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.SpecificWeapon.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.data.MagicWeaponGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.MagicWeaponAbility.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.Foe.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.MagicWeaponStats.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.WondrousItemBodySlot.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.WondrousItem.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.data.WondrousItemGeneratorData.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Ring.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.data.RingGeneratorData.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Rod.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.data.RodGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.MetamagicRod.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Staff.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.data.StaffGeneratorData.class);

		cfg.configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return configureSessionFactory();
	}

}
