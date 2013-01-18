package com.decoverri.treasureGenerator.treasure.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.treasure.model.Rod;

public class RodDao {

	private final Session session;

	public RodDao(Session session) {
		this.session = session;
	}

	public void save(Rod rod) {
		session.save(rod);
	}

	public void saveOrUpdate(Rod rod) {
		session.saveOrUpdate(rod);
	}

	public Rod getRod(MagicItemStrength strength, int roll) {
		Query query = session.createQuery("select r from Rod r where strength = :strength and " +
										  ":roll >= bottomValue and :roll <= topValue")
										  .setParameter("strength", strength)
										  .setParameter("roll", roll);
		return (Rod) query.list().get(0);
	}

}
