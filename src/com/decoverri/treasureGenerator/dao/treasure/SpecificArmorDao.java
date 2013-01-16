package com.decoverri.treasureGenerator.dao.treasure;

import org.hibernate.Query;
import org.hibernate.Session;

import com.decoverri.treasureGenerator.enums.ArmorType;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.treasure.SpecificArmor;

public class SpecificArmorDao {

	private final Session session;

	public SpecificArmorDao(Session session) {
		this.session = session;
	}

	public void save(SpecificArmor armor) {
		session.save(armor);
	}

	public void saveOrUpdate(SpecificArmor armor) {
		session.saveOrUpdate(armor);
	}

	public SpecificArmor getSpecificArmor(ArmorType type, MagicItemStrength strength, int roll) {
		Query query = session.createQuery("select a from SpecificArmor a where a.type = :type and a.strength = :strength " +
										  "and :roll >= bottomValue and :roll <= topValue")
										  .setParameter("type", type)
										  .setParameter("strength", strength)
										  .setParameter("roll", roll);
		return (SpecificArmor) query.list().get(0);
	}

}
