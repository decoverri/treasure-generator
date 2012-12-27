package com.decoverri.treasureGenerator.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.decoverri.treasureGenerator.model.ArtObject;

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

}
