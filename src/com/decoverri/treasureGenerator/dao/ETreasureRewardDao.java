package com.decoverri.treasureGenerator.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.decoverri.treasureGenerator.model.reward.ETreasureReward;

public class ETreasureRewardDao {

	private final Session session;

	public ETreasureRewardDao(Session session) {
		this.session = session;
	}

	public void save(ETreasureReward reward) {
		session.save(reward);
	}

	@SuppressWarnings("unchecked")
	public ETreasureReward findByValue(int value) {
		Criteria criteria = session.createCriteria(ETreasureReward.class);
		criteria.add(Restrictions.eq("value", value));
		List<ETreasureReward> list = criteria.list();
		if (list.isEmpty()) {
			return null;
		}
		int choice = new Random().nextInt(list.size());
		ETreasureReward reward = list.get(choice);
		return reward;
	}

}
