package com.decoverri.treasureGenerator.config;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.WandGeneratorData;

public class WandGeneratorDataDao {

	private final Session session;

	public WandGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(WandGeneratorData wandGen) {
		session.save(wandGen);
	}

}
