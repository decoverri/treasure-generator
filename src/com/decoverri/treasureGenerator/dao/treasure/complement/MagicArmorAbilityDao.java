package com.decoverri.treasureGenerator.dao.treasure.complement;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.enums.ArmorType;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicArmorAbility;

@Component
public class MagicArmorAbilityDao {

	@Autowired
	private Session session;

	public void saveOrUpdate(MagicArmorAbility ablility) {
		session.saveOrUpdate(ablility);
	}

	public MagicArmorAbility getMagicArmorAbility(int bonus, ArmorType type, int roll) {
		Query query = session.createQuery("select a from MagicArmorAbility a where a.bonus = :bonus and a.type = :type " +
										  "and :roll >= bottomValue and :roll <= topValue")
										  .setParameter("bonus", bonus)
										  .setParameter("type", type)
										  .setParameter("roll", roll);
		return (MagicArmorAbility) query.list().get(0);
	}

}
