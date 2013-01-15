package com.decoverri.treasureGenerator.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.treasure.Weapon;

public class WeaponDao {

	private final Session session;

	public WeaponDao(Session session) {
		this.session = session;
	}

	public void save(Weapon weapon) {
		session.save(weapon);
	}

	public void saveOrUpdate(Weapon weapon) {
		session.saveOrUpdate(weapon);
	}

	public Weapon getWeapon(int roll) {
		Query query = session.createQuery("select w from Weapon w where :roll >= bottomValue and :roll <= topValue").setParameter("roll", roll);
		return (Weapon) query.list().get(0);
	}

}
