package com.decoverri.treasureGenerator.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.decoverri.treasureGenerator.enums.BodySlot;
import com.decoverri.treasureGenerator.model.WondrousItemBodySlot;

public class WondrousItemBodySlotDao {

	private final Session session;

	public WondrousItemBodySlotDao(Session session) {
		this.session = session;
	}

	public void save(WondrousItemBodySlot slot) {
		session.save(slot);
	}

	public void saveOrUpdate(WondrousItemBodySlot slot) {
		session.saveOrUpdate(slot);
	}

	public BodySlot getWondrousItemBodySlot(int roll) {
		Query query = session.createQuery("select slot from WondrousItemBodySlot where :roll >= bottomValue and :roll <= topValue")
							.setParameter("roll", roll);
		return (BodySlot) query.list().get(0);
	}

}
