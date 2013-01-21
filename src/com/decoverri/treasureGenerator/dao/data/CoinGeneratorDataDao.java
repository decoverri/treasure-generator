package com.decoverri.treasureGenerator.dao.data;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.data.CoinGeneratorData;

public class CoinGeneratorDataDao {

	private final Session session;

	public CoinGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(CoinGeneratorData coinGen) {
		session.save(coinGen);
	}

}
