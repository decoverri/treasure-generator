package com.decoverri.treasureGenerator.data.dao;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.model.GemstoneGeneratorData;

public class GemstoneGeneratorDataDao {

	private final Session session;

	public GemstoneGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(GemstoneGeneratorData gemGen) {
		session.save(gemGen);
	}

}
