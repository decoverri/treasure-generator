package com.decoverri.treasureGenerator.dao.treasure;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.model.treasure.Weapon;

@Component
public class WeaponDao {

	private Session session;

	@Autowired
	public WeaponDao(Session session) {
		this.session = session;
	}

	public void saveOrUpdate(Weapon weapon) {
		session.saveOrUpdate(weapon);
	}

	public Weapon getWeapon(int roll) {
		Query query = session.createQuery("select w from Weapon w where :roll >= bottomValue and :roll <= topValue").setParameter("roll", roll);
		return (Weapon) query.list().get(0);
	}

}
