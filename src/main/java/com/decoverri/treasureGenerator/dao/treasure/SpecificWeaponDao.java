package com.decoverri.treasureGenerator.dao.treasure;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.treasure.SpecificWeapon;

@Component
public class SpecificWeaponDao {

	private Session session;

	@Autowired
	public SpecificWeaponDao(Session session) {
		this.session = session;
	}

	public void saveOrUpdate(SpecificWeapon weapon) {
		session.saveOrUpdate(weapon);
	}

	public SpecificWeapon getSpecificWeapon(MagicItemStrength strength, int roll) {
		Query query = session.createQuery("select w from SpecificWeapon w where w.strength = :strength " +
										  "and :roll >= bottomValue and :roll <= topValue")
										  .setParameter("strength", strength)
										  .setParameter("roll", roll);
		return (SpecificWeapon) query.list().get(0);
	}

}
