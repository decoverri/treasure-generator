package com.decoverri.treasureGenerator.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.decoverri.treasureGenerator.enums.MagicItemRarity;
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

	public Potion getPotion(int level, MagicItemRarity rarity, int roll) {
		Query query = session.createQuery("select p from Potion p where p.spellLevel = :level and rarity = :rarity and " +
							":roll >= bottomValue and :roll <= topValue")
							.setParameter("level", level)
							.setParameter("rarity", rarity)
							.setParameter("roll", roll);
		return (Potion) query.list().get(0);
	}

}
