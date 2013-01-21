package com.decoverri.treasureGenerator.dao.data;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.data.WandGeneratorData;

public class WandGeneratorDataDao {

	private final Session session;

	public WandGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(WandGeneratorData wandGen) {
		session.save(wandGen);
	}

}
