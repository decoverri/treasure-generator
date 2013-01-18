package com.decoverri.treasureGenerator.reward.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.decoverri.treasureGenerator.reward.model.CTreasureReward;

public class CTreasureRewardDao {

	private final Session session;

	public CTreasureRewardDao(Session session) {
		this.session = session;
	}

	public void save(CTreasureReward reward) {
		session.save(reward);
	}

	@SuppressWarnings("unchecked")
	public CTreasureReward findByValue(int value) {
		Criteria criteria = session.createCriteria(CTreasureReward.class);
		criteria.add(Restrictions.eq("value", value));
		List<CTreasureReward> list = criteria.list();
		if (list.isEmpty()) {
			return null;
		}
		int choice = new Random().nextInt(list.size());
		CTreasureReward reward = list.get(choice);
		return reward;
	}


}