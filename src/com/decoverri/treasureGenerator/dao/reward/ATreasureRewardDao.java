package com.decoverri.treasureGenerator.dao.reward;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.decoverri.treasureGenerator.model.reward.ATreasureReward;

public class ATreasureRewardDao {

	private final Session session;

	public ATreasureRewardDao(Session session) {
		this.session = session;
	}

	public void save(ATreasureReward reward) {
		session.save(reward);
	}

	@SuppressWarnings("unchecked")
	public ATreasureReward findByValue(int value){
		Criteria criteria = session.createCriteria(ATreasureReward.class);
		criteria.add(Restrictions.eq("value", value));
		List<ATreasureReward> list = criteria.list();
		if (list.isEmpty()) {
			return null;
		}
		ATreasureReward reward = list.get(0);
		return reward;
	}

}
