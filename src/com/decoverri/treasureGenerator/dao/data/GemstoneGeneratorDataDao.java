package com.decoverri.treasureGenerator.dao.data;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.data.GemstoneGeneratorData;

public class GemstoneGeneratorDataDao {

	private final Session session;

	public GemstoneGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(GemstoneGeneratorData gemGen) {
		session.save(gemGen);
	}

}
