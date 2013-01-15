package com.decoverri.treasureGenerator.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.decoverri.treasureGenerator.model.ITreasureReward;

public class ITreasureRewardDao {

	private final Session session;

	public ITreasureRewardDao(Session session) {
		this.session = session;
	}

	public void save(ITreasureReward reward) {
		session.save(reward);
	}

	@SuppressWarnings("unchecked")
	public ITreasureReward findByValue(int value) {
		Criteria criteria = session.createCriteria(ITreasureReward.class);
		criteria.add(Restrictions.eq("value", value));
		List<ITreasureReward> list = criteria.list();
		if (list.isEmpty()) {
			return null;
		}
		int choice = new Random().nextInt(list.size());
		ITreasureReward reward = list.get(choice);
		return reward;
	}

}
