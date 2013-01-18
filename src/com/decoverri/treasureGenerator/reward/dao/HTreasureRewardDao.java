package com.decoverri.treasureGenerator.reward.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.decoverri.treasureGenerator.reward.model.HTreasureReward;

public class HTreasureRewardDao {

	private final Session session;

	public HTreasureRewardDao(Session session) {
		this.session = session;
	}

	public void save(HTreasureReward reward) {
		session.save(reward);
	}

	@SuppressWarnings("unchecked")
	public HTreasureReward findByValue(int value) {
		Criteria criteria = session.createCriteria(HTreasureReward.class);
		criteria.add(Restrictions.eq("value", value));
		List<HTreasureReward> list = criteria.list();
		if (list.isEmpty()) {
			return null;
		}
		int choice = new Random().nextInt(list.size());
		HTreasureReward reward = list.get(choice);
		return reward;
	}

}
