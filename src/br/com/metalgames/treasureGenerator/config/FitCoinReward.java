package br.com.metalgames.treasureGenerator.config;

import org.hibernate.Session;

import br.com.metalgames.treasureGenerator.dao.CoinRewardDao;
import br.com.metalgames.treasureGenerator.model.CoinReward;

public class FitCoinReward {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public void preencheCoinReward() {
		
		CoinReward coinReward = new CoinReward();
		
		coinReward.setValue(1);

		coinReward.setCpNumberOfDice(5);
		coinReward.setCpBaseDiceSize(10);
		coinReward.setCpMultiplier(1);

		coinReward.setSpNumberOfDice(3);
		coinReward.setSpBaseDiceSize(4);
		coinReward.setSpMultiplier(1);

		CoinRewardDao dao = new CoinRewardDao(session);
		
		dao.save(coinReward);
	}
}
