package dao;

import model.CoinReward;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class CoinRewardDao {

	private final Session session;
	
	public CoinRewardDao(Session session){
		this.session = session;
	}
	
	public void save(CoinReward reward){
		session.save(reward);
	}
	
	public CoinReward findByValue(int value){
		Criteria criteria = session.createCriteria(CoinReward.class);
		criteria.add(Restrictions.eq("value", value));
		return (CoinReward) criteria.list().get(0);
	}
}
