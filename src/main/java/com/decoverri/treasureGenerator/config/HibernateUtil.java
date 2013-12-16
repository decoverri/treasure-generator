package com.decoverri.treasureGenerator.config;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("application")
public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory configureSessionFactory() throws HibernateException {

		Configuration cfg = new Configuration();

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.TreasureTypeValue.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.TreasureType.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.TreasureReward.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.data.CoinGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.Dice.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.data.GemstoneGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Gemstone.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.GemGrade.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.data.ArtObjectGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.ArtObject.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.data.PotionGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.PotionLevel.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Potion.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.data.ScrollGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.ScrollLevel.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Scroll.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.data.WandGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.WandLevel.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Wand.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.data.ArmorGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Armor.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.SpecificArmor.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.data.MagicArmorGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.MagicArmorStats.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.MagicArmorAbility.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Weapon.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.SpecificWeapon.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.data.MagicWeaponGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.MagicWeaponAbility.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.Foe.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.MagicWeaponStats.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.WondrousItemBodySlot.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.WondrousItem.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.data.WondrousItemGeneratorData.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Ring.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.data.RingGeneratorData.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Rod.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.data.RodGeneratorData.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.complement.MetamagicRod.class);

		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.Staff.class);
		cfg.addAnnotatedClass(com.decoverri.treasureGenerator.model.treasure.data.StaffGeneratorData.class);
		
		Properties dbProperties = new Properties();
		if (System.getenv("DATABASE_URL")==null) {
			dbProperties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
			dbProperties.put("hibernate.connection.url", "jdbc:mysql://localhost/treasure_generator");
			dbProperties.put("hibernate.connection.username", "root");
			dbProperties.put("hibernate.connection.password", "");
			dbProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		} else {
			//TODO Joga aqui as do heroku
		}
		cfg.addProperties(dbProperties);

		cfg.configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	@Bean(destroyMethod="close")
	public static SessionFactory getSessionFactory() {
		return configureSessionFactory();
	}
	
}
