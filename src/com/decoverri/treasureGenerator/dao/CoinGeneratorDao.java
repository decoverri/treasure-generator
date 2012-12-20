package com.decoverri.treasureGenerator.dao;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.CoinGenerator;

public class CoinGeneratorDao {

	private final Session session;

	public CoinGeneratorDao(Session session) {
		this.session = session;
	}

	public void save(CoinGenerator coinGen) {
		session.save(coinGen);
	}

}
