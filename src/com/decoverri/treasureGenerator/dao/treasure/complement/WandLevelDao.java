package com.decoverri.treasureGenerator.dao.treasure.complement;

import org.hibernate.Query;
import org.hibernate.Session;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.treasure.complement.WandLevel;

public class WandLevelDao {

	private final Session session;

	public WandLevelDao(Session session) {
		this.session = session;
	}

	public void save(WandLevel wand) {
		session.save(wand);
	}

	public void saveOrUpdate(WandLevel wand) {
		session.saveOrUpdate(wand);
	}

	public int getWandLevel(MagicItemStrength strength, int roll) {
		Query query = session.createQuery("select wl.spellLevel from WandLevel wl where wl.strength = :strength and :roll >= bottomValue and :roll <=topValue")
							.setParameter("strength", strength)
							.setParameter("roll", roll);
		return (Integer) query.list().get(0);
	}

}
