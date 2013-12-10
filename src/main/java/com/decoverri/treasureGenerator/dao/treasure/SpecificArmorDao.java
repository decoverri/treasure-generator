package com.decoverri.treasureGenerator.dao.treasure;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.enums.ArmorType;
import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.treasure.SpecificArmor;

@Component
public class SpecificArmorDao {

	private Session session;

	@Autowired
	public SpecificArmorDao(Session session) {
		this.session = session;
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
