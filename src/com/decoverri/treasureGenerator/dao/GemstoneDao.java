package com.decoverri.treasureGenerator.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.decoverri.treasureGenerator.model.ATreasureReward;
import com.decoverri.treasureGenerator.model.Gemstone;

public class GemstoneDao {

	private final Session session;

	public GemstoneDao(Session session) {
		this.session = session;
	}

	public void save(Gemstone gem) {
		session.save(gem);
	}

	public void saveOrUpdate(Gemstone gem) {
		session.saveOrUpdate(gem);
	}

	@SuppressWarnings("unchecked")
	public Gemstone getGem(int grade, int roll) {
		Criteria criteria = session.createCriteria(Gemstone.class);
		criteria.add(Restrictions.eq("grade", grade));
		criteria.add(Restrictions.ge("minValue", roll));
		criteria.add(Restrictions.le("maxValue", roll));
		List<Gemstone> list = criteria.list();
		if (list.isEmpty()) {
			return null;
		}
		Gemstone gem = list.get(0);
		return gem;
	}

	@SuppressWarnings("unchecked")
	public boolean exists(String name) {
		Criteria criteria = session.createCriteria(Gemstone.class);
		criteria.add(Restrictions.eq("name", name));
		List<ATreasureReward> list = criteria.list();
		if (list.isEmpty()) {
			return false;
		}
		return true;
	}

}
