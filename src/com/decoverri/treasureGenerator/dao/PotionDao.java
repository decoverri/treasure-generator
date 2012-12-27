package com.decoverri.treasureGenerator.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.decoverri.treasureGenerator.model.Potion;

public class PotionDao {

	private final Session session;

	public PotionDao(Session session) {
		this.session = session;
	}

	public void save(Potion potion) {
		session.save(potion);
	}

	public void saveOrUpdate(Potion potion) {
		session.saveOrUpdate(potion);
	}

	@SuppressWarnings("unchecked")
	public boolean exists(String spell) {
		Criteria criteria = session.createCriteria(Potion.class);
		criteria.add(Restrictions.eq("spell", spell));
		List<Potion> list = criteria.list();
		if (list.isEmpty()) {
			return false;
		}
		return true;
	}

}
