package com.decoverri.treasureGenerator.dao.treasure;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.enums.BodySlot;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.treasure.WondrousItem;

@Component
public class WondrousItemDao {

	@Autowired
	private Session session;

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
