package com.decoverri.treasureGenerator.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.decoverri.treasureGenerator.enums.MagicItemRarity;
import com.decoverri.treasureGenerator.model.Wand;

public class WandDao {

	private final Session session;

	public WandDao(Session session) {
		this.session = session;
	}

	public void save(Wand wand) {
		session.save(wand);
	}

	public void saveOrUpdate(Wand wand) {
		session.saveOrUpdate(wand);
	}

	public Wand getWand(int level, MagicItemRarity rarity, int roll) {
		Query query = session.createQuery("select w from Wand w where w.spellLevel = :level and rarity = :rarity and " +
							":roll >= bottomValue and :roll <= topValue")
							.setParameter("level", level)
							.setParameter("rarity", rarity)
							.setParameter("roll", roll);
		return (Wand) query.list().get(0);
	}
}
