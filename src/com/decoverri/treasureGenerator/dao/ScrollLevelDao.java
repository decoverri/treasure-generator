package com.decoverri.treasureGenerator.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.ScrollLevel;

public class ScrollLevelDao {

	private final Session session;

	public ScrollLevelDao(Session session) {
		this.session = session;
	}

	public void save(ScrollLevel scroll) {
		session.save(scroll);
	}

	public void saveOrUpdate(ScrollLevel scroll) {
		session.saveOrUpdate(scroll);
	}

	public int getScrollLevel(MagicItemStrength strength, int roll) {
		Query query = session.createQuery("select sl.spellLevel from ScrollLevel sl where sl.strength = :strength and :roll >= bottomValue and :roll <=topValue")
							.setParameter("strength", strength)
							.setParameter("roll", roll);
		return (Integer) query.list().get(0);
	}


}
