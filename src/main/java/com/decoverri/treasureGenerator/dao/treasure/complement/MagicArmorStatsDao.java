package com.decoverri.treasureGenerator.dao.treasure.complement;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicArmorStats;

@Component
public class MagicArmorStatsDao {

	private Session session;

	@Autowired
	public MagicArmorStatsDao(Session session) {
		this.session = session;
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
