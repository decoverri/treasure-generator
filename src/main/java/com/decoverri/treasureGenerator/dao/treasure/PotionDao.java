package com.decoverri.treasureGenerator.dao.treasure;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.enums.MagicItemRarity;
import com.decoverri.treasureGenerator.model.treasure.Potion;

@Component
public class PotionDao {

	private Session session;

	@Autowired
	public PotionDao(Session session) {
		this.session = session;
	}

	public void saveOrUpdate(Potion potion) {
		session.saveOrUpdate(potion);
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
