package com.decoverri.treasureGenerator.dao.treasure;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.enums.MagicItemRarity;
import com.decoverri.treasureGenerator.model.treasure.Wand;

@Component
public class WandDao {

	private Session session;

	@Autowired
	public WandDao(Session session) {
		this.session = session;
	}

	public void saveOrUpdate(Wand wand) {
		session.saveOrUpdate(wand);
	}

	public Wand getWand(int level, MagicItemRarity rarity, int roll) {
		Query query = session.createQuery("select w from Wand w where w.spellLevel = :level and rarity = :rarity and " +
							":roll >= bottomValue and :roll <= topValue")
							.setParameter("level", level)
							.setParameter("rarity", rarity)
							.setParameter("roll", roll);
		return (Wand) query.list().get(0);
	}
}
