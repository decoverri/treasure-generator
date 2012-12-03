package com.decoverri.treasureGenerator.dao;

import java.util.List;

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

	@SuppressWarnings("unchecked")
	public CoinReward findByValue(int value){
		CoinReward reward = new CoinReward();
		transaction.begin();
		Criteria criteria = session.createCriteria(CoinReward.class);
		criteria.add(Restrictions.eq("value", value));
		List<CoinReward> list = criteria.list();
		transaction.commit();
		if (list.isEmpty()) {
			return null;
		}
		reward = list.get(0);
		return reward;
	}

}
