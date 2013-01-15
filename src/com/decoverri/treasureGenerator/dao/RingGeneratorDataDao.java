package com.decoverri.treasureGenerator.dao;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.generator.RingGeneratorData;

public class RingGeneratorDataDao {

	private final Session session;

	public RingGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(RingGeneratorData ringGen) {
		session.save(ringGen);
	}

}
