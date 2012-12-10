package com.decoverri.treasureGenerator.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.decoverri.treasureGenerator.model.CoinReward;

public class CoinRewardDao {

	private final Session session;

	public CoinRewardDao(Session session) {
		this.session = session;
	}

	public void save(CoinReward reward) {
		session.save(reward);
	}

	@SuppressWarnings("unchecked")
	public CoinReward findByValue(int value){
		CoinReward reward = new CoinReward();
		Criteria criteria = session.createCriteria(CoinReward.class);
		criteria.add(Restrictions.eq("value", value));
		List<CoinReward> list = criteria.list();
		if (list.isEmpty()) {
			return null;
		}
		reward = list.get(0);
		return reward;
	}

}
