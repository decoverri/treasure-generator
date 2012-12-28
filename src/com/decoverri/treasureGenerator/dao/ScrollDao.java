package com.decoverri.treasureGenerator.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.decoverri.treasureGenerator.enums.HallowAdditionalSpell;
import com.decoverri.treasureGenerator.enums.MagicItemRarity;
import com.decoverri.treasureGenerator.enums.MagicType;
import com.decoverri.treasureGenerator.model.Scroll;

public class ScrollDao {

	private final Session session;

	public ScrollDao(Session session) {
		this.session = session;
	}

	public void save(Scroll scroll) {
		session.save(scroll);
	}

	public void saveOrUpdate(Scroll scroll) {
		session.saveOrUpdate(scroll);
	}

	@SuppressWarnings("unchecked")
	public boolean exists(Scroll scroll) {
		Criteria criteria = session.createCriteria(Scroll.class);
		criteria.add(Restrictions.eq("spell", scroll.getSpell()));
		criteria.add(Restrictions.eq("type", scroll.getType()));
		List<Scroll> list = criteria.list();
		if (list.isEmpty()) {
			return false;
		}
		return true;
	}

	public Scroll getScroll(int level, MagicItemRarity rarity, MagicType type, int roll) {
		Query query = session.createQuery("select s from Scroll s where s.spellLevel = :level and s.rarity = :rarity and " +
							"s.type = :type and :roll >= bottomValue and :roll <= topValue")
							.setParameter("level", level)
							.setParameter("rarity", rarity)
							.setParameter("type", type)
							.setParameter("roll", roll);
		Scroll scroll = (Scroll) query.list().get(0);
		if (roll > 98) {
			int i = new Random().nextInt(HallowAdditionalSpell.values().length);
			scroll.setSpell(scroll.getSpell() + " " + HallowAdditionalSpell.values()[i]);
		}
		return scroll;
	}

}
