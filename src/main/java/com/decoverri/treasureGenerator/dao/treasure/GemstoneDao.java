package com.decoverri.treasureGenerator.dao.treasure;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.model.treasure.Gemstone;

@Component
public class GemstoneDao {

	private Session session;

	@Autowired
	public GemstoneDao(Session session) {
		this.session = session;
	}

	public void saveOrUpdate(Gemstone gem) {
		session.saveOrUpdate(gem);
	}

	@SuppressWarnings("unchecked")
	public Gemstone getGem(int grade, int roll) {
		Query query = session.createQuery("select gs from Gemstone gs join gs.grade gg " +
										  "where gg.grade = :grade and :roll >= gs.chanceInterval.bottomValue and :roll <= gs.chanceInterval.topValue")
										  .setParameter("grade", grade)
										  .setParameter("roll", roll);
		List<Gemstone> list = query.list();
		if (list.isEmpty()) {
			return null;
		}
		Gemstone gem = list.get(0);
		return gem;
	}

	@SuppressWarnings("unchecked")
	public boolean exists(String name) {
		Criteria criteria = session.createCriteria(Gemstone.class);
		criteria.add(Restrictions.eq("name", name));
		List<Gemstone> list = criteria.list();
		if (list.isEmpty()) {
			return false;
		}
		return true;
	}

}
