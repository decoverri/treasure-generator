package com.decoverri.treasureGenerator.treasure.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.decoverri.treasureGenerator.treasure.model.ArtObject;

public class ArtObjectDao {

	private final Session session;

	public ArtObjectDao(Session session) {
		this.session = session;
	}

	public void save(ArtObject art) {
		session.save(art);
	}

	public void saveOrUpdate(ArtObject art) {
		session.saveOrUpdate(art);
	}

	@SuppressWarnings("unchecked")
	public boolean exists(String name) {
		Criteria criteria = session.createCriteria(ArtObject.class);
		criteria.add(Restrictions.eq("name", name));
		List<ArtObject> list = criteria.list();
		if (list.isEmpty()) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public ArtObject getArt(int grade, int roll) {
		Query query = session.createQuery("select ao from ArtObject ao " +
										  "where ao.grade = :grade and :roll >= ao.chanceInterval.bottomValue and :roll <= ao.chanceInterval.topValue")
				.setParameter("grade", grade).setParameter("roll", roll);
		List<ArtObject> list = query.list();
		if (list.isEmpty()) {
			return null;
		}
		ArtObject art = list.get(0);
		return art;
	}

}
