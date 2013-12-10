package com.decoverri.treasureGenerator.dao.treasure.complement;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicWeaponStats;

@Component
public class MagicWeaponStatsDao {

	private Session session;

	@Autowired
	public MagicWeaponStatsDao(Session session) {
		this.session = session;
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
