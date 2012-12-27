package com.decoverri.treasureGenerator.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.PotionLevel;

public class PotionLevelDao {

	private final Session session;

	public PotionLevelDao(Session session) {
		this.session = session;
	}

	public void save(PotionLevel potion) {
		session.save(potion);
	}

	public void saveOrUpdate(PotionLevel potion) {
		session.saveOrUpdate(potion);
	}

	public int getPotionLevel(MagicItemStrength strength, int roll) {
		Query query = session.createQuery("select pl.spellLevel from PotionLevel pl where pl.strength = :strength and :roll >= bottomValue and :roll <=topValue")
							.setParameter("strength", strength)
							.setParameter("roll", roll);
		return (Integer) query.list().get(0);
	}

}
