package com.decoverri.treasureGenerator.dao.treasure.complement;

import org.hibernate.Query;
import org.hibernate.Session;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicWeaponStats;

public class MagicWeaponStatsDao {

	private final Session session;

	public MagicWeaponStatsDao(Session session) {
		this.session = session;
	}

	public void save(MagicWeaponStats stats) {
		session.save(stats);
	}

	public void saveOrUpdate(MagicWeaponStats stats) {
		session.saveOrUpdate(stats);
	}

	public MagicWeaponStats getMagicWeaponStats(MagicItemStrength strength, int roll) {
		Query query = session.createQuery("select s from MagicWeaponStats s where s.strength = :strength and :roll >= bottomValue and :roll <=topValue")
							.setParameter("strength", strength)
							.setParameter("roll", roll);
		return (MagicWeaponStats) query.list().get(0);
	}

}
