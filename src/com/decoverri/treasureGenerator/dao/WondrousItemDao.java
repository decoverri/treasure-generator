package com.decoverri.treasureGenerator.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.decoverri.treasureGenerator.enums.BodySlot;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.WondrousItem;

public class WondrousItemDao {

	private final Session session;

	public WondrousItemDao(Session session) {
		this.session = session;
	}

	public void save(WondrousItem item) {
		session.save(item);
	}

	public void saveOrUpdate(WondrousItem item) {
		session.saveOrUpdate(item);
	}

	public WondrousItem getWondrousItem(MagicItemStrength strength, BodySlot slot, int roll) {
		Query query = session.createQuery("select i from WondrousItem i where i.strength = :strength and slot = :slot and " +
							":roll >= bottomValue and :roll <= topValue")
							.setParameter("strength", strength)
							.setParameter("slot", slot)
							.setParameter("roll", roll);
		return (WondrousItem) query.list().get(0);
	}

}
