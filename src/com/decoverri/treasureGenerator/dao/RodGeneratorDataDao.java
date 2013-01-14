package com.decoverri.treasureGenerator.dao;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.RodGeneratorData;

public class RodGeneratorDataDao {

	private final Session session;

	public RodGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(RodGeneratorData rodGen) {
		session.save(rodGen);
	}

}
