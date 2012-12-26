package com.decoverri.treasureGenerator.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.decoverri.treasureGenerator.model.BTreasureReward;

public class BTreasureRewardDao {

	private final Session session;

	public BTreasureRewardDao(Session session) {
		this.session = session;
	}

	public void save(BTreasureReward reward) {
		session.save(reward);
	}

	@SuppressWarnings("unchecked")
	public BTreasureReward findByValue(int value) {
		BTreasureReward reward = new BTreasureReward();
		Criteria criteria = session.createCriteria(BTreasureReward.class);
		criteria.add(Restrictions.eq("value", value));
		List<BTreasureReward> list = criteria.list();
		if (list.isEmpty()) {
			return null;
		}
		int choice = new Random().nextInt(list.size());
		reward = list.get(choice);
		return reward;
	}

}
