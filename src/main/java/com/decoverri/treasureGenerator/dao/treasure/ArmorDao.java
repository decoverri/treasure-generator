package com.decoverri.treasureGenerator.dao.treasure;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.model.treasure.Armor;

@Component
public class ArmorDao {

	@Autowired
	private Session session;

	public void saveOrUpdate(Armor armor) {
		session.saveOrUpdate(armor);
	}

	public Armor getArmor(int roll) {
		Query query = session.createQuery("select a from Armor a where :roll >= bottomValue and :roll <= topValue").setParameter("roll", roll);
		return (Armor) query.list().get(0);
	}

}
