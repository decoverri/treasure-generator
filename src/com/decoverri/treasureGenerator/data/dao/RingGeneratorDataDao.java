package com.decoverri.treasureGenerator.data.dao;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.model.RingGeneratorData;

public class RingGeneratorDataDao {

	private final Session session;

	public RingGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(RingGeneratorData ringGen) {
		session.save(ringGen);
	}

}
