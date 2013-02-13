package com.decoverri.treasureGenerator.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.decoverri.treasureGenerator.model.TreasureReward;

public class TreasureRewardDao {

	private final Session session;

	public TreasureRewardDao(Session session) {
		this.session = session;
	}

	public void save(TreasureReward reward) {
		session.save(reward);
	}

	@SuppressWarnings("unchecked")
	public TreasureReward findByValue(char type, int value) {
		Criteria criteria = session.createCriteria(TreasureReward.class);
		criteria.add(Restrictions.eq("value", value));
		criteria.add(Restrictions.eq("type", type));
		List<TreasureReward> list = criteria.list();
		if (list.isEmpty()) {
			return null;
		}
		int choice = new Random().nextInt(list.size());
		TreasureReward reward = list.get(choice);
		return reward;
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getValuesOfType(char type) {
		return session.createQuery("select distinct r.value from TreasureReward r where r.type = :type").setParameter("type", type).list();
	}

	@SuppressWarnings("unchecked")
	public List<Character> getTypes() {
		return session.createQuery("select distinct r.type from TreasureReward r").list();
	}
}
