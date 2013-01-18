package com.decoverri.treasureGenerator.treasure.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.treasure.model.SpecificWeapon;

public class SpecificWeaponDao {

	private final Session session;

	public SpecificWeaponDao(Session session) {
		this.session = session;
	}

	public void save(SpecificWeapon weapon) {
		session.save(weapon);
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
