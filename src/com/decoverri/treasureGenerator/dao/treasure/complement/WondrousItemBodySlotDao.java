package com.decoverri.treasureGenerator.dao.treasure.complement;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.enums.BodySlot;
import com.decoverri.treasureGenerator.model.treasure.complement.WondrousItemBodySlot;

@Component
public class WondrousItemBodySlotDao {

	@Autowired
	private Session session;

	public void saveOrUpdate(WondrousItemBodySlot slot) {
		session.saveOrUpdate(slot);
	}

	public BodySlot getWondrousItemBodySlot(int roll) {
		Query query = session.createQuery("select slot from WondrousItemBodySlot where :roll >= bottomValue and :roll <= topValue")
							.setParameter("roll", roll);
		return (BodySlot) query.list().get(0);
	}

}
