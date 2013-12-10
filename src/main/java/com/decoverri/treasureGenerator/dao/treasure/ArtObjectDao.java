package com.decoverri.treasureGenerator.dao.treasure;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.model.treasure.ArtObject;

@Component
public class ArtObjectDao {

	private Session session;

	@Autowired
	public ArtObjectDao(Session session) {
		this.session = session;
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
				"where ao.grade = :grade and :roll >= ao.chanceInterval.bottomValue " +
				"and :roll <= ao.chanceInterval.topValue")
				.setParameter("grade", grade).setParameter("roll", roll);
		List<ArtObject> list = query.list();
		if (list.isEmpty()) {
			return null;
		}
		ArtObject art = list.get(0);
		return art;
	}

}
