package com.decoverri.treasureGenerator.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.decoverri.treasureGenerator.model.FTreasureReward;

public class FTreasureRewardDao {

	private final Session session;

	public FTreasureRewardDao(Session session) {
		this.session = session;
	}

	public void save(FTreasureReward reward) {
		session.save(reward);
	}

	@SuppressWarnings("unchecked")
	public FTreasureReward findByValue(int value) {
		Criteria criteria = session.createCriteria(FTreasureReward.class);
		criteria.add(Restrictions.eq("value", value));
		List<FTreasureReward> list = criteria.list();
		if (list.isEmpty()) {
			return null;
		}
		int choice = new Random().nextInt(list.size());
		FTreasureReward reward = list.get(choice);
		return reward;
	}

}
