package com.decoverri.treasureGenerator.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.MagicArmorStats;

public class MagicArmorStatsDao {

	private final Session session;

	public MagicArmorStatsDao(Session session) {
		this.session = session;
	}

	public void save(MagicArmorStats stats) {
		session.save(stats);
	}

	public void saveOrUpdate(MagicArmorStats stats) {
		session.saveOrUpdate(stats);
	}

	public MagicArmorStats getMagicArmorStats(MagicItemStrength strength, int roll) {
		Query query = session.createQuery("select s from MagicArmorStats s where s.strength = :strength and :roll >= bottomValue and :roll <=topValue")
							.setParameter("strength", strength)
							.setParameter("roll", roll);
		return (MagicArmorStats) query.list().get(0);
	}

}
