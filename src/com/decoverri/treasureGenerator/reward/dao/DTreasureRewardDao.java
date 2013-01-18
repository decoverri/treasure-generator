package com.decoverri.treasureGenerator.reward.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.decoverri.treasureGenerator.reward.model.DTreasureReward;

public class DTreasureRewardDao {

	private final Session session;

	public DTreasureRewardDao(Session session) {
		this.session = session;
	}

	public void save(DTreasureReward reward) {
		session.save(reward);
	}

	@SuppressWarnings("unchecked")
	public DTreasureReward findByValue(int value) {
		Criteria criteria = session.createCriteria(DTreasureReward.class);
		criteria.add(Restrictions.eq("value", value));
		List<DTreasureReward> list = criteria.list();
		if (list.isEmpty()) {
			return null;
		}
		int choice = new Random().nextInt(list.size());
		DTreasureReward reward = list.get(choice);
		return reward;
	}
}
