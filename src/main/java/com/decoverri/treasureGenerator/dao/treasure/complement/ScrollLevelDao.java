package com.decoverri.treasureGenerator.dao.treasure.complement;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.treasure.complement.ScrollLevel;

@Component
public class ScrollLevelDao {

	private Session session;

	@Autowired
	public ScrollLevelDao(Session session) {
		this.session = session;
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
