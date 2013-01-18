package com.decoverri.treasureGenerator.treasure.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.decoverri.treasureGenerator.treasure.model.Armor;

public class ArmorDao {

	private final Session session;

	public ArmorDao(Session session) {
		this.session = session;
	}

	public void save(Armor armor) {
		session.save(armor);
	}

	public void saveOrUpdate(Armor armor) {
		session.saveOrUpdate(armor);
	}

	public Armor getArmor(int roll) {
		Query query = session.createQuery("select a from Armor a where :roll >= bottomValue and :roll <= topValue").setParameter("roll", roll);
		return (Armor) query.list().get(0);
	}

}