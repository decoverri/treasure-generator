package com.decoverri.treasureGenerator.dao.treasure.complement;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.treasure.complement.WandLevel;

@Component
public class WandLevelDao {

	@Autowired
	private Session session;

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
