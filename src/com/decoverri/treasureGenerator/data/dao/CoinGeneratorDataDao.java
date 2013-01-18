package com.decoverri.treasureGenerator.data.dao;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.model.CoinGeneratorData;

public class CoinGeneratorDataDao {

	private final Session session;

	public CoinGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(CoinGeneratorData coinGen) {
		session.save(coinGen);
	}

}
