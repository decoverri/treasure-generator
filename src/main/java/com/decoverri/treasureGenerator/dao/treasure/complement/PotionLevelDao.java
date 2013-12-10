package com.decoverri.treasureGenerator.dao.treasure.complement;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.treasure.complement.PotionLevel;

@Component
public class PotionLevelDao {

	private Session session;

	@Autowired
	public PotionLevelDao(Session session) {
		this.session = session;
	}

	public void saveOrUpdate(PotionLevel potion) {
		session.saveOrUpdate(potion);
	}

	public int getPotionLevel(MagicItemStrength strength, int roll) {
		Query query = session.createQuery("select pl.spellLevel from PotionLevel pl where pl.strength = :strength and :roll >= bottomValue and :roll <=topValue")
							.setParameter("strength", strength)
							.setParameter("roll", roll);
		return (Integer) query.list().get(0);
	}

}
