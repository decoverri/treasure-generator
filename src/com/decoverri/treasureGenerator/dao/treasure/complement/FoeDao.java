package com.decoverri.treasureGenerator.dao.treasure.complement;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.decoverri.treasureGenerator.model.treasure.complement.Foe;

public class FoeDao {

	private final Session session;

	public FoeDao(Session session) {
		this.session = session;
	}

	public void save(Foe foe) {
		session.save(foe);
	}

	public void saveOrUpdate(Foe foe) {
		session.saveOrUpdate(foe);
	}

	public Foe getFoe(int roll) {
		Criteria criteria = session.createCriteria(Foe.class);
		criteria.add(Restrictions.le("interval.bottomValue", roll));
		criteria.add(Restrictions.ge("interval.topValue", roll));
		return (Foe) criteria.list().get(0);
	}

}
