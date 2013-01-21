package com.decoverri.treasureGenerator.dao.reward;

import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.decoverri.treasureGenerator.model.reward.GTreasureReward;

public class GTreasureRewardDao {

	private final Session session;

	public GTreasureRewardDao(Session session) {
		this.session = session;
	}

	public void save(GTreasureReward reward) {
		session.save(reward);
	}

	@SuppressWarnings("unchecked")
	public GTreasureReward findByValue(int value) {
		Criteria criteria = session.createCriteria(GTreasureReward.class);
		criteria.add(Restrictions.eq("value", value));
		List<GTreasureReward> list = criteria.list();
		if (list.isEmpty()) {
			return null;
		}
		int choice = new Random().nextInt(list.size());
		GTreasureReward reward = list.get(choice);
		return reward;
	}

}
