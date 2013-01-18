package com.decoverri.treasureGenerator.data.dao;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.model.WandGeneratorData;

public class WandGeneratorDataDao {

	private final Session session;

	public WandGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(WandGeneratorData wandGen) {
		session.save(wandGen);
	}

}
