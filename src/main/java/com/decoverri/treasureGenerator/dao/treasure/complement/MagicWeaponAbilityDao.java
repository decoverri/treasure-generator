package com.decoverri.treasureGenerator.dao.treasure.complement;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.enums.WeaponType;
import com.decoverri.treasureGenerator.model.treasure.complement.MagicWeaponAbility;

@Component
public class MagicWeaponAbilityDao {

	private Session session;

	@Autowired
	public MagicWeaponAbilityDao(Session session) {
		this.session = session;
	}

	public void saveOrUpdate(MagicWeaponAbility ablility) {
		session.saveOrUpdate(ablility);
	}

	public MagicWeaponAbility getMagicWeaponAbility(int bonus, WeaponType type, int roll) {
		Criteria criteria = session.createCriteria(MagicWeaponAbility.class);
		criteria.add(Restrictions.eq("type", type));
		criteria.add(Restrictions.le("interval.bottomValue", roll));
		criteria.add(Restrictions.ge("interval.topValue", roll));
		if (type == WeaponType.MELEE && bonus >= 4) {
			criteria.add(Restrictions.ge("bonus", 4));
		}else if (type == WeaponType.RANGED && bonus >= 3) {
			criteria.add(Restrictions.ge("bonus", 3));
		}else {
			criteria.add(Restrictions.eq("bonus", bonus));
		}
		
		return (MagicWeaponAbility) criteria.list().get(0);
	}

}
