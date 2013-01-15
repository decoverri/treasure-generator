package com.decoverri.treasureGenerator.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.decoverri.treasureGenerator.enums.MagicItemRarity;
import com.decoverri.treasureGenerator.model.treasure.Potion;

public class PotionDao {

	private final Session session;

	public PotionDao(Session session) {
		this.session = session;
	}

	public void save(Potion potion) {
		session.save(potion);
	}

	public void saveOrUpdate(Potion potion) {
		session.saveOrUpdate(potion);
	}

	public Potion getPotion(int level, MagicItemRarity rarity, int roll) {
		Query query = session.createQuery("select p from Potion p where p.spellLevel = :level and rarity = :rarity and " +
							":roll >= bottomValue and :roll <= topValue")
							.setParameter("level", level)
							.setParameter("rarity", rarity)
							.setParameter("roll", roll);
		return (Potion) query.list().get(0);
	}

}
