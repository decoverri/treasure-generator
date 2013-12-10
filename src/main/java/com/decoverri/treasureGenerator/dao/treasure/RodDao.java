package com.decoverri.treasureGenerator.dao.treasure;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.treasure.Rod;

@Component
public class RodDao {

	private Session session;

	@Autowired
	public RodDao(Session session) {
		this.session = session;
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
