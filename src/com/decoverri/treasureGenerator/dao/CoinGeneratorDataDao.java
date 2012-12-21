package com.decoverri.treasureGenerator.dao;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.CoinGeneratorData;

public class CoinGeneratorDataDao {

	private final Session session;

	public CoinGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(CoinGeneratorData coinGen) {
		session.save(coinGen);
	}

}
