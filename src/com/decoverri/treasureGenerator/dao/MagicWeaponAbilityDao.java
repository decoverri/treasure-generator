package com.decoverri.treasureGenerator.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.decoverri.treasureGenerator.enums.WeaponType;
import com.decoverri.treasureGenerator.model.MagicWeaponAbility;

public class MagicWeaponAbilityDao {

	private final Session session;

	public MagicWeaponAbilityDao(Session session) {
		this.session = session;
	}

	public void save(MagicWeaponAbility ability) {
		session.save(ability);
	}

	public void saveOrUpdate(MagicWeaponAbility ablility) {
		session.saveOrUpdate(ablility);
	}

	public MagicWeaponAbility getMagicWeaponAbility(int bonus, WeaponType type, int roll) {
		Query query = session.createQuery("select w from MagicWeaponAbility w where w.bonus = :bonus and w.type = :type " +
										  "and :roll >= bottomValue and :roll <= topValue")
										  .setParameter("bonus", bonus)
										  .setParameter("type", type)
										  .setParameter("roll", roll);
		return (MagicWeaponAbility) query.list().get(0);
	}

}
