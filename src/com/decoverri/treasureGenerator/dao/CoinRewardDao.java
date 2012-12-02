package com.decoverri.treasureGenerator.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.decoverri.treasureGenerator.model.CoinReward;

public class CoinRewardDao {

	private final Session session;
	private Transaction transaction;

	public CoinRewardDao(Session session) {
		this.session = session;
		transaction = this.session.getTransaction();
	}

	public void save(CoinReward reward) {
		transaction.begin();
		session.save(reward);
		transaction.commit();
	}

	public CoinReward findByValue(int value) {
		transaction.begin();
		Criteria criteria = session.createCriteria(CoinReward.class);
		criteria.add(Restrictions.eq("value", value));
		CoinReward reward = (CoinReward) criteria.list().get(0);
		transaction.commit();
		return reward;
	}

}
